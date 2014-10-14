package test.hanto.student_TCA_KLB.common;

import static org.junit.Assert.assertTrue;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.common.Horse;

import org.junit.Before;
import org.junit.Test;

public class testHorse {
	
	HantoPiece BHorse, RHorse;

	@Before
	public void setUp() throws Exception {
		BHorse = new Horse(HantoPlayerColor.BLUE);
		RHorse = new Horse(HantoPlayerColor.RED);
	}

	@Test
	public void testToString() {
		assertTrue(BHorse.toString().equals("BLUE\tHorse"));
		assertTrue(RHorse.toString().equals("RED\tHorse"));
	}
	
}
