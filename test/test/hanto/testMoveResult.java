package test.hanto;

import static org.junit.Assert.*;
import hanto.common.MoveResult;

import org.junit.Test;

public class testMoveResult {

	@Test
	public void test() {
		assertNotNull(MoveResult.valueOf("DRAW"));
		assertNotNull(MoveResult.valueOf("OK"));
		assertNotNull(MoveResult.valueOf("BLUE_WINS"));
		assertNotNull(MoveResult.valueOf("RED_WINS"));
	}

}
