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
	
	public HantoCoordinateImpl (HantoCoordinate c) {
		x = c.getX();
		y = c.getY();
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

	public boolean isAdjacent(HantoCoordinate c) {
		return getDistanceTo(c) == 1;
	}
	
	/**
	 * @param from The Coordinate where we are calculating the distance from
	 * @param to The Coordinate where we are calculating the distance to
	 * @return The number of tiles the two tiles are away from each other. If they are adjacent,
	 * 			then it should return 1.
	 */
	public int getDistanceTo(HantoCoordinate to){
		int dx = to.getX() - x;
		int dy = to.getY() - y;
		
		int distance;
		
		if ( sameSign (dx, dy) ) {
			distance = Math.abs(dx + dy);
		} else {
			distance = Math.max(Math.abs(dx), Math.abs(dy));
		}
		return distance;
	}
	
	private boolean sameSign(int x, int y) {
		return (x < 0 && y < 0) || ( y >= 0 && x >= 0 );
	}


}
