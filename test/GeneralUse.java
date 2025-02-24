package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeneralUse {
	private Range rang;
	@BeforeEach
	void setUp() throws Exception {
		rang =  new Range(-2,5.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		rang = null;
	}

	@Test
	void toStringTest() {
		assertEquals("Range[-2,5]", rang.toString(),"The range ought be -2,5 for our sample range");;
	}
	
	@Test
	void getLowerBoundTest() {
		assertEquals(-2, rang.getLowerBound(), "The lower bound for the sample range is -2");
	}
	@Test
	void getUpperBoundTest() {
		assertEquals(5, rang.getUpperBound(), "The Upper bound for the sample range is 5");
	}
	@Test
	void getLength() {
		assertEquals(7, rang.getLength(), "The length of the sample should be 7");
	}
	@Test
	void getCentralValue() {
		assertEquals(1.5, rang.getCentralValue(), "The central value of the sample is 1.5");
	}
	@Test
	void WithinInfinity() {
		Range Infinity = new Range(2,Float.POSITIVE_INFINITY);
		assertTrue(Infinity.contains(Double.MAX_VALUE));
		assertTrue(Infinity.contains(-0));
	}
	@Test
	void WithinNegativeInifinity() {
		Range Infinity = new Range(Float.NEGATIVE_INFINITY,-2);
		assertTrue(Infinity.contains(-Float.MAX_VALUE));
		assertFalse(Infinity.contains(-0));
	}

}
