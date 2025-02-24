package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConstrainsTest {
	// It appears that Constrain also uses Midpoint rather than lower bound to constrain lower numbers
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void RandomTestWithin1() {
		double rand = Math.random();
		Range given = new Range(0,1);
		assertEquals(rand,given.constrain(rand), "The typical test case");
	}
	
	@Test
	void BoundaryValues() {
		Range given = new Range(5,25);
		assertAll(
				() -> assertEquals(5,given.constrain(5),"Boudaries seem to be inclusive"),
				() -> assertEquals(25,given.constrain(25), "Boundaries seem to be inclusive"));
	}
	
	@Test
	void ExternalValues() {
		Range given = new Range(5,25);
		assertAll(
				() -> assertEquals(5,given.constrain(2.4),"This should actually constrain"),
				() -> assertEquals(25,given.constrain(25.3), "This should actually constrain"));
	}
	
	@Test
	void NegativeValues() {
		Range given = new Range(5,25);
		assertAll(
				() -> assertEquals(5,given.constrain(-7),"Negative numbers, whos absolute values lie in range"),
				() -> assertEquals(5,given.constrain(-20), "Negative numbers, whos absolute values lie in range"));
	}
	@Test
	void ZeroRange() {
		Range given = new Range(0,0);
		assertAll(
				() -> assertEquals(0,given.constrain(0),"The range ought still contain 0"),
				() -> assertEquals(0,given.constrain(2),"But should not contain any other numbers"),
				() -> assertEquals(0,given.constrain(-20), "And should handle negative numbers fine"));
	}
}
