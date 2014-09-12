/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 * @author tcarmstrong klbrann
 */
package hanto.studentxxxx.common;

import hanto.common.*;

/**
 * @author Nucleus
 *
 */
public class HantoCoordinateImpl implements HantoCoordinate{
	
	
	int x, y;
	
	/**
	 * Constructor for the implementation of HantoCoordinate
	 * 
	 * @param x The x value of the coordinate (using hex style)
	 * @param y the y value of the coordinate (using hex style)
	 */
	public HantoCoordinateImpl (int x, int y){
		this.x = x;
		this.y = y;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	boolean equals(HantoCoordinate c) {
		return (x == c.getX()) && (y == c.getY());
	}


}
