package test.hanto.student_TCA_KLB.alpha;
/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
/**
 * @author tcarmstrong klbrann
 */


import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPiece;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.Butterfly;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author tcarmstrong klbrann
 *
 */
public class testAlphaGame {
	
	
	private HantoGame theGame;
	private static HantoGameFactory theFactory;
	private HantoCoordinate home;
	
	@BeforeClass
	public void setUpBeforeClass() {
		theFactory = HantoGameFactory.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
	public void testGetPrintableBoard() {
		try {
			theGame.makeMove(HantoPieceType.BUTTERFLY, null, home);
			assertTrue(theGame.getPrintableBoard().equals("(0,0)\t:\tBLUE\tButterfly\n"));
		} catch (HantoException e){
			fail("unexpected exception");
		}
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
			assertEquals("The piece adjacent to home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(adjacent).getColor());
			assertEquals("The piece adjacent should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacent).getType());
		} catch(HantoException e) {
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidMoves2() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
			HantoCoordinate adjacent = new HantoCoordinateImpl(1, 0);
			assertEquals("Placing an adjacent butterfly to home should return DRAW", MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
			assertEquals("The piece adjacent to home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(adjacent).getColor());
			assertEquals("The piece adjacent to home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacent).getType());
		} catch(HantoException e) {	
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidMoves3() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
			HantoCoordinate adjacent = new HantoCoordinateImpl(1, -1);
			assertEquals("Placing an adjacent butterfly to home should return DRAW", MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
			assertEquals("The piece adjacent to home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(adjacent).getColor());
			assertEquals("The piece adjacent to home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacent).getType());
		} catch(HantoException e) {	
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidMoves4() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
			HantoCoordinate adjacent = new HantoCoordinateImpl(0, -1);
			assertEquals("Placing an adjacent butterfly to home should return DRAW", MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
			assertEquals("The piece adjacent to home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(adjacent).getColor());
			assertEquals("The piece adjacent to home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacent).getType());
		} catch(HantoException e) {	
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidMoves5() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
			HantoCoordinate adjacent = new HantoCoordinateImpl(-1, 0);
			assertEquals("Placing an adjacent butterfly to home should return DRAW", MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
			assertEquals("The piece adjacent to home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(adjacent).getColor());
			assertEquals("The piece adjacent to home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacent).getType());
		} catch(HantoException e) {	
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	@Test
	public void makeValidMoves6() {
		try {
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			assertEquals("Placing a butterfly at home as first move should return OK", MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
			assertEquals("The piece at home should be a blue piece", firstPiece.getColor(), theGame.getPieceAt(home).getColor());
			assertEquals("The piece at home should be a butterfly.", firstPiece.getType(), theGame.getPieceAt(home).getType());
			HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
			HantoCoordinate adjacent = new HantoCoordinateImpl(-1, 1);
			assertEquals("Placing an adjacent butterfly to home should return DRAW", MoveResult.DRAW, theGame.makeMove(secondPiece.getType(), null, adjacent));
			assertEquals("The piece adjacent to home should be a red piece", secondPiece.getColor(), theGame.getPieceAt(adjacent).getColor());
			assertEquals("The piece adjacent to home should be a butterfly.", secondPiece.getType(), theGame.getPieceAt(adjacent).getType());
		} catch(HantoException e) {	
			System.out.println(e.getMessage());
			fail("unexpected exception");
		}
	}
	
	
	@Test
	public void testGetDistance(){
		HantoCoordinateImpl coordinate1 = new HantoCoordinateImpl(0, 0);
		HantoCoordinateImpl coordinate2 = new HantoCoordinateImpl(0, 1);
		assertEquals(1,coordinate1.getDistanceTo(coordinate2));
	}

	@Test(expected=HantoException.class)
	public void makeInvalidMoveFromNotNull() throws HantoException {
		HantoCoordinate notHome = new HantoCoordinateImpl(-1, 1);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		theGame.makeMove(firstPiece.getType(), notHome, home);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidPieceNotButterfly() throws HantoException {
		HantoCoordinate notHome = new HantoCoordinateImpl(-1, 1);
		HantoCoordinate home = new HantoCoordinateImpl(0,0);
		theGame.makeMove(HantoPieceType.CRANE, notHome, home);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesNotHomeLocation1() throws HantoException {
			HantoCoordinate notHome = new HantoCoordinateImpl(-1, 1);
			HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
			theGame.makeMove(firstPiece.getType(), null, notHome);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesNotHomeLocation2() throws HantoException {
		HantoCoordinate notHome = new HantoCoordinateImpl(0, 1);
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		theGame.makeMove(firstPiece.getType(), null, notHome);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesNotHomeLocation3() throws HantoException {
		HantoCoordinate notHome = new HantoCoordinateImpl(50, -1);
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		theGame.makeMove(firstPiece.getType(), null, notHome);
	}
	@Test(expected=HantoException.class)
	public void makeInvalidMovesNotHomeLocation4() throws HantoException {
		HantoCoordinate notHome = new HantoCoordinateImpl(2, -2);
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		theGame.makeMove(firstPiece.getType(), null, notHome);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesSecondPieceNotAdjacent1() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate adjacent = new HantoCoordinateImpl(-2, 2);
		theGame.makeMove(secondPiece.getType(), null, adjacent);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesSecondPieceNotAdjacent2() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate adjacent = new HantoCoordinateImpl(-5, -5);
		theGame.makeMove(secondPiece.getType(), null, adjacent);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesSecondPieceNotAdjacent3() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		HantoCoordinate adjacent = new HantoCoordinateImpl(-25, 3);
		theGame.makeMove(secondPiece.getType(), null, adjacent);
	}
	
	@Test(expected=HantoException.class)
	public void makeInvalidMovesCantPlaceSecondPieceAtHome() throws HantoException {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		assertEquals(MoveResult.OK, theGame.makeMove(firstPiece.getType(), null, home));
		HantoPiece secondPiece = new Butterfly(HantoPlayerColor.RED);
		theGame.makeMove(secondPiece.getType(), null, home);
	}

	

}
