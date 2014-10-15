package hanto.student_TCA_KLB.tournament;

import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.HantoGameFactory;
import hanto.student_TCA_KLB.epsilon.EpsilonHantoGame;
import hanto.tournament.HantoGamePlayer;
import hanto.tournament.HantoMoveRecord;

import java.util.List;
import java.util.Random;

public class HantoPlayer implements HantoGamePlayer {

	private HantoPlayerColor myColor;
	private boolean doIMoveFirst;
	EpsilonHantoGame theGame;
	private Random rGenerator;

	public HantoPlayer(HantoPlayerColor myColor, boolean doIMoveFirst) {
		this.myColor = myColor;
		this.doIMoveFirst = doIMoveFirst;
		rGenerator = new Random(System.currentTimeMillis());
	}

	public HantoPlayer() {

		rGenerator = new Random(System.currentTimeMillis());
	}

	@Override
	public void startGame(HantoGameID version, HantoPlayerColor myColor,
			boolean doIMoveFirst) {
		this.myColor = myColor;
		if (myColor == HantoPlayerColor.BLUE) {
			if (doIMoveFirst) {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance()
						.makeHantoGame(HantoGameID.EPSILON_HANTO,
								HantoPlayerColor.BLUE);
			} else {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance()
						.makeHantoGame(HantoGameID.EPSILON_HANTO,
								HantoPlayerColor.RED);
			}
		} else {
			if (doIMoveFirst) {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance()
						.makeHantoGame(HantoGameID.EPSILON_HANTO,
								HantoPlayerColor.RED);
			} else {
				theGame = (EpsilonHantoGame) HantoGameFactory.getInstance()
						.makeHantoGame(HantoGameID.EPSILON_HANTO,
								HantoPlayerColor.BLUE);
			}
		}

	}

	@Override
	public HantoMoveRecord makeMove(HantoMoveRecord opponentsMove) {
		if (opponentsMove != null) {
			try {
				theGame.makeMove(opponentsMove.getPiece(),
						opponentsMove.getFrom(), opponentsMove.getTo());
			} catch (HantoException e) {
				System.out.println("Opponent made an improper move?!?!  "
						+ e.getMessage());
			}
		}

		List<HantoMoveRecord> moves = theGame.getAvailableMoves(myColor);
		HantoMoveRecord move;
		if (moves.isEmpty()) {
			move = new HantoMoveRecord(null, null, null);
		}
		move = moves.get(rGenerator.nextInt(moves.size()));
		try {
			theGame.makeMove(move.getPiece(), move.getFrom(), move.getTo());
		} catch (HantoException e) {
			System.out.println("We dun messed up.: " + e.getMessage());
		}
		return move;

	}

}
