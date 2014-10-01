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

import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;

/**
 * @author tcarmstrong klbrann
 *
 */
public class HantoPieceFactory {

	private static final HantoPieceFactory INSTANCE = new HantoPieceFactory();

	/**
	 * default private constructor
	 */
	private HantoPieceFactory() {
	}

	/**
	 * @return the instance
	 */
	public static HantoPieceFactory getInstance() {
		return INSTANCE;
	}

	/**
	 * Factory method that returns the appropriately configured Hanto game.
	 * 
	 * @param pieceId
	 *            The piece type desired.
	 * @param color
	 *            The color the piece belongs to
	 * @return the Piece instance
	 */
	public HantoPiece makeHantoPiece(HantoPieceType pieceId,
			HantoPlayerColor color) {
		HantoPiece piece = null;
		switch (pieceId) {
		case BUTTERFLY:
			piece = new Butterfly(color);
			break;
		case CRAB:
			piece = new Crab(color);
		case CRANE:
			break;
		case DOVE:
			break;
		case HORSE:
			break;
		case SPARROW:
			piece = new Sparrow(color);
			break;
		default:
			break;
		}
		return piece;
	}

}
