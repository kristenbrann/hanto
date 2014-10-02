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

/**
 * @author tcarmstrong klbrann
 *
 */
public class GameNotInProgressException extends HantoException {
	
	/**
	 * @param type the invalid type being used
	 */
	public GameNotInProgressException() {
		super("Game is not in progress; moves cannot be made.");
	}
}
