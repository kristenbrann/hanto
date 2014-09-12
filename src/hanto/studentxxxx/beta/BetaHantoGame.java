package hanto.studentxxxx.beta;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.AbsHantoGame;
import hanto.studentxxxx.common.Butterfly;
import hanto.studentxxxx.common.HantoCoordinateImpl;
import hanto.studentxxxx.common.Sparrow;

public class BetaHantoGame extends AbsHantoGame {

	public BetaHantoGame() {
		home = new HantoCoordinateImpl(0, 0);
	}

	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		MoveResult result = MoveResult.OK;

		if (theBoard.isEmpty()) {
			if (isHome(to)) {
				switch (pieceType) {
				case BUTTERFLY:
					theBoard.put(to, new Butterfly(HantoPlayerColor.BLUE));
					break;
				case SPARROW:
					theBoard.put(to, new Sparrow(HantoPlayerColor.BLUE));
				default:
					break;
				}
				result = MoveResult.OK;
			} else {
				throw new HantoException("First piece must be placed at "
						+ home.toString());
			}
		}
		return result;
	}

	@Override
	public int getDistance(HantoCoordinate from, HantoCoordinate to) {
		// TODO Auto-generated method stub
		return 0;
	}

}
