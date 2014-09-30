package hanto.student_TCA_KLB.delta;

import java.util.HashMap;
import java.util.Map;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;

public class DeltaHantoGame extends AbsHantoGame {

	public DeltaHantoGame(HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
		maxTurns = 39;
	}

	@Override
	protected void validateMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {

		switch (pieceType) {

		case SPARROW:
			if (turn >= 6 ) {
				if (!theBoard.containsValue(pieceFactory.makeHantoPiece(HantoPieceType.BUTTERFLY, currentPlayer))) {
					throw new InvalidPieceTypeException(
							pieceType,
							"Player "
									+ currentPlayer.name()
									+ " must place a butterfly by the fourth turn");
				}
			}
		case BUTTERFLY:
			if (getPieceAt(to) == null) {
				if (theBoard.isEmpty()) {
					if (from == null) {
						if (!isHome(to)) {
							throw new InvalidTargetLocationException(to,
									"First piece must be placed at "
											+ home.toString());
						}
					} else {
						throw new InvalidSourceLocationException(from,
								"Cannot move a piece if no pieces are on the board");
					}
				} else {
					if (from != null) {
						HantoCoordinateImpl hcFrom = new HantoCoordinateImpl(
								from);
						if (!hcFrom.isAdjacentTo(to)) {
							throw new InvalidTargetLocationException(to,
									"Piece can only move one hex.");
						} else {
							boolean canSlide = false;
							for (HantoCoordinate c : hcFrom
									.getAdjacentCoordinates()) {
								HantoCoordinateImpl next = new HantoCoordinateImpl(
										c);
								if (next.isAdjacentTo(to)
										&& getPieceAt(next) == null) {
									canSlide = true;
								}
							}
							{
								Map<HantoCoordinateImpl, HantoPiece> temp = new HashMap<HantoCoordinateImpl, HantoPiece>(
										theBoard);
								temp.remove(from);
								temp.put(new HantoCoordinateImpl(to),
										pieceFactory.makeHantoPiece(pieceType,
												currentPlayer));
								canSlide = canSlide
										&& boardIsContinuous(temp, to);
							}

							if (!canSlide) {
								throw new InvalidTargetLocationException(to,
										"Cannot move from " + from + " to "
												+ to + ".");
							}
						}
					} else {
						if (to != null) {
							if (turn > 1) {
								HantoCoordinateImpl hcTo = new HantoCoordinateImpl(
										to);
								boolean nextToOpposingPiece = false;
								for (HantoCoordinate adjacent : hcTo
										.getAdjacentCoordinates()) {
									if (getPieceAt(adjacent) != null
											&& getPieceAt(adjacent).getColor() != currentPlayer) {
										nextToOpposingPiece = true;
									}
								}
								if (nextToOpposingPiece) {
									throw new InvalidTargetLocationException(
											to,
											"Piece cannot be placed next adjacent to a piece of the opposing color.");
								}
							}
						}
					}
				}
			} else {
				throw new InvalidTargetLocationException(to,
						"A piece already exists at that location.");
			}
			break;
		default:
			throw new InvalidPieceTypeException(pieceType,
					"Can only use Butterflies and Sparrows");
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
