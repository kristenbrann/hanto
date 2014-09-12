/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 * @author tcarmstrong klbrann
 * 
 */
package hanto.studentxxxx.alpha;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.Butterfly;
import hanto.studentxxxx.common.HantoCoordinateImpl;

/**
 * 
 *
 */
public class AlphaHantoGame implements HantoGame{
	
	private Map<HantoCoordinate, HantoPiece> theBoard;
	
	
	public AlphaHantoGame() {
		theBoard = new HashMap<HantoCoordinate, HantoPiece>();
	}

	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		MoveResult result = MoveResult.OK;
		
		
		if(theBoard.isEmpty()){
			if(isHome(to)){
				theBoard.put(to, new Butterfly(HantoPlayerColor.BLUE));
				result = MoveResult.OK;
			}
			else{
				throw new HantoException("First piece must be placed at (0,0).");
			}
		} else {
			if(areAdjacent(new HantoCoordinateImpl(0,0),to)){
				theBoard.put(to, new Butterfly(HantoPlayerColor.RED));
				result = MoveResult.DRAW;
			}
			else{
				throw new HantoException("Second piece must be adjacent to (0,0)");
			}
		}
		
		return result;
	}

	@Override
	public HantoPiece getPieceAt(HantoCoordinate where) {
		return theBoard.get(where);
	}

	@Override
	public String getPrintableBoard() {
		StringBuilder output = new StringBuilder();
		for(Map.Entry<HantoCoordinate, HantoPiece> entry : theBoard.entrySet()){
			output.append(entry.getKey().toString());
			output.append("\t:\t");
			output.append(entry.getValue().toString());
			output.append("\n");
		}
		
		return output.toString();
	}
	
	public boolean isHome(HantoCoordinate c){
		return c.getX()==0 && c.getY()==0;
	}
	
	public boolean areAdjacent(HantoCoordinate from, HantoCoordinate to){
		return getDistance(from,to)==1;
	}
	
	public int getDistance(HantoCoordinate from, HantoCoordinate to){
		int distance = Math.max(
							Math.abs(to.getY() - from.getY()),
							Math.max(
									Math.abs(to.getX() - from.getX()),
									Math.abs((to.getX()-to.getY()*-1-(from.getX()-from.getY())*-1)))
							);
		return distance;
	}

}
