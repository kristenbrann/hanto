/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package hanto.student_TCA_KLB.delta;

import hanto.common.HantoCoordinate;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.GameNotInProgressException;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.HantoPieceInventory;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;

/**
 * @author tcarmstrong klbrann
 */
public class DeltaHantoGame extends AbsHantoGame {

	public DeltaHantoGame(HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
		flightDistance = Integer.MAX_VALUE;
		pieceInventory = new HantoPieceInventory(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
	}

	@Override
	protected void validateMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws GameNotInProgressException,
			InvalidTargetLocationException, InvalidPieceTypeException,
			InvalidSourceLocationException {

		if (!gameInProgress) {
			throw new GameNotInProgressException();
		} else {

			switch (pieceType) {

			case CRAB:
			case SPARROW:
				if (turn >= 6) {
					if (!theBoard.containsValue(pieceFactory.makeHantoPiece(
							HantoPieceType.BUTTERFLY, currentPlayer))) {
						throw new InvalidPieceTypeException(
								pieceType,
								"Player "
										+ currentPlayer.name()
										+ " must place a butterfly by the fourth turn");
					}
				}
			case BUTTERFLY:
				if (getPieceAt(to) == null) {
					if (theBoard.isEmpty()) {
						if (from == null) {
							if (!isHome(to)) {
								throw new InvalidTargetLocationException(to,
										"First piece must be placed at "
												+ home.toString());
							}
						} else {
							throw new InvalidSourceLocationException(from,
									"Cannot move a piece if no pieces are on the board");
						}
					} else {
						if (from != null) {
							if( getPieceAt(from).getType() != pieceType) {
								throw new InvalidPieceTypeException(pieceType, "Piece type given does not match piece type that exists on the board.");
							}
							validPieceMovement(pieceType, from, to);
						} else {
							if (to != null) {
								if (turn > 1) {
									HantoCoordinateImpl hcTo = new HantoCoordinateImpl(
											to);
									boolean nextToOpposingPiece = false;
									for (HantoCoordinate adjacent : hcTo
											.getAdjacentCoordinates()) {
										if (getPieceAt(adjacent) != null
												&& getPieceAt(adjacent)
														.getColor() != currentPlayer) {
											nextToOpposingPiece = true;
										}
									}
									if (nextToOpposingPiece) {
										throw new InvalidTargetLocationException(
												to,
												"Piece cannot be placed next adjacent to a piece of the opposing color.");
									}
								}
							}
						}
					}
				} else {
					throw new InvalidTargetLocationException(to,
							"A piece already exists at that location.");
				}
				break;
			default:
				throw new InvalidPieceTypeException(pieceType,
						"Can only use Butterflies and Sparrows");
			}
		}
	}

	/**
	 * Determines if moving (not placing) the piece is valid.
	 * @param pieceType
	 * 				The piece type that is being moved
	 * @param from
	 * 				Where the piece is moving from
	 * @param to
	 * 				Where the piece is moving to
	 * 
	 * @throws InvalidSourceLocationException
	 * @throws InvalidTargetLocationException
	 */
	void validPieceMovement(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws InvalidSourceLocationException,
			InvalidTargetLocationException {

		if (from == null || getPieceAt(from) == null) {
			throw new InvalidSourceLocationException(to, "");
		} else {
			if (to == null || getPieceAt(to) != null) {
				throw new InvalidTargetLocationException(to, "");
			}
		}

		switch (pieceType) {
		case BUTTERFLY:
		case CRAB:
			validateWalkOneHex(pieceType, from, to);
			break;
		case SPARROW:
			validFlight(pieceType, from, to);
			break;
		default:
			break;

		}
	}

	
	@Override
	protected MoveResult determineMoveResult() {
		MoveResult result = MoveResult.OK;
		if (redButterfly != null && isSurrounded(redButterfly)) {
			result = MoveResult.BLUE_WINS;
			gameInProgress = false;
		} else if (blueButterfly != null && isSurrounded(blueButterfly)) {
			result = MoveResult.RED_WINS;
			gameInProgress = false;
		}
		if ((redButterfly != null && isSurrounded(redButterfly))
				&& (blueButterfly != null && isSurrounded(blueButterfly))) {
			result = MoveResult.DRAW;
			gameInProgress = false;
		}
		return result;	
	}
	
	@Override
	protected MoveResult handleResignation() {
		MoveResult result = MoveResult.OK;
		switch(currentPlayer) {
			case RED:
				result = MoveResult.BLUE_WINS;
				break;
			case BLUE:
				result = MoveResult.RED_WINS;
			}
		gameInProgress = false;
		return result;
	}
}


