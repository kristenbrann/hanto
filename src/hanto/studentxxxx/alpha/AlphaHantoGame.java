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
	
	private Map<HantoCoordinate, HantoPiece> theBoard;
	
	
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
