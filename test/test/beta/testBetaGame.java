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
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test
	public void makeFirstMove2() {
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
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test(expected = HantoException.class)
	public void makeInvalidFirstMove1() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate notHome = new HantoCoordinateImpl(1, 1);
		theGame.makeMove(firstPiece.getType(), null, notHome);
	}

	@Test
	public void makeValidSecondMove() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0, 1);
		try {
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing Butterfly adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece at home should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece at home should be a butterfly.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());

		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test
	public void makeValidSecondMove2() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Sparrow(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(1, 0);
		try {
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing Sparrow adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece at home should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece at home should be a sparrow.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test
	public void makeValidSecondMove3() {
		HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Sparrow(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(-1, 1);
		try {
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing Sparrow adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece at home should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece at home should be a sparrow.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test
	public void makeValidSecondMove4() {
		HantoPiece firstPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0, 1);
		try {
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing butterfly adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece adjacent should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece adjacent should be a butterfly.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());
		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test(expected = HantoException.class)
	public void makeInvalidSecondMove() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate notAdjacentToHome = new HantoCoordinateImpl(5, 5);
		theGame.makeMove(firstPiece.getType(), null, home);
		theGame.makeMove(secondPiece.getType(), null, notAdjacentToHome);
	}

	@Test
	public void makeValidThreeMoves1() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0, 1);
		HantoCoordinate adjacentToHome2 = new HantoCoordinateImpl(1, -1);
		try {
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing butterfly adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece adjacent to home should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece adjacent to home should be a butterfly.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());
			assertEquals(
					"Placing sparrow adjacent to home as third move should return OK",
					MoveResult.OK, theGame.makeMove(thirdPiece.getType(), null,
							adjacentToHome2));
			assertEquals("The piece adjacent to home should be a blue piece",
					thirdPiece.getColor(), theGame.getPieceAt(adjacentToHome2)
							.getColor());
			assertEquals("The piece adjacent to home should be a sparrow.",
					thirdPiece.getType(), theGame.getPieceAt(adjacentToHome2)
							.getType());

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
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(1, -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(2, -2);
		try {
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing sparrow adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece adjacent to home should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece adjacent to home should be a sparrow.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());
			assertEquals(
					"Placing sparrow adjacent second piece as third move should return OK",
					MoveResult.OK, theGame.makeMove(thirdPiece.getType(), null,
							adjacentToSecondPiece));
			assertEquals(
					"The piece adjacent to second piece should be a blue piece",
					thirdPiece.getColor(),
					theGame.getPieceAt(adjacentToSecondPiece).getColor());
			assertEquals(
					"The piece adjacent to second piece should be a sparrow.",
					thirdPiece.getType(),
					theGame.getPieceAt(adjacentToSecondPiece).getType());

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
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0, -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(1, -2);
		try {
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece",
					firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstPiece.getType(), theGame.getPieceAt(home).getType());
			assertEquals(
					"Placing sparrow adjacent to home as second move should return OK",
					MoveResult.OK, theGame.makeMove(secondPiece.getType(),
							null, adjacentToHome));
			assertEquals("The piece adjacent to home should be a blue piece",
					secondPiece.getColor(), theGame.getPieceAt(adjacentToHome)
							.getColor());
			assertEquals("The piece adjacent to home should be a sparrow.",
					secondPiece.getType(), theGame.getPieceAt(adjacentToHome)
							.getType());
			assertEquals(
					"Placing butterfly adjacent second piece as third move should return OK",
					MoveResult.OK, theGame.makeMove(thirdPiece.getType(), null,
							adjacentToSecondPiece));
			assertEquals(
					"The piece adjacent to second piece should be a blue piece",
					thirdPiece.getColor(),
					theGame.getPieceAt(adjacentToSecondPiece).getColor());
			assertEquals(
					"The piece adjacent to second piece should be a butterfly.",
					thirdPiece.getType(),
					theGame.getPieceAt(adjacentToSecondPiece).getType());

		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test(expected = HantoException.class)
	public void makeInValidThreeMoves1() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0, -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(1, -2);
		theGame.makeMove(firstPiece.getType(), null, home);
		theGame.makeMove(secondPiece.getType(), null, adjacentToHome);
		theGame.makeMove(thirdPiece.getType(), null, adjacentToSecondPiece);
	}

	@Test(expected = HantoException.class)
	public void makeInValidThreeMoves2() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece thirdPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		HantoCoordinate adjacentToHome = new HantoCoordinateImpl(0, -1);
		HantoCoordinate adjacentToSecondPiece = new HantoCoordinateImpl(50, 50);
		theGame.makeMove(firstPiece.getType(), null, home);
		theGame.makeMove(secondPiece.getType(), null, adjacentToHome);
		theGame.makeMove(thirdPiece.getType(), null, adjacentToSecondPiece);
	}

	@Test
	public void simulateValidDrawGame() throws HantoException {
		HantoPiece firstBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondBPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece thirdBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fourthBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fifthBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece sixthBPiece = new Sparrow(HantoPlayerColor.BLUE);

		HantoPiece firstRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece secondRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdRPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece fourthRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece fifthRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece sixthRPiece = new Sparrow(HantoPlayerColor.RED);

		HantoCoordinate firstBCoord = home;
		HantoCoordinate secondBCoord = new HantoCoordinateImpl(-1, 1);
		HantoCoordinate thirdBCoord = new HantoCoordinateImpl(3, 0);
		HantoCoordinate fourthBCoord = new HantoCoordinateImpl(-1, -1);
		HantoCoordinate fifthBCoord = new HantoCoordinateImpl(4, 0);
		HantoCoordinate sixthBCoord = new HantoCoordinateImpl(6, 0);

		HantoCoordinate firstRCoord = new HantoCoordinateImpl(1, 0);
		HantoCoordinate secondRCoord = new HantoCoordinateImpl(2, 0);
		HantoCoordinate thirdRCoord = new HantoCoordinateImpl(0, -1);
		HantoCoordinate fourthRCoord = new HantoCoordinateImpl(-2, 0);
		HantoCoordinate fifthRCoord = new HantoCoordinateImpl(5, 0);
		HantoCoordinate sixthRCoord = new HantoCoordinateImpl(7, 0);

		try {
			assertEquals(
					"Placing a sparrow at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstBPiece.getType(), null, firstBCoord));
			assertEquals("The piece at home should be a blue piece",
					firstBPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a sparrow.",
					firstBPiece.getType(), theGame.getPieceAt(home).getType());

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(firstRPiece.getType(), null, firstRCoord));
			assertEquals("The piece should be a red piece",
					firstRPiece.getColor(), theGame.getPieceAt(firstRCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					firstRPiece.getType(), theGame.getPieceAt(firstRCoord)
							.getType());

			assertEquals(
					"Placing a butterfly should return OK",
					MoveResult.OK,
					theGame.makeMove(secondBPiece.getType(), null, secondBCoord));
			assertEquals("The piece should be a blue piece",
					secondBPiece.getColor(), theGame.getPieceAt(secondBCoord)
							.getColor());
			assertEquals("The piece should be a butterfly.",
					secondBPiece.getType(), theGame.getPieceAt(secondBCoord)
							.getType());

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondRPiece.getType(), null, secondRCoord));
			assertEquals("The piece should be a red piece",
					secondRPiece.getColor(), theGame.getPieceAt(secondRCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					secondRPiece.getType(), theGame.getPieceAt(secondRCoord)
							.getType());

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdBPiece.getType(), null, thirdBCoord));
			assertEquals("The piece should be a blue piece",
					thirdBPiece.getColor(), theGame.getPieceAt(thirdBCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					thirdBPiece.getType(), theGame.getPieceAt(thirdBCoord)
							.getType());

			assertEquals("Placing a butterfly should return OK", MoveResult.OK,
					theGame.makeMove(thirdRPiece.getType(), null, thirdRCoord));
			assertEquals("The piece should be a red piece",
					thirdRPiece.getColor(), theGame.getPieceAt(thirdRCoord)
							.getColor());
			assertEquals("The piece should be a butterfly.",
					thirdRPiece.getType(), theGame.getPieceAt(thirdRCoord)
							.getType());

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(fourthBPiece.getType(), null, fourthBCoord));
			assertEquals("The piece should be a blue  piece",
					fourthBPiece.getColor(), theGame.getPieceAt(fourthBCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					fourthBPiece.getType(), theGame.getPieceAt(fourthBCoord)
							.getType());

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(fourthRPiece.getType(), null, fourthRCoord));
			assertEquals("The piece should be a red  piece",
					fourthRPiece.getColor(), theGame.getPieceAt(fourthRCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					fourthRPiece.getType(), theGame.getPieceAt(fourthRCoord)
							.getType());

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(fifthBPiece.getType(), null, fifthBCoord));
			assertEquals("The piece should be a blue  piece",
					fifthBPiece.getColor(), theGame.getPieceAt(fifthBCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					fifthBPiece.getType(), theGame.getPieceAt(fifthBCoord)
							.getType());

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(fifthRPiece.getType(), null, fifthRCoord));
			assertEquals("The piece should be a red  piece",
					fifthRPiece.getColor(), theGame.getPieceAt(fifthRCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					fifthRPiece.getType(), theGame.getPieceAt(fifthRCoord)
							.getType());

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(sixthBPiece.getType(), null, sixthBCoord));
			assertEquals("The piece should be a blue  piece",
					sixthBPiece.getColor(), theGame.getPieceAt(sixthBCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					sixthBPiece.getType(), theGame.getPieceAt(sixthBCoord)
							.getType());

			assertEquals("Placing a sparrow should return DRAW",
					MoveResult.DRAW,
					theGame.makeMove(sixthRPiece.getType(), null, sixthRCoord));
			assertEquals("The piece should be a red  piece",
					sixthRPiece.getColor(), theGame.getPieceAt(sixthRCoord)
							.getColor());
			assertEquals("The piece should be a sparrow.",
					sixthRPiece.getType(), theGame.getPieceAt(sixthRCoord)
							.getType());

		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test(expected = HantoException.class)
	public void blueButterflyNotPlacedByFourthTurn() throws HantoException {
		HantoPiece firstBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece thirdBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fourthBPiece = new Sparrow(HantoPlayerColor.BLUE);

		HantoPiece firstRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece secondRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdRPiece = new Butterfly(HantoPlayerColor.RED);

		HantoCoordinate firstBCoord = home;
		HantoCoordinate secondBCoord = new HantoCoordinateImpl(-1, 1);
		HantoCoordinate thirdBCoord = new HantoCoordinateImpl(3, 0);
		HantoCoordinate fourthBCoord = new HantoCoordinateImpl(-1, -1);

		HantoCoordinate firstRCoord = new HantoCoordinateImpl(1, 0);
		HantoCoordinate secondRCoord = new HantoCoordinateImpl(2, 0);
		HantoCoordinate thirdRCoord = new HantoCoordinateImpl(0, -1);

		theGame.makeMove(firstBPiece.getType(), null, firstBCoord);
		theGame.makeMove(firstRPiece.getType(), null, firstRCoord);
		theGame.makeMove(secondBPiece.getType(), null, secondBCoord);
		theGame.makeMove(secondRPiece.getType(), null, secondRCoord);
		theGame.makeMove(thirdBPiece.getType(), null, thirdBCoord);
		theGame.makeMove(thirdRPiece.getType(), null, thirdRCoord);
		theGame.makeMove(fourthBPiece.getType(), null, fourthBCoord);
	}

	@Test(expected = HantoException.class)
	public void redButterflyNotPlacedByFourthTurn() throws HantoException {
		HantoPiece firstBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece secondBPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece thirdBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fourthBPiece = new Sparrow(HantoPlayerColor.BLUE);

		HantoPiece firstRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece secondRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece fourthRPiece = new Sparrow(HantoPlayerColor.RED);

		HantoCoordinate firstBCoord = home;
		HantoCoordinate secondBCoord = new HantoCoordinateImpl(-1, 1);
		HantoCoordinate thirdBCoord = new HantoCoordinateImpl(3, 0);
		HantoCoordinate fourthBCoord = new HantoCoordinateImpl(-1, -1);

		HantoCoordinate firstRCoord = new HantoCoordinateImpl(1, 0);
		HantoCoordinate secondRCoord = new HantoCoordinateImpl(2, 0);
		HantoCoordinate thirdRCoord = new HantoCoordinateImpl(0, -1);
		HantoCoordinate fourthRCoord = new HantoCoordinateImpl(-2, 0);

		theGame.makeMove(firstBPiece.getType(), null, firstBCoord);
		theGame.makeMove(firstRPiece.getType(), null, firstRCoord);
		theGame.makeMove(secondBPiece.getType(), null, secondBCoord);
		theGame.makeMove(secondRPiece.getType(), null, secondRCoord);
		theGame.makeMove(thirdBPiece.getType(), null, thirdBCoord);
		theGame.makeMove(thirdRPiece.getType(), null, thirdRCoord);
		theGame.makeMove(fourthBPiece.getType(), null, fourthBCoord);
		theGame.makeMove(fourthRPiece.getType(), null, fourthRCoord);
	}

	@Test
	public void simulateValidRedWinsGame() throws HantoException {
		HantoPiece firstBPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece thirdBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fourthBPiece = new Sparrow(HantoPlayerColor.BLUE);

		HantoPiece firstRPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece secondRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdRPiece = new Sparrow(HantoPlayerColor.RED);

		HantoCoordinate firstBCoord = home;
		HantoCoordinate secondBCoord = new HantoCoordinateImpl(1, 0);
		HantoCoordinate thirdBCoord = new HantoCoordinateImpl(0, -1);
		HantoCoordinate fourthBCoord = new HantoCoordinateImpl(-1, 1);

		HantoCoordinate firstRCoord = new HantoCoordinateImpl(0, 1);
		HantoCoordinate secondRCoord = new HantoCoordinateImpl(1, -1);
		HantoCoordinate thirdRCoord = new HantoCoordinateImpl(-1, 0);

		try {
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstBPiece.getType(), null, firstBCoord));

			assertEquals("Placing a butterfly should return OK", MoveResult.OK,
					theGame.makeMove(firstRPiece.getType(), null, firstRCoord));

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondBPiece.getType(), null, secondBCoord));

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondRPiece.getType(), null, secondRCoord));

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdBPiece.getType(), null, thirdBCoord));

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdRPiece.getType(), null, thirdRCoord));

			assertEquals("Placing a sparrow should return RED_WINS",
					MoveResult.RED_WINS, theGame.makeMove(
							fourthBPiece.getType(), null, fourthBCoord));

		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}

	}

	@Test
	public void simulateValidBlueWinsGame1() throws HantoException {
		HantoPiece firstBPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece thirdBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fourthBPiece = new Sparrow(HantoPlayerColor.BLUE);

		HantoPiece firstRPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece secondRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdRPiece = new Sparrow(HantoPlayerColor.RED);

		HantoCoordinate firstBCoord = home;
		HantoCoordinate secondBCoord = new HantoCoordinateImpl(0, 2);
		HantoCoordinate thirdBCoord = new HantoCoordinateImpl(1, 0);
		HantoCoordinate fourthBCoord = new HantoCoordinateImpl(-1, 1);

		HantoCoordinate firstRCoord = new HantoCoordinateImpl(0, 1);
		HantoCoordinate secondRCoord = new HantoCoordinateImpl(1, 1);
		HantoCoordinate thirdRCoord = new HantoCoordinateImpl(-1, 2);

		try {
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstBPiece.getType(), null, firstBCoord));

			assertEquals("Placing a butterfly should return OK", MoveResult.OK,
					theGame.makeMove(firstRPiece.getType(), null, firstRCoord));

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondBPiece.getType(), null, secondBCoord));

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondRPiece.getType(), null, secondRCoord));

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdBPiece.getType(), null, thirdBCoord));

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdRPiece.getType(), null, thirdRCoord));

			assertEquals("Placing a sparrow should return BLUE_WINS",
					MoveResult.BLUE_WINS, theGame.makeMove(
							fourthBPiece.getType(), null, fourthBCoord));

		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}

	@Test
	public void simulateValidBlueWinsGame2() throws HantoException {
		HantoPiece firstBPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoPiece secondBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece thirdBPiece = new Sparrow(HantoPlayerColor.BLUE);
		HantoPiece fourthBPiece = new Sparrow(HantoPlayerColor.BLUE);

		HantoPiece firstRPiece = new Butterfly(HantoPlayerColor.RED);
		HantoPiece secondRPiece = new Sparrow(HantoPlayerColor.RED);
		HantoPiece thirdRPiece = new Sparrow(HantoPlayerColor.RED);

		HantoCoordinate firstBCoord = home;
		HantoCoordinate secondBCoord = new HantoCoordinateImpl(0, 1);
		HantoCoordinate thirdBCoord = new HantoCoordinateImpl(2, 0);
		HantoCoordinate fourthBCoord = new HantoCoordinateImpl(1, -1);

		HantoCoordinate firstRCoord = new HantoCoordinateImpl(1, 0);
		HantoCoordinate secondRCoord = new HantoCoordinateImpl(1, 1);
		HantoCoordinate thirdRCoord = new HantoCoordinateImpl(2, -1);

		try {
			assertEquals(
					"Placing a butterfly at home as first move should return OK",
					MoveResult.OK,
					theGame.makeMove(firstBPiece.getType(), null, firstBCoord));

			assertEquals("Placing a butterfly should return OK", MoveResult.OK,
					theGame.makeMove(firstRPiece.getType(), null, firstRCoord));

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondBPiece.getType(), null, secondBCoord));

			assertEquals(
					"Placing a sparrow should return OK",
					MoveResult.OK,
					theGame.makeMove(secondRPiece.getType(), null, secondRCoord));

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdBPiece.getType(), null, thirdBCoord));

			assertEquals("Placing a sparrow should return OK", MoveResult.OK,
					theGame.makeMove(thirdRPiece.getType(), null, thirdRCoord));

			assertEquals("Placing a sparrow should return BLUE Wins",
					MoveResult.BLUE_WINS, theGame.makeMove(
							fourthBPiece.getType(), null, fourthBCoord));

		} catch (HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
}
