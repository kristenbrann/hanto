package test.hanto;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.hanto.common.testHantoGameID;
import test.hanto.common.testHantoPieceType;
import test.hanto.common.testMoveResult;
import test.hanto.student_TCA_KLB.alpha.testAlphaGame;
import test.hanto.student_TCA_KLB.beta.testBetaGame;
import test.hanto.student_TCA_KLB.common.testButterfly;
import test.hanto.student_TCA_KLB.common.testHantoCoordinateImpl;
import test.hanto.student_TCA_KLB.common.testSparrow;

@RunWith(Suite.class)
@SuiteClasses({ testAlphaGame.class, testBetaGame.class, testButterfly.class,
		testHantoCoordinateImpl.class, testSparrow.class, testMoveResult.class,
		testHantoPieceType.class, testHantoGameID.class,
		AlphaHantoMasterTest.class})
public class AllTests {

}
