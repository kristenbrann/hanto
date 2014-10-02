/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package hanto.student_TCA_KLB.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * @author tcarmstrong klbrann
 *
 */
public class Crab implements HantoPiece {

	HantoPlayerColor color;

	/**
	 * Constructor for a Crab
	 * 
	 * @param color
	 *            The Player color of the Crab
	 */
	public Crab(HantoPlayerColor color) {
		this.color = color;
	}

	@Override
	public HantoPlayerColor getColor() {
		return color;
	}

	@Override
	public HantoPieceType getType() {
		return HantoPieceType.CRAB;
	}

	@Override
	public String toString() {
		return color.name() + "\t"
				+ HantoPieceType.CRAB.getPrintableName();
	}

	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof Crab) {
			isEqual = equals((Crab) o);
		}
		return isEqual;
	}

	@Override
	public int hashCode() {
		return super.hashCode();

	}

	/**
	 * Determines if the given butterfly is the same as this butterfly
	 * 
	 * @param crab
	 *            the Crab to compare
	 * @return true if the two butterflies are equivalent
	 */
	public boolean equals(Crab crab) {
		return color == crab.getColor();
	}

}
