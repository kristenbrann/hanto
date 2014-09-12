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

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.AbsHantoGame;
import hanto.studentxxxx.common.Butterfly;
import hanto.studentxxxx.common.HantoCoordinateImpl;

/**
 * 
 *
 */
public class AlphaHantoGame extends AbsHantoGame{
	
	public AlphaHantoGame() {
		home = new HantoCoordinateImpl(0, 0);
	}

	@Override
	public MoveResult makeMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {
		MoveResult result = MoveResult.OK;
		HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);
		
		if(theBoard.isEmpty()){
			if(isHome(hcTo)){
				theBoard.put(to, new Butterfly(HantoPlayerColor.BLUE));
				result = MoveResult.OK;
			}
			else{
				throw new HantoException("First piece must be placed at (0,0).");
			}
		} else {
			if(hcTo.isAdjacent(home)){
				theBoard.put(to, new Butterfly(HantoPlayerColor.RED));
				result = MoveResult.DRAW;
			}
			else{
				throw new HantoException("Second piece must be adjacent to (0,0)");
			}
		}
		
		return result;
	}
	

	
	/** Checks to see if two tiles are adjacent to each other
	 * 
	 * @param from The tile to determine if adjacent from
	 * @param to   The tile to determine if adjacent to
	 * @return  true if the two tiles are adjacent (touching)
	 */
	public boolean areAdjacent(HantoCoordinateImpl from, HantoCoordinateImpl to){
		return from.getDistanceTo( to ) == 1;
	}

}