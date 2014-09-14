package test.hanto;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import hanto.common.HantoCoordinate;
import hanto.studentxxxx.common.HantoCoordinateImpl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testHantoCoordinateImpl {
	
	static HantoCoordinate home, ex1, ex2, ex3, ex4, ex5;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		home = new HantoCoordinateImpl(0, 0);
		ex1 = new HantoCoordinateImpl(3, 0);
		ex2 = new HantoCoordinateImpl(0, 3);
		ex3 = new HantoCoordinateImpl(3, 3);
		ex4 = new HantoCoordinateImpl(-3, -3);
		ex5 = new HantoCoordinateImpl(0, 1);
	}

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void testNotNull() {
		assertNotNull(home);
		assertNotNull(ex1);
		assertNotNull(ex2);
		assertNotNull(ex3);
		assertNotNull(ex4);
		assertNotNull(ex5);
	}

	@Test
	public void testToString() {
		assertTrue(home.toString().equals("(0,0)"));
		assertTrue(ex1.toString().equals("(3,0)"));
		assertTrue(ex2.toString().equals("(0,3)"));
		assertTrue(ex3.toString().equals("(3,3)"));
		assertTrue(ex4.toString().equals("(-3,-3)"));
		assertTrue(ex5.toString().equals("(0,1)"));
	}
	
	@Test
	public void testEquals() {
		assertTrue(home.equals(new HantoCoordinateImpl(0,0)));
		assertTrue(home.equals((Object) new HantoCoordinateImpl(0,0)));
		assertFalse(home.equals(6.6));
	}
	
	@Test
	public void testGetDistanceTo() {
		HantoCoordinateImpl temp = new HantoCoordinateImpl(home);
		assertEquals(3, temp.getDistanceTo(ex1));
		assertEquals(3, temp.getDistanceTo(ex2));
		assertEquals(6, temp.getDistanceTo(ex3));
		
		temp = new HantoCoordinateImpl(ex4);
		assertEquals(12, temp.getDistanceTo(ex3));
	}
	
	@Test
	public void testIsAdjacent() {
		HantoCoordinateImpl temp = new HantoCoordinateImpl(home);
		assertTrue(temp.isAdjacent(ex5));
		assertFalse(temp.isAdjacent(ex3));
	}
	
	@Test
	public void testGetAdjacentCoordinates() {
		Collection<HantoCoordinate> expected = new ArrayList<HantoCoordinate>(6);
		expected.add(new HantoCoordinateImpl(0, 1));
		expected.add(new HantoCoordinateImpl(1, 0));
		expected.add(new HantoCoordinateImpl(1, -1));
		expected.add(new HantoCoordinateImpl(0, -1));
		expected.add(new HantoCoordinateImpl(-1, 0));
		expected.add(new HantoCoordinateImpl(-1, 1));
		HantoCoordinateImpl temp = new HantoCoordinateImpl(home);
		assertTrue(expected.equals(temp.getAdjacentCoordinates()));
	}
	
	

}
