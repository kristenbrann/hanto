package hanto.student_TCA_KLB.epsilon;

import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
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

public class EpsilonHantoGame extends AbsHantoGame {

	public EpsilonHantoGame(HantoPlayerColor color) {
		super(color);
		flightDistance = 4;
		home = new HantoCoordinateImpl(0, 0);
		pieceInventory = new HantoPieceInventory(1, 6, 4, 2);
	}

	@Override
	protected void validateMove(HantoPieceType pieceType, HantoCoordinate from,
			HantoCoordinate to) throws HantoException {

		if (!gameInProgress) {
			throw new GameNotInProgressException();
		} else {

			if ((pieceType != HantoPieceType.BUTTERFLY)
					&& (turn >= 6)
					&& (!theBoard.containsValue(pieceFactory.makeHantoPiece(
							HantoPieceType.BUTTERFLY, currentPlayer)))) {
				throw new InvalidPieceTypeException(pieceType, "Player "
						+ currentPlayer.name()
						+ " must place a butterfly by the fourth turn");
			}
			switch (pieceType) {
			case CRAB:
			case HORSE:
			case SPARROW:
			case BUTTERFLY:
				if (from == null && to != null) {
					validatePiecePlacement(pieceType, to);
				} else {
					if (from != null && to != null && !theBoard.isEmpty()) {
						if (getPieceAt(from).getType() != pieceType) {
							throw new InvalidPieceTypeException(pieceType,
									"Piece type given does not match piece type that exists on the board.");
						}
						validPieceMovement(pieceType, from, to);
					} else {
						throw new InvalidTargetLocationException("Cannot move a piece if the board is empty");
					}
				}
				break;
			default:
				throw new InvalidPieceTypeException(pieceType,
						"Can only use Butterflies, Sparrows, Crabs, and Horses.");
			}
			;
		}
	}

	private void validatePiecePlacement(HantoPieceType pieceType,
			HantoCoordinate to) throws InvalidTargetLocationException, InvalidPieceTypeException {
		if(!pieceInventory.hasPiece(currentPlayer, pieceType)) {
			throw new InvalidPieceTypeException(pieceType, "Inventory is empty of this piece type.");
		}
		if (theBoard.isEmpty()) {
			if (!isHome(to)) {
				throw new InvalidTargetLocationException(to,
						"Must place first piece at home.");
			}
		} else {
			if (turn > 1) {
				HantoCoordinateImpl hcTo = new HantoCoordinateImpl(to);
				boolean nextToOpposingPiece = false;
				for (HantoCoordinate adjacent : hcTo.getAdjacentCoordinates()) {
					if (getPieceAt(adjacent) != null
							&& getPieceAt(adjacent).getColor() != currentPlayer) {
						nextToOpposingPiece = true;
					}
				}
				if (nextToOpposingPiece) {
					throw new InvalidTargetLocationException(to,
							"Piece cannot be placed next adjacent to a piece of the opposing color.");
				}
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

	@Override
	protected MoveResult handleResignation() throws HantoException {
		MoveResult result = MoveResult.OK;
		switch (currentPlayer) {
		case RED:
			result = MoveResult.BLUE_WINS;
			break;
		case BLUE:
			result = MoveResult.RED_WINS;
		}
		gameInProgress = false;
		return result;
	}

	/**
	 * Determines if moving (not placing) the piece is valid.
	 * 
	 * @param pieceType
	 *            The piece type that is being moved
	 * @param from
	 *            Where the piece is moving from
	 * @param to
	 *            Where the piece is moving to
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

}
