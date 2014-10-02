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
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.AbsHantoGame;
import hanto.student_TCA_KLB.common.GameNotInProgressException;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.HantoPieceFactory;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tcarmstrong klbrann
 */
public class DeltaHantoGame extends AbsHantoGame {

	public DeltaHantoGame(HantoPlayerColor color) {
		super(color);
		home = new HantoCoordinateImpl(0, 0);
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

	private void validFlight(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws InvalidTargetLocationException,
			InvalidSourceLocationException {
		if (to == null) {
			throw new InvalidTargetLocationException(to,
					"Cannot move piece to null location");
		} else if (from == null) {
			throw new InvalidSourceLocationException(from,
					"Cannot move piece from a null location");
		}

		Map<HantoCoordinateImpl, HantoPiece> temp = new HashMap<HantoCoordinateImpl, HantoPiece>(
				theBoard);
		temp.remove(from);
		temp.put(new HantoCoordinateImpl(to), HantoPieceFactory.getInstance()
				.makeHantoPiece(pieceType, currentPlayer));
		if (boardIsContinuous(temp, to)) {
			theBoard.remove(from);
			theBoard.put(new HantoCoordinateImpl(to), HantoPieceFactory
					.getInstance().makeHantoPiece(pieceType, currentPlayer));
		} else {
			throw new InvalidTargetLocationException("Can't move piece.");
		}
	}

	/**
	 * @param pieceType
	 *            The Piece type that is walking
	 * @param from
	 *            Where the piece is walking from
	 * @param to
	 *            Where the piece is walking to
	 * @throws InvalidTargetLocationException
	 */
	void validateWalkOneHex(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws InvalidTargetLocationException {

		HantoCoordinateImpl hcFrom = new HantoCoordinateImpl(from);
		if (!hcFrom.isAdjacentTo(to)) {
			throw new InvalidTargetLocationException(to,
					"Piece can only move one hex.");
		} else {
			boolean canSlide = false;
			for (HantoCoordinate c : hcFrom.getAdjacentCoordinates()) {
				HantoCoordinateImpl next = new HantoCoordinateImpl(c);
				if (next.isAdjacentTo(to) && getPieceAt(next) == null) {
					canSlide = true;
				}
			}
			Map<HantoCoordinateImpl, HantoPiece> temp = new HashMap<HantoCoordinateImpl, HantoPiece>(
					theBoard);
			temp.remove(from);
			temp.put(new HantoCoordinateImpl(to),
					pieceFactory.makeHantoPiece(pieceType, currentPlayer));
			canSlide = canSlide && boardIsContinuous(temp, to);

			if (!canSlide) {
				throw new InvalidTargetLocationException(to,
						"Cannot move from " + from + " to " + to + ".");
			}
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

}
