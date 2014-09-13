package test.beta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
import hanto.studentxxxx.common.Sparrow;

import org.junit.Before;
import org.junit.Test;

public class testBetaGame {
	HantoGame theGame;
	HantoGameFactory theFactory;
	HantoCoordinate home;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		theFactory = HantoGameFactory.getInstance();
		theGame = theFactory.makeHantoGame(HantoGameID.BETA_HANTO);
		home = new HantoCoordinateImpl(0, 0);
	}
	
	@Test
	public void gameExists() {
		assertNotNull(theGame);
	}

	@Test
	public void testNothingOnTheBoard() {
		assertNull(theGame.getPieceAt(home));
		assertTrue(theGame.getPrintableBoard().equals(""));
	}
	
	@Test
	public void makeFirstMove1() {
		try {
			HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.", firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch(HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeFirstMove2() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch(HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidFirstMove1() throws HantoException {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			HantoCoordinate notHome = new HantoCoordinateImpl(1, 1);
			theGame.makeMove(firstPiece.getType(), null, notHome);
	}
	
	@Test
	public void makeValidSecondMove() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0,1);
		try {
			theGame.makeMove(firstPiece.getType(),null,home);
			theGame.makeMove(secondPiece.getType(),null,adjacentToHome);
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidSecondMove() throws HantoException{
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate notAdjacentToHome = new HantoCoordinateImpl(5,5);
		theGame.makeMove(firstPiece.getType(),null,home);
		theGame.makeMove(secondPiece.getType(),null,notAdjacentToHome);
	}
	
	
	
	

}
