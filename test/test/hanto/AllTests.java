package test.hanto;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.hanto.common.testHantoGameFactory;
import test.hanto.common.testHantoGameID;
import test.hanto.common.testHantoPieceType;
import test.hanto.common.testMoveResult;
import test.hanto.student_TCA_KLB.alpha.testAlphaGame;
import test.hanto.student_TCA_KLB.beta.testBetaGame;
import test.hanto.student_TCA_KLB.common.TestCrab;
import test.hanto.student_TCA_KLB.common.testButterfly;
import test.hanto.student_TCA_KLB.common.testHantoCoordinateImpl;
import test.hanto.student_TCA_KLB.common.testSparrow;
import test.hanto.student_TCA_KLB.delta.testDeltaGame;
import test.hanto.student_TCA_KLB.epsilon.testEpsilonGame;
import test.hanto.student_TCA_KLB.gamma.testGammaGame;

@RunWith(Suite.class)
@SuiteClasses({ testAlphaGame.class, testBetaGame.class, testButterfly.class,
		testHantoCoordinateImpl.class, testSparrow.class, testMoveResult.class,
		testHantoPieceType.class, testHantoGameID.class, testGammaGame.class,
		AlphaHantoMasterTest.class, BetaHantoMasterTest.class, GammaHantoMasterTest.class,
		testDeltaGame.class, testHantoGameFactory.class, TestCrab.class, DeltaHantoMasterTest.class,
		testEpsilonGame.class})
public class AllTests {

}
