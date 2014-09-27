package test.hanto.student_TCA_KLB.beta;

import test.hanto.common.HantoTestGame;
import test.hanto.common.HantoTestGame.PieceLocationPair;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.beta.BetaHantoGame;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.HantoPieceFactory;

public class BetaHantoTestGame extends BetaHantoGame implements HantoTestGame {

	public BetaHantoTestGame(HantoPlayerColor color) {
		super(color);
		// TODO Auto-generated constructor stub
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
		if(player != movesFirst) {
			turn++;
		}
	}

}
