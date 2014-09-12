/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package hanto.studentxxxx.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * @author tcarmstrong klbrann
 *
 */
public class Sparrow implements HantoPiece {
	
	HantoPlayerColor color;

	/** Constructor for the Sparrow piece
	 * 
	 * @param color The player color for the Sparrow Piece
	 */
	public Sparrow(HantoPlayerColor color) {
		this.color = color;
	}
	
	@Override
	public HantoPlayerColor getColor() {
		return color;
	}

	@Override
	public HantoPieceType getType() {
		return HantoPieceType.SPARROW;
	}
	
	@Override
	public String toString() {
		return color.name() + "\tSparrow";
	}

}
