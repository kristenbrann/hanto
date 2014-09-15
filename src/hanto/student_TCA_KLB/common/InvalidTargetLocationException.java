package hanto.student_TCA_KLB.common;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;

public class InvalidTargetLocationException extends HantoException {

	public InvalidTargetLocationException(String message) {
		super(message);
	}

	public InvalidTargetLocationException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidTargetLocationException(HantoCoordinate target) {
		super("Invalid destination location : "
				+ new HantoCoordinateImpl(target).toString() + ".");
	}
}
 