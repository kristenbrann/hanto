package test.beta;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.studentxxxx.common.*;

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
	
	
	
	
	

}
