package test.hanto.student_TCA_KLB.tournament;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import hanto.common.HantoCoordinate;
import hanto.common.HantoException;
import hanto.common.HantoGameID;
import hanto.common.HantoPieceType;
import hanto.common.HantoPlayerColor;
import hanto.common.MoveResult;
import hanto.student_TCA_KLB.common.HantoCoordinateImpl;
import hanto.student_TCA_KLB.tournament.HantoPlayer;
import hanto.tournament.HantoMoveRecord;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import test.hanto.common.HantoTestGame.PieceLocationPair;

public class testHantoPlayer {
	
	private HantoCoordinate home;
	private HantoPlayer hantoPlayer;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		home = new HantoCoordinateImpl(0, 0);
		hantoPlayer = new HantoPlayer();
	}


	@Test
	public void testHantoPlayerIMoveFirst() {
		hantoPlayer.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE, true);
		HantoMoveRecord myFirstMove = hantoPlayer.makeMove(null);
		assertTrue(myFirstMove.getPiece()!=null);
		assertTrue(myFirstMove.getFrom()==null);
		assertTrue(new HantoCoordinateImpl(myFirstMove.getTo()).equals(home));
		assertTrue(hantoPlayer.isDoIMoveFirst());
	}
	
	@Test
	public void testHantoPlayerIMoveFirstRed() {
		hantoPlayer.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED, true);
		HantoMoveRecord myFirstMove = hantoPlayer.makeMove(null);
		assertTrue(myFirstMove.getPiece()!=null);
		assertTrue(myFirstMove.getFrom()==null);
		assertTrue(new HantoCoordinateImpl(myFirstMove.getTo()).equals(home));
	}
	
	@Test
	public void testHantoPlayerIMoveSecond() {
		hantoPlayer.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE, false);
		
		HantoMoveRecord myFirstMove = hantoPlayer.makeMove(new HantoMoveRecord(HantoPieceType.CRAB, null, home));
		assertTrue(myFirstMove.getPiece()!=null);
		assertTrue(myFirstMove.getFrom()==null);
		assertTrue(!(new HantoCoordinateImpl(myFirstMove.getTo()).equals(home)));
	}
	
	@Test
	public void testHantoPlayerIMoveSecondRed() {
		hantoPlayer.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.RED, false);
		
		HantoMoveRecord myFirstMove = hantoPlayer.makeMove(new HantoMoveRecord(HantoPieceType.CRAB, null, home));
		assertTrue(myFirstMove.getPiece()!=null);
		assertTrue(myFirstMove.getFrom()==null);
		assertTrue(!(new HantoCoordinateImpl(myFirstMove.getTo()).equals(home)));
	}
	
	@Test
	public void testOpponentMakesInvalidMove() {
		hantoPlayer.startGame(HantoGameID.EPSILON_HANTO, HantoPlayerColor.BLUE, false);
		HantoMoveRecord myFirstMove = hantoPlayer.makeMove(new HantoMoveRecord(HantoPieceType.CRAB, null, null));
		assertTrue(myFirstMove.getPiece()!=null);
		assertTrue(myFirstMove.getFrom()==null);
		assertTrue(new HantoCoordinateImpl(myFirstMove.getTo()).equals(home));
	}
	
	@Test
	public void testHantoConstructor() {
		hantoPlayer = new HantoPlayer(HantoPlayerColor.BLUE, true);
		assertTrue(hantoPlayer.isDoIMoveFirst());
	}
	

}
