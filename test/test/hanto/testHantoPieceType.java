package test.hanto;

import static org.junit.Assert.*;
import hanto.common.HantoPieceType;

import org.junit.Test;

public class testHantoPieceType {

	@Test
	public void testToString() {
		assertTrue(HantoPieceType.BUTTERFLY.toString().equals("Butterfly"));
		assertTrue(HantoPieceType.CRAB.toString().equals("Crab"));
		assertTrue(HantoPieceType.HORSE.toString().equals("Horse"));
		assertTrue(HantoPieceType.CRANE.toString().equals("Crane"));
		assertTrue(HantoPieceType.DOVE.toString().equals("Dove"));
		assertTrue(HantoPieceType.SPARROW.toString().equals("Sparrow"));
	}
	
	@Test
	public void testGetSymbol() {
		assertTrue(HantoPieceType.BUTTERFLY.getSymbol().equals("B"));
		assertTrue(HantoPieceType.CRAB.toString().equals("C"));
		assertTrue(HantoPieceType.HORSE.toString().equals("H"));
		assertTrue(HantoPieceType.CRANE.toString().equals("N"));
		assertTrue(HantoPieceType.DOVE.toString().equals("D"));
		assertTrue(HantoPieceType.SPARROW.toString().equals("S"));
	}
	

}
