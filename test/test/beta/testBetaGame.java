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
	
	@Test
	public void makeValidSecondMove() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0,1);
		try {
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing Butterfly adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece at home should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece at home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
		
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidSecondMove2() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Sparrow(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(1,0);
		try {
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing Sparrow adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece at home should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece at home should be a sparrow.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	
	@Test
	public void makeValidSecondMove3() {
		HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Sparrow(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(-1,1);
		try {
			assertEquals("Placing a sparrow at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing Sparrow adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece at home should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece at home should be a sparrow.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidSecondMove4() {
		HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0,1);
		try {
			assertEquals("Placing a sparrow at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing butterfly adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece adjacent should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece adjacent should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
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
	
	@Test
	public void makeValidThreeMoves1() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0,1);
		HantoCoordinate adjacentToHome2 = new HantoCoordinateImpl(1, -1);
		try {
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing butterfly adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece adjacent to home should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece adjacent to home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
			assertEquals("Placing sparrow adjacent to home as third move should return OK", MoveResult.OK, theGame.makeMove(thirdPiece.getType(),null,adjacentToHome2));
			assertEquals("The piece adjacent to home should be a blue piece", thirdPiece.getColor(), theGame.getPieceAt(adjacentToHome2).getColor());
			assertEquals("The piece adjacent to home should be a sparrow.", thirdPiece.getType(), theGame.getPieceAt(adjacentToHome2).getType());
	
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidThreeMoves2() {
		HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(1,-1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(2, -2);
		try {
			assertEquals("Placing a sparrow at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing sparrow adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece adjacent to home should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece adjacent to home should be a sparrow.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
			assertEquals("Placing sparrow adjacent second piece as third move should return OK", MoveResult.OK, theGame.makeMove(thirdPiece.getType(),null,adjacentToSecondPiece));
			assertEquals("The piece adjacent to second piece should be a blue piece", thirdPiece.getColor(), theGame.getPieceAt(adjacentToSecondPiece).getColor());
			assertEquals("The piece adjacent to second piece should be a sparrow.", thirdPiece.getType(), theGame.getPieceAt(adjacentToSecondPiece).getType());
	
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidThreeMoves3() {
		HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0 , -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(1, -2);
		try {
			assertEquals("Placing a sparrow at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(),null,home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals("Placing sparrow adjacent to home as second move should return OK", MoveResult.OK, theGame.makeMove(secondPiece.getType(),null,adjacentToHome));
			assertEquals("The piece adjacent to home should be a blue piece", secondPiece.getColor(), theGame.getPieceAt(adjacentToHome).getColor());
			assertEquals("The piece adjacent to home should be a sparrow.", secondPiece.getType(), theGame.getPieceAt(adjacentToHome).getType());
			assertEquals("Placing butterfly adjacent second piece as third move should return OK", MoveResult.OK, theGame.makeMove(thirdPiece.getType(),null,adjacentToSecondPiece));
			assertEquals("The piece adjacent to second piece should be a blue piece", thirdPiece.getColor(), theGame.getPieceAt(adjacentToSecondPiece).getColor());
			assertEquals("The piece adjacent to second piece should be a butterfly.", thirdPiece.getType(), theGame.getPieceAt(adjacentToSecondPiece).getType());
	
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test(expected=HantoException.class)
	public void makeInValidThreeMoves1() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0 , -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(1, -2);
		theGame.makeMove(firstPiece.getType(),null,home);
		theGame.makeMove(secondPiece.getType(),null,adjacentToHome);
		theGame.makeMove(thirdPiece.getType(),null,adjacentToSecondPiece);
	}
	
	@Test(expected=HantoException.class)
	public void makeInValidThreeMoves2() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0 , -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(50, 50);
		theGame.makeMove(firstPiece.getType(),null,home);
		theGame.makeMove(secondPiece.getType(),null,adjacentToHome);
		theGame.makeMove(thirdPiece.getType(),null,adjacentToSecondPiece);
	}
	

}
