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
 */

package hanto.studentxxxx.common;

import java.util.HashMap;
import java.util.Map;

import hanto.common.HantoCoordinate;
import hanto.common.HantoGame;
import hanto.common.HantoPiece;

/**
 * @author Nucleus
 *
 */
public abstract class AbsHantoGame implements HantoGame{

	//Every hanto game will have a HashMap to represent the Board
	protected Map<HantoCoordinate, HantoPiece> theBoard;
	
	protected HantoCoordinate home;
	
	protected AbsHantoGame() {
		theBoard = new HashMap<HantoCoordinate, HantoPiece>();
	}
	

	/* (non-Javadoc) <!-- // $codepro.audit.disable codeInComments -->
	 * @see hanto.common.HantoGame#getPieceAt(hanto.common.HantoCoordinate)
	 */
	public HantoPiece getPieceAt(HantoCoordinate where) {
		return theBoard.get(where);
	}

	/* (non-Javadoc) // $codepro.audit.disable codeInComments
	 * @see hanto.common.HantoGame#getPrintableBoard()
	 */
	public String getPrintableBoard() {
		StringBuilder output = new StringBuilder();
		for(Map.Entry<HantoCoordinate, HantoPiece> entry : theBoard.entrySet()){
			output.append(entry.getKey().toString());
			output.append("\t:\t");
			output.append(entry.getValue().toString());
			output.append('\n');
		}
		
		return output.toString();
	}
	
	/**
	 * @param c The coordinate to check if at the 'home' position
	 * @return returns true if the tested coordinate is 'home' : (0,0)
	 */
	public boolean isHome(HantoCoordinateImpl c){
		return c.equals(home);
	}
}
