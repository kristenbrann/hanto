package hanto.student_TCA_KLB.gamma;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;
import hanto.student_TCA_KLB.common.Sparrow;

public class GammaHantoGame extends AbsHantoGame {

	public GammaHantoGame(HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
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
		}
	}

	@Override
	protected void placePiece(HantoPieceType pieceType, HantoCoordinate to)
			throws HantoException {

		HantoPiece pieceToPlace = null;
		switch (pieceType) {
		case BUTTERFLY:
			pieceToPlace = new Butterfly(currentPlayer);
			break;
		case SPARROW:
			pieceToPlace = new Sparrow(currentPlayer);
			break;
		default:
			break;
		}

		theBoard.put(new HantoCoordinateImpl(to), pieceToPlace);
	}

	@Override
	protected MoveResult determineMoveResult() {
		// TODO Auto-generated method stub
		return MoveResult.OK;
	}

}
