package test.hanto.student_TCA_KLB.alpha;

import test.hanto.common.HantoTestGame;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.alpha.AlphaHantoGame;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.HantoPieceFactory;

public class AlphaHantoTestGame extends AlphaHantoGame implements HantoTestGame {

	public AlphaHantoTestGame(HantoPlayerColor color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeBoard(PieceLocationPair[] initialPieces) {
		for (PieceLocationPair p : initialPieces) {
			HantoPiece toPlace = HantoPieceFactory.getInstance()
					.makeHantoPiece(p.pieceType, p.player);
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
