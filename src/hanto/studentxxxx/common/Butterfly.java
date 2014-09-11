/**
 * 
 */
package hanto.studentxxxx.common;

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * 
 *
 */
public class Butterfly implements HantoPiece{
	
	HantoPlayerColor color;
	
	public Butterfly(HantoPlayerColor color) {
		
	}

	@Override
	public HantoPlayerColor getColor() {
		return color;
	}

	@Override
	public HantoPieceType getType() {
		return HantoPieceType.BUTTERFLY;
	}

}
