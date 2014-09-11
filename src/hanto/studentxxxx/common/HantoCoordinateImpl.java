/**
 * 
 */
package hanto.studentxxxx.common;

import hanto.common.*;

/**
 * @author Nucleus
 *
 */
public class HantoCoordinateImpl implements HantoCoordinate{
	
	
	int x, y;
	
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

}
