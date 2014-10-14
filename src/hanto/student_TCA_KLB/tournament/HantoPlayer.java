package hanto.student_TCA_KLB.tournament;

import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.HantoGameFactory;
import hanto.student_TCA_KLB.epsilon.EpsilonHantoGame;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

public class HantoPlayer implements HantoGamePlayer {
	
	private HantoPlayerColor myColor;
	private boolean doIMoveFirst;
	EpsilonHantoGame theGame;

	public HantoPlayer(HantoPlayerColor myColor, boolean doIMoveFirst) {
		this.myColor = myColor;
		this.doIMoveFirst = doIMoveFirst;
	}

	@Override
	public void startGame(HantoGameID version, HantoPlayerColor myColor,
			boolean doIMoveFirst) {
		if(myColor == HantoPlayerColor.BLUE) {
			if(doIMoveFirst) {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE);
			} else {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED);
			}
		} else {
			if(doIMoveFirst) {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED);
			} else {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance().makeHantoGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE);
			}
		}

	}

	@Override
	public HantoMoveRecord makeMove(HantoMoveRecord opponentsMove) {
		// TODO Auto-generated method stub
		return null;
	}

}
