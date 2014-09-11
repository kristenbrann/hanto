/**
 * 
 */
package test.alpha;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.Butterfly;
import hanto.studentxxxx.common.HantoCoordinateImpl;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Nucleus
 *
 */
public class testAlphaGame {
	
	
	HantoGame theGame;
	HantoGameFactory theFactory;
	HantoCoordinate home;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		theFactory = HantoGameFactory.getInstance();
		theGame = theFactory.makeHantoGame(HantoGameID.ALPHA_HANTO);
		home = new HantoCoordinateImpl(0, 0);
	}
	
	@Test
	public void gameExists() {
		assertNotNull(theGame);
	}

	@Test
	public void testNothingOnTheBoard() {
		assertNull(theGame.getPieceAt(home));
	}
	
	@Test
	public void makeValidMoves1() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
			HantoCoordinate adjacent = new HantoCoordinateImpl(0, 1);
			assertEquals("Placing an adjacent butterfly to home should return DRAW", MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
			assertEquals("The piece at home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(home).getType());
		} catch(HantoException e) {	
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
//	@Test
//	public void makeValidMoves2() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(1, 0);
//		assertEquals(MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
//	}
//	
//	@Test
//	public void makeValidMoves3() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(1, -1);
//		assertEquals(MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
//	}
//	
//	@Test
//	public void makeValidMoves4() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(0, -1);
//		assertEquals(MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
//	}
//	
//	@Test
//	public void makeValidMoves5() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(-1, 0);
//		assertEquals(MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
//	}
//	
//	@Test
//	public void makeValidMoves6() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(-1, 1);
//		assertEquals(MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesRedCantMoveFirst() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.RED);
//		theGame.makeMove(firstPiece.getType(), null, home);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesNotHomeLocation1() {
//		HantoCoordinate notHome = new HantoCoordinateImpl(-1, 1);
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		theGame.makeMove(firstPiece.getType(), null, notHome);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesNotHomeLocation2() {
//		HantoCoordinate notHome = new HantoCoordinateImpl(0, 1);
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		theGame.makeMove(firstPiece.getType(), null, notHome);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesNotHomeLocation3() {
//		HantoCoordinate notHome = new HantoCoordinateImpl(50, -1);
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		theGame.makeMove(firstPiece.getType(), null, notHome);
//	}
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesNotHomeLocation4() {
//		HantoCoordinate notHome = new HantoCoordinateImpl(2, -2);
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		theGame.makeMove(firstPiece.getType(), null, notHome);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesSecondPieceNotAdjacent1() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(-2, 2);
//		theGame.makeMove(secondPiece.getType(), null, adjacent);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesSecondPieceNotAdjacent2() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(-5, -5);
//		theGame.makeMove(secondPiece.getType(), null, adjacent);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesSecondPieceNotAdjacent3() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(-25, 3);
//		theGame.makeMove(secondPiece.getType(), null, adjacent);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesConsecutiveBlueMoves() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.BLUE);
//		HantoCoordinate adjacent = new HantoCoordinateImpl(1, 1);
//		theGame.makeMove(secondPiece.getType(), null, adjacent);
//	}
//	
//	@Test(expected=HantoException.class)
//	public void makeInvalidMovesCantPlaceSecondPieceAtHome() {
//		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
//		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
//		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
//		theGame.makeMove(secondPiece.getType(), null, home);
//	}

	

}
