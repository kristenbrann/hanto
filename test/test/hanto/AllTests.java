package test.hanto;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testAlphaGame.class, testBetaGame.class, testButterfly.class,
		testHantoCoordinateImpl.class, testSparrow.class, testMoveResult.class,
		testHantoPieceType.class, testHantoGameID.class})
public class AllTests {

}
