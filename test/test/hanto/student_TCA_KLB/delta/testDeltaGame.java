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
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.Crab;
import hanto.student_TCA_KLB.common.GameNotInProgressException;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.common.InvalidPieceTypeException;
import hanto.student_TCA_KLB.common.InvalidSourceLocationException;
import hanto.student_TCA_KLB.common.InvalidTargetLocationException;
import hanto.student_TCA_KLB.common.Sparrow;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.hanto.common.HantoTestGame;
import test.hanto.common.HantoTestGameFactory;
import test.hanto.common.HantoTestGame.PieceLocationPair;

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

	@Test(expected = InvalidTargetLocationException.class)
	public void makeInvalidFirstMove1() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		HantoCoordinate notHome = new HantoCoordinateImpl(1, 1);
		theGame.makeMove(firstPiece.getType(), null, notHome);
	}

	@Test
	public void makeValidWalkingMoveButterfly() {
		try {

			PieceLocationPair[] toPlace = {
					new PieceLocationPair(HantoPlayerColor.BLUE,
							HantoPieceType.BUTTERFLY, home),
					new PieceLocationPair(HantoPlayerColor.RED,
							HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(
									0, 1)), };

			theGame.initializeBoard(toPlace);
			theGame.setTurnNumber(2);
			theGame.setPlayerMoving(HantoPlayerColor.BLUE);

			assertEquals("Moving a butterfly should return OK.", MoveResult.OK,
					theGame.makeMove(HantoPieceType.BUTTERFLY, home,
							new HantoCoordinateImpl(1, 0)));
			assertEquals("The piece at (1,0) should be a blue piece",
					HantoPlayerColor.BLUE,
					theGame.getPieceAt(new HantoCoordinateImpl(1, 0))
							.getColor());
			assertEquals("The piece at (1,0) should be a butterfly.",
					HantoPieceType.BUTTERFLY,
					theGame.getPieceAt(new HantoCoordinateImpl(1, 0)).getType());

		} catch (HantoException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void makeValidWalkingMoveCrab() {
		try {

			PieceLocationPair[] toPlace = {
					new PieceLocationPair(HantoPlayerColor.BLUE,
							HantoPieceType.CRAB, home),
					new PieceLocationPair(HantoPlayerColor.RED,
							HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(
									0, 1)), };

			theGame.initializeBoard(toPlace);
			theGame.setTurnNumber(2);
			theGame.setPlayerMoving(HantoPlayerColor.BLUE);

			assertEquals("Moving a crab should return OK.", MoveResult.OK,
					theGame.makeMove(HantoPieceType.CRAB, home,
							new HantoCoordinateImpl(1, 0)));
			assertEquals("The piece at (1,0) should be a blue piece",
					HantoPlayerColor.BLUE,
					theGame.getPieceAt(new HantoCoordinateImpl(1, 0))
							.getColor());
			assertEquals("The piece at (1,0) should be a crab.",
					HantoPieceType.CRAB,
					theGame.getPieceAt(new HantoCoordinateImpl(1, 0)).getType());

		} catch (HantoException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void makeValidMoveBlueResignGame() {
		try {

			PieceLocationPair[] toPlace = {
					new PieceLocationPair(HantoPlayerColor.BLUE,
							HantoPieceType.CRAB, home),
					new PieceLocationPair(HantoPlayerColor.RED,
							HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(
									0, 1)), };

			theGame.initializeBoard(toPlace);
			theGame.setTurnNumber(2);
			theGame.setPlayerMoving(HantoPlayerColor.BLUE);

			assertEquals("Moving a crab should return OK.",
					MoveResult.RED_WINS,
					theGame.makeMove(null, null, null));
		} catch (HantoException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void makeValidMoveRedResignGame() {
		try {

			PieceLocationPair[] toPlace = {
					new PieceLocationPair(HantoPlayerColor.BLUE,
							HantoPieceType.CRAB, home),
					new PieceLocationPair(HantoPlayerColor.RED,
							HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(
									0, 1)), };

			theGame.initializeBoard(toPlace);
			theGame.setTurnNumber(2);
			theGame.setPlayerMoving(HantoPlayerColor.RED);

			assertEquals("Moving a crab should return OK.",
					MoveResult.BLUE_WINS,
					theGame.makeMove(null, null, null));
		} catch (HantoException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void simulateValidBlueWinsGame1() {

		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(1, -1)),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 0)),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(2, -1)),

				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 2)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, 2)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(1, 1)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(5);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);

		try {
			assertEquals(MoveResult.OK, theGame.makeMove(
					HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 0),
					new HantoCoordinateImpl(-1, 1)));
			assertEquals(MoveResult.OK, theGame.makeMove(
					HantoPieceType.SPARROW, null,
					new HantoCoordinateImpl(-1, 3)));
			assertEquals(MoveResult.BLUE_WINS, theGame.makeMove(
					HantoPieceType.SPARROW, new HantoCoordinateImpl(2, -1),
					new HantoCoordinateImpl(1, 0)));
		} catch (HantoException e) {

			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test
	public void simulateValidDrawGame() {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(1, -1)),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, -1)),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 0)),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(2, -1)),

				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 2)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, 2)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(1, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 1)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(6);
		theGame.setPlayerMoving(HantoPlayerColor.RED);

		try {
			assertEquals(MoveResult.DRAW, theGame.makeMove(
					HantoPieceType.SPARROW, new HantoCoordinateImpl(2, -1),
					new HantoCoordinateImpl(1, 0)));
		} catch (HantoException e) {
			fail("Unexpected exception: " + e.getMessage());
		}
	}

	@Test(expected = InvalidTargetLocationException.class)
	public void makeInvalidWalkingMoveMoreThanOneHexButterfly()
			throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)), };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(2);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);

		theGame.makeMove(HantoPieceType.BUTTERFLY, home,
				new HantoCoordinateImpl(1, 1));
	}

	@Test(expected = InvalidTargetLocationException.class)
	public void makeInvalidWalkingMoveMoreThanOneHexCrab()
			throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.CRAB, home),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.CRAB, new HantoCoordinateImpl(0, 1)), };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(2);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);

		theGame.makeMove(HantoPieceType.CRAB, home, new HantoCoordinateImpl(1,
				1));
	}

	@Test(expected = InvalidPieceTypeException.class)
	public void makeInvalidMoveFromNullWithInvalidPieceType()
			throws HantoException {
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
		theGame.makeMove(HantoPieceType.DOVE, null, home);
	}

	@Test(expected = GameNotInProgressException.class)
	public void makeMoveAfterGameEnded() throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.CRAB, home),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)), };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(2);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);

		theGame.makeMove(null, null, null);
		theGame.makeMove(HantoPieceType.SPARROW, null, new HantoCoordinateImpl(
				1, 1));
	}

	@Test(expected = InvalidPieceTypeException.class)
	public void blueButterflyNotPlacedByFourthTurn() throws HantoException {
		PieceLocationPair[] toPlace = {};
		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(4);
		theGame.setPlayerMoving(HantoPlayerColor.RED);
		theGame.makeMove(HantoPieceType.SPARROW, null, new HantoCoordinateImpl(
				0, -1));
	}

	@Test(expected = InvalidSourceLocationException.class)
	public void movePieceNotOnBoardYet() throws HantoException {
		theGame.makeMove(HantoPieceType.SPARROW, home, new HantoCoordinateImpl(
				0, -1));
	}

	@Test(expected = InvalidTargetLocationException.class)
	public void makeInvalidMoveWhichCausesDiscontinuousBoard()
			throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, -1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, 2)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(2);
		theGame.setPlayerMoving(HantoPlayerColor.RED);

		theGame.makeMove(HantoPieceType.BUTTERFLY,
				new HantoCoordinateImpl(0, 1), new HantoCoordinateImpl(1, 0));

	}

	@Test(expected = InvalidTargetLocationException.class)
	public void makeInvalidMovePlaceNextToOpposingColor() throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(1, -1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(-1, 2)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(3);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);
		theGame.makeMove(HantoPieceType.SPARROW, null, new HantoCoordinateImpl(
				-2, 2));
	}

	@Test
	public void testValidFlight() {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, -1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 2)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(3);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);

		try {

			assertEquals("Sparrow can fly to another valid location.",
					MoveResult.OK, theGame.makeMove(HantoPieceType.SPARROW,
							new HantoCoordinateImpl(0, -1),
							new HantoCoordinateImpl(0, 3)));

		} catch (HantoException e) {
			fail("Unexpected exception:\t" + e.getMessage());
		}
	}

	@Test (expected=HantoException.class)
	public void testInvalidFlight() throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.SPARROW, new HantoCoordinateImpl(0, -1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 2)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(3);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);
		theGame.makeMove(HantoPieceType.SPARROW,
				new HantoCoordinateImpl(0, -1), new HantoCoordinateImpl(0, 8));

	}
	
	@Test (expected=InvalidPieceTypeException.class)
	public void testInvalidMovement() throws HantoException {
		PieceLocationPair[] toPlace = {
				new PieceLocationPair(HantoPlayerColor.BLUE,
						HantoPieceType.BUTTERFLY, home),
				new PieceLocationPair(HantoPlayerColor.RED,
						HantoPieceType.BUTTERFLY, new HantoCoordinateImpl(0, 1)) };

		theGame.initializeBoard(toPlace);
		theGame.setTurnNumber(2);
		theGame.setPlayerMoving(HantoPlayerColor.BLUE);
		theGame.makeMove(HantoPieceType.SPARROW,
				home, new HantoCoordinateImpl(1, 0));

	}
}
