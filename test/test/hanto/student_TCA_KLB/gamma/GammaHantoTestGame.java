package test.hanto.student_TCA_KLB.gamma;

import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.HantoPieceFactory;
import hanto.student_TCA_KLB.gamma.GammaHantoGame;
import test.hanto.common.HantoTestGame;

public class GammaHantoTestGame extends GammaHantoGame implements HantoTestGame {

	public GammaHantoTestGame(HantoPlayerColor color) {
		super(color);
	}

	@Override
	public void initializeBoard(PieceLocationPair[] initialPieces) {
		for(PieceLocationPair p : initialPieces) {
			HantoPiece toPlace = HantoPieceFactory.getInstance().makeHantoPiece(p.pieceType, p.player);
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
