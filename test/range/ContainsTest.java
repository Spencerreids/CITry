package range;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContainsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void randomTestWithin1() {
		double rand = Math.random();
		Range given = new Range(0,1);
		assertTrue(given.contains(rand), "The typical test case");
	}
	
	@Test
	void boundaryValues() {
		Range given = new Range(5,25);

		assertTrue(given.contains(5),"Boudaries seem to be inclusive");
		assertTrue(given.contains(25), "Boundaries seem to be inclusive");
	}
	
	@Test
	void externalValues() {
		Range given = new Range(5,25);
		assertFalse(given.contains(4.9));
		assertFalse(given.contains(25.1));
	}
	
	@Test
	void negativeValues() {
		Range given = new Range(5,25);

		assertFalse(given.contains(-7),"Negative numbers, whos absolute values lie in range");
		assertFalse(given.contains(-20), "Negative numbers, whos absolute values lie in range");
	}
	@Test
	void zeroRange() {
		Range given = new Range(0,0);

		assertTrue(given.contains(0),"The range ought still contain 0");
		assertFalse(given.contains(2),"But should not contain any other numbers");
		assertFalse(given.contains(-20), "And should handle negative numbers fine");
	}


}
