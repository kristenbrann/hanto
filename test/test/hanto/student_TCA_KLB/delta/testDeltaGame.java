package test.hanto.student_TCA_KLB.delta;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import hanto.common.HantoCoordinate;
import hanto.common.HantoGameID;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.hanto.common.HantoTestGame;
import test.hanto.common.HantoTestGameFactory;

public class testDeltaGame {

	private HantoTestGame theGame;
	private static HantoTestGameFactory theFactory;
	private HantoCoordinate home;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		theFactory = HantoTestGameFactory.getInstance();
	}

	@Before
	public void setUp() throws Exception {
		theGame = theFactory.makeHantoTestGame(HantoGameID.DELTA_HANTO);
		home = new HantoCoordinateImpl(0, 0);
	}

	@Test
	public void factoryReturnsNotNullGame() {
		assertNotNull(theGame);
	}

	@Test
	public void testNothingOnTheBoard() {
		assertNull(theGame.getPieceAt(home));
	}

	@Test
	public void testNoStringWhenNoPieceOnBoard() {
		assertTrue(theGame.getPrintableBoard().equals(""));
	}
	
}
