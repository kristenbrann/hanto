package hanto.studentxxxx.beta;

import java.util.Map.Entry;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPiece;
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
		
		HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);

		if (theBoard.isEmpty()) {
			if (isHome(hcTo)) {
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
		else {
			boolean isAdjacent = false;
			for(Entry<HantoCoordinate, HantoPiece> entry : this.theBoard.entrySet()){
				HantoCoordinateImpl entryCoord = new HantoCoordinateImpl(entry.getKey().getX(),entry.getKey().getY());
				if(areAdjacent(entryCoord,hcTo)){
					isAdjacent = true;
				}
			}
			if(isAdjacent){
				switch(pieceType) {
				case BUTTERFLY:
					theBoard.put(to, new Butterfly(HantoPlayerColor.BLUE));
					break;
				case SPARROW:
					theBoard.put(to, new Sparrow(HantoPlayerColor.BLUE));
				default:
					break;
				}
			}
			else {
				throw new HantoException("Piece must be placed adjacent to another piece.");
			}
		}
		return result;
	}

}
