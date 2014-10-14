package hanto.student_TCA_KLB.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

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
