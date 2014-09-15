package hanto.student_TCA_KLB.common;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;

public class InvalidSourceLocationException extends HantoException {

	public InvalidSourceLocationException(String message) {
		super(message);
	}

	public InvalidSourceLocationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidSourceLocationException(HantoCoordinate target) {
		super("Invalid source location : "
				+ new HantoCoordinateImpl(target).toString() + ".");
	}

}
