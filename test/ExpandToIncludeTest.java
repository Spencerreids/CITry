package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpandToIncludeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	// Behavior is undefined in the Javadoc, but code indicates this returns the range of (input number, input number)
	@Test
	void nullCase() {
		assertEquals(new Range (4,4), Range.expandToInclude(null, 4));
	}
	@Test
	void regularUse() {
		Range base = new Range(2,3);
		assertAll(
				() -> assertEquals(new Range(2,4),Range.expandToInclude(base, 4), "Typical expansion in the positive direction"),
				() -> assertEquals(new Range(0,3),Range.expandToInclude(base, 0), "Typical expansion in the negative direction"),
				() -> assertEquals(base,Range.expandToInclude(base, 2.4), "Range shouldn't expand")
				);
	}

	
	@Test
	void negativeBase() {
		Range base = new Range(-4,-1);
		assertAll(
				() -> assertEquals(new Range(-4,1),Range.expandToInclude(base, 1), "Expanding in the positive direction"),
				() -> assertEquals(new Range(-5,-1),Range.expandToInclude(base, -5), "Expanding in the negative direction"),
				() -> assertEquals(base,Range.expandToInclude(base, -1), "No Expansion")
				);
	}
	
	@Test
	void strangeCases() {
		Range base = new Range(-4,3);
		assertAll(
				() -> assertEquals(new Range(-4,Float.POSITIVE_INFINITY),Range.expandToInclude(base, Float.POSITIVE_INFINITY), "Including Positive Infinity"),
				() -> assertEquals(new Range(Float.NEGATIVE_INFINITY,3),Range.expandToInclude(base, Float.NEGATIVE_INFINITY), "Including Negative Infinity"),
				() -> assertEquals(new Range(-4,3),Range.expandToInclude(base, Float.NaN), "Float NAN, unclear behavior"),//This one throws an error
				() -> assertEquals(new Range(-4,3),Range.expandToInclude(base, -0), "Including Negative 0")
				);
	}

}
