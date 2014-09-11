/**
 * 
 */
package hanto.studentxxxx.alpha;

import java.util.HashMap;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.Butterfly;

/**
 * 
 *
 */
public class AlphaHantoGame implements HantoGame{
	
	private HashMap<HantoCoordinate, HantoPiece> theBoard;
	
	
	public AlphaHantoGame() {
		theBoard = new HashMap<HantoCoordinate, HantoPiece>();
	}

	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		MoveResult result = MoveResult.OK;
		
		
		if(theBoard.isEmpty()){
			theBoard.put(to, new Butterfly(HantoPlayerColor.BLUE));
			result = MoveResult.OK;
		} else {
			theBoard.put(to, new Butterfly(HantoPlayerColor.RED));
			result = MoveResult.DRAW;
		}
		
		return result;
	}

	@Override
	public HantoPiece getPieceAt(HantoCoordinate where) {
		return theBoard.get(where);
	}

	@Override
	public String getPrintableBoard() {
		// TODO Auto-generated method stub
		return null;
	}

}
