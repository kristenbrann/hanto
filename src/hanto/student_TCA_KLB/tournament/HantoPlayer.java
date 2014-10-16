/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

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

/**
 * @author tcarmstrong klbrann
 *
 */
public class HantoPlayer implements HantoGamePlayer {

	private HantoPlayerColor myColor;
	private boolean doIMoveFirst;
	EpsilonHantoGame theGame;
	private Random rGenerator;

	/**
	 * Obligatory 2 param constructor.
	 * 
	 * @param myColor
	 * @param doIMoveFirst
	 */
	public HantoPlayer(HantoPlayerColor myColor, boolean doIMoveFirst) {
		this.myColor = myColor;
		this.setDoIMoveFirst(doIMoveFirst);
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
		HantoMoveRecord move = null;
		if (moves.isEmpty()) {
			move = new HantoMoveRecord(null, null, null);
		} else {
			List<HantoMoveRecord> desirable = theGame.getDesirableMoves(moves,
					myColor);
			int pickDesirable = rGenerator.nextInt(2) + 1;
			// if there are moves and desirable moves, randomly decide whether
			// to make
			// a 'desirable move' or 'any available' generic move
			if (!desirable.isEmpty() && pickDesirable == 1) {

				move = desirable.get(rGenerator.nextInt(desirable.size()));
			} else {
				move = moves.get(rGenerator.nextInt(moves.size()));
			}
		}
		try {
			theGame.makeMove(move.getPiece(), move.getFrom(), move.getTo());
		} catch (HantoException e) {
			System.out.println("We dun messed up.: " + e.getMessage());
		}
		return move;

	}

	public boolean isDoIMoveFirst() {
		return doIMoveFirst;
	}

	public void setDoIMoveFirst(boolean doIMoveFirst) {
		this.doIMoveFirst = doIMoveFirst;
	}

}
