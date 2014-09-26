package test.hanto.student_TCA_KLB.gamma;

import static org.junit.Assert.*;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.HantoGameFactory;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.Sparrow;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testGammaGame {
	
	private HantoGame theGame;
	private static HantoGameFactory theFactory;
	private HantoCoordinate home;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		theFactory = HantoGameFactory.getInstance();
	}

	@Before
	public void setUp() throws Exception {
		theGame = theFactory.makeHantoGame(HantoGameID.GAMMA_HANTO);
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
					"Placing a butterfly at home as first move should return OK",
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
			theGame = theFactory.makeHantoGame(HantoGameID.GAMMA_HANTO, HantoPlayerColor.RED);
			HantoPiece firstPiece = new Sparrow(HantoPlayerColor.RED);
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
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
	
	@Test(expected = HantoException.class)
	public void makeInvalidFirstMove1() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate notHome = new HantoCoordinateImpl(1, 1);
		theGame.makeMove(firstPiece.getType(), null, notHome);
	}
	
	@Test(expected = HantoException.class)
	public void makeInvalidFirstMove2() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate notHome = new HantoCoordinateImpl(1, 1);
		theGame.makeMove(firstPiece.getType(), notHome, home);
	}
	
	
	
	
	
	
	

}
