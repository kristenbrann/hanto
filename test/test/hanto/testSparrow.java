package test.hanto;

import static org.junit.Assert.*;
import hanto.common.HantoPiece;
import hanto.common.HantoPlayerColor;
import hanto.student_TCA_KLB.common.Sparrow;

import org.junit.Before;
import org.junit.Test;

public class testSparrow {
	
	HantoPiece BSparrow, RSparrow;

	@Before
	public void setUp() throws Exception {
		BSparrow = new Sparrow(HantoPlayerColor.BLUE);
		RSparrow = new Sparrow(HantoPlayerColor.RED);
	}

	@Test
	public void testToString() {
		assertTrue(BSparrow.toString().equals("BLUE\tSparrow"));
		assertTrue(RSparrow.toString().equals("RED\tSparrow"));
	}
	
}
