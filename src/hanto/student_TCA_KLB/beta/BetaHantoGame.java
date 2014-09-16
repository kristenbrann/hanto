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
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;
import hanto.student_TCA_KLB.common.Sparrow;

/**
 * @author tcarmstrong klbrann
 * 
 */
public class BetaHantoGame extends AbsHantoGame {

	private final int maxTurns = 11;
	private HantoCoordinateImpl blueButterfly;
	private HantoCoordinateImpl redButterfly;

	public BetaHantoGame(final HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
	}

	protected void placePiece(final HantoPieceType pieceType, final HantoCoordinate to)
			throws InvalidPieceTypeException {

		final HantoPlayerColor pc = determineColor();

		final HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);

		switch (pieceType) {
		case BUTTERFLY:

			final HantoPiece bfly = new Butterfly(pc);
			theBoard.put(hcTo, bfly);

			switch (pc) {
			case BLUE:
				blueButterfly = hcTo;
				break;

			case RED:
				redButterfly = hcTo;
				break;
			}

			break;

		case SPARROW:
			theBoard.put(hcTo, new Sparrow(pc));
			break;

		default:
			throw new InvalidPieceTypeException(pieceType);
		}

	}

	@Override
	protected void validateMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws InvalidTargetLocationException, InvalidPieceTypeException,
			InvalidSourceLocationException {

		if (to == null) {
			throw new InvalidTargetLocationException("Location cannot be null");
		}

		final HantoPlayerColor pc = determineColor();

		if (getPieceAt(to) != null) {
			throw new InvalidTargetLocationException(to, "Piece already there");
		}

		if (from == null) {
			if (theBoard.isEmpty()) {
				if (!isHome(to)) {
					throw new InvalidTargetLocationException(to,
							"First piece must be placed at " + home.toString());
				}

			} else {
				if (pieceType.equals(HantoPieceType.BUTTERFLY)
						&& theBoard.containsValue(new Butterfly(pc))) {
					throw new InvalidPieceTypeException(pieceType, "Player "
							+ pc.name() + " has already placed a butterfly.");

				} else {
					if (turn == 6 || turn == 7) {
						if (!theBoard.containsValue(new Butterfly(pc))) {
							throw new InvalidPieceTypeException(
									pieceType,
									"Player "
											+ pc.name()
											+ " must place a butterfly by the fourth turn");
						}

					} else if (!hasAdjacentPiece(to)) {
						throw new InvalidTargetLocationException(to,
								"Piece must be placed adjacent to another piece.");

					}
				}
			}
		} else {
			throw new InvalidSourceLocationException(from,
					"Cannot move a piece, can only place");

		}

	}

	@Override
	protected MoveResult resolve() {
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

	@Override
	protected HantoPlayerColor determineColor() {
		HantoPlayerColor result = null;
		if (turn % 2 == 0) {
			switch (movesFirst) {
			case BLUE:
				result = HantoPlayerColor.BLUE;
				break;

			case RED:
				result = HantoPlayerColor.RED;
				break;
			}
		} else {
			switch (movesFirst) {
			case BLUE:
				result = HantoPlayerColor.RED;
				break;

			case RED:
				result = HantoPlayerColor.BLUE;
				break;
			}
		}
		return result;
	}
}
