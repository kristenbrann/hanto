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
 * @author tcarmstrong
 *
 */
public class InvalidSourceLocationException extends HantoException {

	public InvalidSourceLocationException(String message) {
		super(message);
	}
	
	/**
	 * @param target the Source Coordinate which is being improperly used
	 * @param message
	 */
	public InvalidSourceLocationException(HantoCoordinate target, String message) {
		super("Invalid source location : "
				+ new HantoCoordinateImpl(target).toString() + "\t" + message + ".");
	}

}
