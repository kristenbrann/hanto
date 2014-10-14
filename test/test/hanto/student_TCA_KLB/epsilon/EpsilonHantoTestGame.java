package test.hanto.student_TCA_KLB.epsilon;

import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.HantoPieceFactory;
import hanto.student_TCA_KLB.epsilon.EpsilonHantoGame;
import test.hanto.common.HantoTestGame;

public class EpsilonHantoTestGame extends EpsilonHantoGame implements HantoTestGame  {

	public EpsilonHantoTestGame(HantoPlayerColor color) {
		super(color);
	}

	@Override
	public void initializeBoard(PieceLocationPair[] initialPieces) {
		for (PieceLocationPair p : initialPieces) {
			HantoPiece toPlace = HantoPieceFactory.getInstance()
					.makeHantoPiece(p.pieceType, p.player);
			switch (p.pieceType) {
			case BUTTERFLY:
				switch (p.player) {
				case BLUE:
					blueButterfly = new HantoCoordinateImpl(p.location);
					break;
				case RED:
					redButterfly = new HantoCoordinateImpl(p.location);
					break;
				}
				break;
			default:
				break;
			}
			pieceInventory.usePiece(p.player, p.pieceType);
			theBoard.put(new HantoCoordinateImpl(p.location), toPlace);
		}

	}

	@Override
	public void setTurnNumber(int turnNumber) {
		turn = (turnNumber - 1) * 2;

	}

	@Override
		public void setPlayerMoving(HantoPlayerColor player) {
			if (player != movesFirst) {
				if (turn % 2 != 1) {
					turn++;
				}
			}
			
		}

		

	}
