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
package hanto.student_TCA_KLB.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * 
 *
 */
public class Butterfly implements HantoPiece{
	
	HantoPlayerColor color;
	
	/** Constructor for a Butterfly
	 * 
	 * @param color The Player color of the butterfly
	 */
	public Butterfly(HantoPlayerColor color) {
		this.color = color;
	}

	@Override
	public HantoPlayerColor getColor() {
		return color;
	}

	@Override
	public HantoPieceType getType() {
		return HantoPieceType.BUTTERFLY;
	}
	
	@Override
	public String toString() {
		return color.name() + "\t" + HantoPieceType.BUTTERFLY.getPrintableName();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof Butterfly) {
			isEqual = equals((Butterfly) o);
		}
		return isEqual;
	}
	
	/** Determines if the given butterfly is the same as this butterfly
	 * @param bfly the Butterfly to compare
	 * @return
	 */
	public boolean equals(Butterfly bfly) {
		return color == bfly.getColor();
	}

}
