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
 * 
 */
package hanto.student_TCA_KLB.alpha;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;

/**
 * 
 *
 */
public class AlphaHantoGame extends AbsHantoGame {

	public AlphaHantoGame() {
		home = new HantoCoordinateImpl(0, 0);
	}

	@Override
	public MoveResult makeMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws HantoException {
		MoveResult result = MoveResult.OK;
		final HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);

		if (pieceType == HantoPieceType.BUTTERFLY) {
			if (from == null) {
				if (theBoard.isEmpty()) {
					if (isHome(hcTo)) {
						theBoard.put(hcTo, new Butterfly(HantoPlayerColor.BLUE));
						result = MoveResult.OK;
					} else {
						throw new HantoException(
								"First piece must be placed at (0,0).");
					}
				} else {
					if (hcTo.isAdjacent(home)) {
						theBoard.put(hcTo, new Butterfly(HantoPlayerColor.RED));
						result = MoveResult.DRAW;
					} else {
						throw new HantoException(
								"Second piece must be adjacent to (0,0)");
					}
				}
			} else {
				throw new HantoException("Cannot move a piece, can only place.");
			}
		} else {
			throw new HantoException("Can only place Butterflys,  and a "
					+ pieceType.getPrintableName() + " was given.");
		}

		return result;
	}
}
