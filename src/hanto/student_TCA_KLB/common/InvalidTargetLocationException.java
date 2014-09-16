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

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;

/**
 * @author tcarmstrong klbrann
 *
 */
public class InvalidTargetLocationException extends HantoException {

	public InvalidTargetLocationException(String message) {
		super("Invalid destination location : " + message);
	}
	
	/**
	 * @param target the target coordinate that is improperly used
	 * @param message accompanied message
	 */
	public InvalidTargetLocationException(HantoCoordinate target, String message) {
		super("Invalid Target location : "
				+ new HantoCoordinateImpl(target).toString() + "\t" + message + ".");
	}
}
 