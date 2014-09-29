package hanto.student_TCA_KLB.gamma;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;

public class GammaHantoGame extends AbsHantoGame {

	public GammaHantoGame(HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
		maxTurns = Integer.MAX_VALUE;
	}

	@Override
	protected void validateMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {

		if (theBoard.isEmpty()) {
			if (from == null) {
				if (!isHome(to)) {
					throw new InvalidTargetLocationException(to,
							"First piece must be placed at " + home.toString());
				}
			} else {
				throw new InvalidSourceLocationException(from,
						"Cannot move a piece if no pieces are on the board");
			}
		} else {
			if (from != null) {
				HantoCoordinateImpl hcFrom = new HantoCoordinateImpl(from);
				if (!hcFrom.isAdjacentTo(to)) {
					throw new InvalidTargetLocationException(to,
							"Piece can only move one hex.");
				} else {
					boolean canSlide = false;
					for (HantoCoordinate c : hcFrom.getAdjacentCoordinates()) {
						HantoCoordinateImpl next = new HantoCoordinateImpl(c);
						if (next.isAdjacentTo(to) && getPieceAt(next) == null) {
							canSlide = true;
						}
					}
					if (!canSlide) {
						throw new InvalidTargetLocationException(to,
								"Not enough space to slide from " + from
										+ " to " + to + ".");
					}
				}
			} else {
				if (to != null) {
					HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);
					boolean nextToOpposingPiece = false;
					for (HantoCoordinate adjacent : hcTo
							.getAdjacentCoordinates()) {
						if (getPieceAt(adjacent) != null
								&& getPieceAt(adjacent).getColor() != currentPlayer) {
							nextToOpposingPiece = true;
						}
					}
					if (nextToOpposingPiece) {
						throw new InvalidTargetLocationException(to,
								"Piece cannot be placed next adjacent to a piece of the opposing color.");
					}
				}
			}

		}
	}


	@Override
	protected MoveResult determineMoveResult() {
		MoveResult result = MoveResult.OK;
		if (redButterfly != null && isSurrounded(redButterfly)) {
			result = MoveResult.BLUE_WINS;
		} else if (blueButterfly != null && isSurrounded(blueButterfly)) {
			result = MoveResult.RED_WINS;
		} else if (turn == maxTurns) {
			result = MoveResult.DRAW;
		}
		if ((redButterfly != null && isSurrounded(redButterfly))
				&& (blueButterfly != null && isSurrounded(blueButterfly))) {
			result = MoveResult.DRAW;
		}
		return result;
	}

}
