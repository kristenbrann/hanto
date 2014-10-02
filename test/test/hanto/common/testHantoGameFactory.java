package test.hanto.common;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.student_TCA_KLB.HantoGameFactory;
import hanto.student_TCA_KLB.alpha.AlphaHantoGame;
import hanto.student_TCA_KLB.beta.BetaHantoGame;
import hanto.student_TCA_KLB.delta.DeltaHantoGame;
import hanto.student_TCA_KLB.gamma.GammaHantoGame;

import org.junit.BeforeClass;
import org.junit.Test;

public class testHantoGameFactory {
	
	static HantoGameFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		factory = HantoGameFactory.getInstance();
	}

	@Test
	public void testAlpha() {
		HantoGame game = factory.makeHantoGame(HantoGameID.ALPHA_HANTO);
		assertNotNull(game);
		assertTrue(game instanceof AlphaHantoGame);
	}
	
	@Test
	public void testBeta() {
		HantoGame game = factory.makeHantoGame(HantoGameID.BETA_HANTO);
		assertNotNull(game);
		assertTrue(game instanceof BetaHantoGame);
	}
	
	@Test
	public void testGamma() {
		HantoGame game = factory.makeHantoGame(HantoGameID.GAMMA_HANTO);
		assertNotNull(game);
		assertTrue(game instanceof GammaHantoGame);
	}
	
	@Test
	public void testDelta() {
		HantoGame game = factory.makeHantoGame(HantoGameID.DELTA_HANTO);
		assertNotNull(game);
		assertTrue("Game is instance of Delta", game instanceof DeltaHantoGame);
	}

}
