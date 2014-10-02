package test.hanto.student_TCA_KLB.common;

import static org.junit.Assert.*;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.common.Crab;

import org.junit.Before;
import org.junit.Test;

public class TestCrab {
	
	HantoPiece BCrab, RCrab;

	@Before
	public void setUp() throws Exception {
		BCrab = new Crab(HantoPlayerColor.BLUE);
		RCrab = new Crab(HantoPlayerColor.RED);
	}

	@Test
	public void testToString() {
		assertTrue(BCrab.toString().equals("BLUE\tCrab"));
		assertTrue(RCrab.toString().equals("RED\tCrab"));
	}
	
	
}
