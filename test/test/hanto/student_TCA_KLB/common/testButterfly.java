package test.hanto.student_TCA_KLB.common;

import static org.junit.Assert.*;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.common.Butterfly;

import org.junit.Before;
import org.junit.Test;

public class testButterfly {
	
	HantoPiece BButterfly, RButterfly;

	@Before
	public void setUp() throws Exception {
		BButterfly = new Butterfly(HantoPlayerColor.BLUE);
		RButterfly = new Butterfly(HantoPlayerColor.RED);
	}

	@Test
	public void testToString() {
		assertTrue(BButterfly.toString().equals("BLUE\tButterfly"));
		assertTrue(RButterfly.toString().equals("RED\tButterfly"));
	}
	
}
