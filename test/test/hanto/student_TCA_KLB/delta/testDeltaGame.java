package test.hanto.student_TCA_KLB.delta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.Crab;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.Sparrow;

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
	
	@Test
	public void makeFirstMove1() {
		try {
			HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch (HantoException e) {

			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void makeFirstMove2() {
		try {
			theGame = theFactory.makeHantoTestGame(HantoGameID.GAMMA_HANTO,
					HantoPlayerColor.RED);
			HantoPiece firstPiece = new Sparrow(HantoPlayerColor.RED);
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a red piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch (HantoException e) {

			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void makeFirstMove3() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch (HantoException e) {

			fail("Unexpected exception: " + e.getMessage());
		}
	}
	
	@Test
	public void makeFirstMove4() {
		try {
			HantoPiece firstPiece = new Crab(HantoPlayerColor.BLUE);
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a crab.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch (HantoException e) {

			fail("Unexpected exception: " + e.getMessage());
		}
	}
	
}
