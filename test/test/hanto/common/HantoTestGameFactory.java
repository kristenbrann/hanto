/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package test.hanto.common;

import test.hanto.student_TCA_KLB.alpha.AlphaHantoTestGame;
import test.hanto.student_TCA_KLB.beta.BetaHantoTestGame;
import test.hanto.student_TCA_KLB.gamma.GammaHantoTestGame;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPlayerColor;

//import hanto.student_TCA_KLB.gamma.GammaHantoTestGame;

/**
 * Description
 * 
 * @version Sep 22, 2014
 */
public class HantoTestGameFactory {
	private static final HantoTestGameFactory instance = new HantoTestGameFactory();

	/**
	 * Default private descriptor.
	 */
	private HantoTestGameFactory() {
		// Empty, but the private constructor is necessary for the singleton.
	}

	/**
	 * @return the instance
	 */
	public static HantoTestGameFactory getInstance() {
		return instance;
	}

	/**
	 * Create the specified Hanto game version with the Blue player moving
	 * first.
	 * 
	 * @param gameId
	 *            the version desired.
	 * @return the game instance
	 */
	public HantoGame makeHantoTestGame(HantoGameID gameId) {
		return makeHantoTestGame(gameId, HantoPlayerColor.BLUE);
	}

	/**
	 * Factory method that returns the appropriately configured Hanto game.
	 * 
	 * @param gameId
	 *            the version desired.
	 * @param movesFirst
	 *            the player color that moves first
	 * @return the game instance
	 */
	public HantoTestGame makeHantoTestGame(HantoGameID gameId,
			HantoPlayerColor movesFirst) {
		HantoTestGame game = null;
		switch (gameId) {
		case ALPHA_HANTO:
			game = new AlphaHantoTestGame(movesFirst);
			break;
		case BETA_HANTO:
			game = new BetaHantoTestGame(movesFirst);
			break;
		case GAMMA_HANTO:
			game = new GammaHantoTestGame(movesFirst);
			break;
		default:
			break;
		}
		return game;
	}
}
