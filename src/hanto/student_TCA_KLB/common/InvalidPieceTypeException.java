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

import hanto.common.HantoException;
import hanto.common.HantoPieceType;

/**
 * @author tcarmstrong klbrann
 *
 */
public class InvalidPieceTypeException extends HantoException {
	
	/**
	 * @param type the invalid type being used
	 * @param message accompanied string
	 */
	public InvalidPieceTypeException(HantoPieceType type, String message) {
		super("Invalid Piece Type : " + type.getPrintableName() + "\t" + message + ".");
	}
	
	/**
	 * @param type the invalid type being used
	 */
	public InvalidPieceTypeException(HantoPieceType type) {
		super("Invalid Piece Type : " + type.getPrintableName() + ".");
	}
}
