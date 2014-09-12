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
	 * @param from The Coordinate where we are calculating the distance from
	 * @param to The Coordinate where we are calculating the distance to
	 * @return The number of tiles the two tiles are away from each other. If they are adjacent,
	 * 			then it should return 1.
	 */
	public int getDistance(HantoCoordinate from, HantoCoordinate to){
		int distance = Math.max(
							Math.abs(to.getY() - from.getY()),
							Math.max(
									Math.abs(to.getX() - from.getX()),
									Math.abs((to.getX()-to.getY()*-1-(from.getX()-from.getY())*-1)))
							);
		return distance;
	}
	
	/**
	 * @param c The coordinate to check if at the 'home' position
	 * @return returns true if the tested coordinate is 'home' : (0,0)
	 */
	public boolean isHome(HantoCoordinate c){
		return c.equals(home);
	}
}
