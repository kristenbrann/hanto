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
public class Horse implements HantoPiece {

	HantoPlayerColor color;

	/**
	 * Constructor for a Horse
	 * 
	 * @param color
	 *            The Player color of the Crab
	 */
	public Horse(HantoPlayerColor color) {
		this.color = color;
	}

	@Override
	public HantoPlayerColor getColor() {
		return color;
	}

	@Override
	public HantoPieceType getType() {
		return HantoPieceType.HORSE;
	}

	@Override
	public String toString() {
		return color.name() + "\t"
				+ HantoPieceType.HORSE.getPrintableName();
	}

	@Override
	public boolean equals(Object o) {
		boolean isEqual = false;
		if (o instanceof Horse) {
			isEqual = equals((Horse) o);
		}
		return isEqual;
	}

	@Override
	public int hashCode() {
		return super.hashCode();

	}

	/**
	 * Determines if the given Horse is the same as this Horse
	 * 
	 * @param horse
	 *            the horse to compare
	 * @return true if the two Horses are equivalent
	 */
	public boolean equals(Horse horse) {
		return color == horse.getColor();
	}
}
