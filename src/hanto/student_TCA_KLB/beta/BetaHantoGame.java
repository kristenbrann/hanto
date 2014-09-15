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
import hanto.common.HantoException;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.Sparrow;

/**
 * @author tcarmstrong klbrann
 * 
 */
public class BetaHantoGame extends AbsHantoGame {

	private int turn;
	private final int maxTurns = 11;
	private HantoCoordinateImpl blueButterfly;
	private HantoCoordinateImpl redButterfly;

	public BetaHantoGame() {
		home = new HantoCoordinateImpl(0, 0);
		turn = 0;
	}

	@Override
	public MoveResult makeMove(final HantoPieceType pieceType,
			final HantoCoordinate from, final HantoCoordinate to)
			throws HantoException {
		MoveResult result = MoveResult.OK;
		final HantoPlayerColor pc = determineColor();
		HantoCoordinateImpl hcTo = null;
		if(to == null){
			throw new HantoException("Must specify a Coordinate to place piece at.");
		} else {
			hcTo = new HantoCoordinateImpl(to);
			if(getPieceAt(hcTo)!=null) {
				throw new HantoException("A piece has already been placed at coordinate: " + hcTo.toString() +".");
			}
		}

		
		
		if (from == null) {
			if (theBoard.isEmpty()) {
				if (isHome(hcTo)) {
					switch (pieceType) {
					case BUTTERFLY:
						theBoard.put(hcTo, new Butterfly(pc));
						blueButterfly = hcTo;
						break;
					case SPARROW:
						theBoard.put(hcTo, new Sparrow(pc));
						break;
					default:
						throw new HantoException(
								"Expecting a Butterfly or a Sparrow but was given a "
										+ pieceType.getPrintableName() + ".");
					}
					result = MoveResult.OK;
				} else {
					throw new HantoException("First piece must be placed at "
							+ home.toString() + ".");
				}
			} else {
				if (hasAdjacentPiece(hcTo)) {
					switch (pieceType) {
					case BUTTERFLY:
						final HantoPiece bfly = new Butterfly(pc);
						if (!theBoard.containsValue(bfly)) {
							theBoard.put(hcTo, bfly);
							switch (pc) {
							case BLUE:
								blueButterfly = hcTo;
								break;
							case RED:
								redButterfly = hcTo;
								break;
							default:
								break;
							}
						} else {
							throw new HantoException("Player " + pc.name()
									+ " has already placed a butterfly.");
						}
						break;
					case SPARROW:
						if (turn == 6 || turn == 7) {
							if (!theBoard.containsValue(new Butterfly(pc))) {
								throw new HantoException(
										"Player "
												+ pc.name()
												+ " must place a butterfly by the fourth turn.");
							}
						}
						theBoard.put(hcTo, new Sparrow(pc));
						break;
					default:
						throw new HantoException(
								"Expecting a Butterfly or a Sparrow but was given a "
										+ pieceType.getPrintableName() + ".");
					}
				} else {
					throw new HantoException(
							"Piece must be placed adjacent to another piece.");
				}

			}
		} else {
			throw new HantoException("Cannot move a piece, can only place.");
		}

		result = resolve();
		turn++;
		return result;
	}

	private MoveResult resolve() {
		MoveResult result = MoveResult.OK;
		if (turn == maxTurns) {
			result = MoveResult.DRAW;
		} else {
			if (redButterfly != null && isSurrounded(redButterfly)) {
				result = MoveResult.BLUE_WINS;
			} else if (blueButterfly != null && isSurrounded(blueButterfly)) {
				result = MoveResult.RED_WINS;
			}
		}
		return result;
	}

	private boolean isSurrounded(final HantoCoordinateImpl hc) {
		boolean isSurrounded = true;
		for (HantoCoordinate entry : hc.getAdjacentCoordinates()) {
			if (getPieceAt(entry) == null) {
				isSurrounded = false;
				break;
			}
		}
		return isSurrounded;
	}

	private HantoPlayerColor determineColor() {
		HantoPlayerColor result;
		if (turn % 2 == 0) {
			result = HantoPlayerColor.BLUE;
		} else {
			result = HantoPlayerColor.RED;
		}

		return result;
	}

	/**
	 * Determines if there is a piece that is adjacent to the given coordinate
	 * 
	 * @param hc
	 *            The coordinate to check adjacency
	 * @return true if there are pieces touching the given coordinate.
	 */
	public boolean hasAdjacentPiece(final HantoCoordinateImpl hc) {
		boolean foundAdjacentPiece = false;
		for (HantoCoordinate entry : hc.getAdjacentCoordinates()) {
			if (getPieceAt(entry) != null) {
				foundAdjacentPiece = true;
				break;
			}
		}
		return foundAdjacentPiece;
	}
}
