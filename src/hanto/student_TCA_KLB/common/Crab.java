package hanto.student_TCA_KLB.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

public class Crab implements HantoPiece {

	HantoPlayerColor color;

	/**
	 * Constructor for a Butterfly
	 * 
	 * @param color
	 *            The Player color of the butterfly
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
	 * @param bfly
	 *            the Butterfly to compare
	 * @return true if the two butterflies are equivelent
	 */
	public boolean equals(Crab bfly) {
		return color == bfly.getColor();
	}

}
