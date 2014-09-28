// $codepro.audit.disable indentCodeWithinBlocks
/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package hanto.student_TCA_KLB.alpha;

import hanto.common.HantoCoordinate;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;

/**
 * @author tcarmstrong klbrann
 *
 */
public class AlphaHantoGame extends AbsHantoGame {

	public AlphaHantoGame(final HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
	}

	protected void validateMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws InvalidTargetLocationException,
			InvalidSourceLocationException, InvalidPieceTypeException {
		switch (pieceType) {
		case BUTTERFLY:
			if (from == null) {
				if (theBoard.isEmpty()) {
					if (!isHome(to)) {
						throw new InvalidTargetLocationException(
								"First piece must be placed at "
										+ home.toString());
					}
				} else {
					if (!hasAdjacentPiece(to)) {
						throw new InvalidTargetLocationException(to,
								"Second piece must be adjacent to "
										+ home.toString());
					}
				}
			} else {
				throw new InvalidSourceLocationException(
						"Cannot move a piece, can only place.");
			}
			break;
		default:
			throw new InvalidPieceTypeException(pieceType,
					"Can only place Butterflies");
		}

	}

	@Override
	protected MoveResult determineMoveResult() {
		MoveResult result;
		if (turn == 0) {
			result = MoveResult.OK;
		} else {
			result = MoveResult.DRAW;
		}
		return result;
	}

}
