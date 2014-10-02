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

package hanto.student_TCA_KLB.beta;

import hanto.common.HantoCoordinate;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;

/**
 * @author tcarmstrong klbrann
 * 
 */
public class BetaHantoGame extends AbsHantoGame {


	public BetaHantoGame(final HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
		maxTurns = 11;
	}

	@Override
	protected void validateMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws InvalidTargetLocationException, InvalidPieceTypeException,
			InvalidSourceLocationException {

		if (to == null) {
			throw new InvalidTargetLocationException("Location cannot be null");
		}

		if (getPieceAt(to) != null) {
			throw new InvalidTargetLocationException(to, "Piece already there");
		}

		if (from == null) {
			switch(pieceType) {
			case SPARROW:
			case BUTTERFLY:
			if (theBoard.isEmpty()) {
				if (!isHome(to)) {
					throw new InvalidTargetLocationException(to,
							"First piece must be placed at " + home.toString());
				}

			} else {
				if (pieceType.equals(HantoPieceType.BUTTERFLY)
						&& theBoard.containsValue(new Butterfly(currentPlayer))) {
					throw new InvalidPieceTypeException(pieceType, "Player "
							+ currentPlayer.name() + " has already placed a butterfly.");

				} else {
					if (turn == 6 || turn == 7) {
						if (!theBoard.containsValue(new Butterfly(currentPlayer))) {
							throw new InvalidPieceTypeException(
									pieceType,
									"Player "
											+ currentPlayer.name()
											+ " must place a butterfly by the fourth turn");
						}

					} else if (!hasAdjacentPiece(to)) {
						throw new InvalidTargetLocationException(to,
								"Piece must be placed adjacent to another piece.");

					}
				}
			}
			break;
			default:
				throw new InvalidPieceTypeException(pieceType, "Can only use Butterflies and Sparrows in Beta.");
			}
		} else {
			throw new InvalidSourceLocationException(from,
					"Cannot move a piece, can only place");

		}

	}

	@Override
	protected MoveResult determineMoveResult() {
		MoveResult result = MoveResult.OK;
		if (redButterfly != null && isSurrounded(redButterfly)) {
			result = MoveResult.BLUE_WINS;
		} else if (blueButterfly != null && isSurrounded(blueButterfly)) {
			result = MoveResult.RED_WINS;
		} else if (turn == maxTurns) {
			result = MoveResult.DRAW;
		}
		if ((redButterfly != null && isSurrounded(redButterfly))
				&& (blueButterfly != null && isSurrounded(blueButterfly))) {
			result = MoveResult.DRAW;
		}
		return result;
	}
}
