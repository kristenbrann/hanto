package hanto.student_TCA_KLB.common;

import hanto.common.HantoException;
import hanto.common.HantoPieceType;

public class InvalidPieceTypeException extends HantoException {

	public InvalidPieceTypeException(String message) {
		super(message);
	}

	public InvalidPieceTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPieceTypeException(HantoPieceType expected,
			HantoPieceType actual) {
		super("Expected a " + expected.getPrintableName() + ", but got a "
				+ actual.getPrintableName() + ".");
	}
}
