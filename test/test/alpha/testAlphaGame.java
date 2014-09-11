/**
 * 
 */
package test.alpha;

import static org.junit.Assert.*;
import hanto.HantoGameFactory;
import hanto.common.HantoCoordinate;
import hanto.common.HantoGame;
import hanto.common.HantoGameID;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Nucleus
 *
 */
public class testAlphaGame {
	
	
	HantoGame theGame;
	HantoGameFactory theFactory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		theFactory = HantoGameFactory.getInstance();
		theGame = theFactory.makeHantoGame(HantoGameID.ALPHA_HANTO);
		HantoCoordinate home = new HantoCoordinateImpl(0, 0);
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
	public void makeValidFirstMove() {
		HantoPiece firstPiece = new Butterfly(HantoPlayerColor.BLUE);
		theGame.makeMove(firstPiece.getType(), null, home);
	}

}
