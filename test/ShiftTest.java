package test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ShiftTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "DisallowCrossing.csv", numLinesToSkip = 1)
	void CSVShift(String lower, String higher,String shift, 
			String ExpectedLower, String ExpectedHigher, String Comments) {
		Range base = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(new Range(Integer.parseInt(ExpectedLower), Integer.parseInt(ExpectedHigher)), 
				Range.shift(base, Integer.parseInt(shift)), Comments);
	}
	
	@Test
	void InfinityBase() {
		Range base = new Range(Float.NEGATIVE_INFINITY, 0);
		assertEquals(new Range(Float.NEGATIVE_INFINITY, 3), Range.shift(base, 3));
		assertEquals(new Range(Float.NEGATIVE_INFINITY, -3), Range.shift(base, -3));
		base = new Range(0,Float.POSITIVE_INFINITY);
		assertEquals(new Range(3, Float.POSITIVE_INFINITY), Range.shift(base, 3));
		assertEquals(new Range(-3, Float.POSITIVE_INFINITY), Range.shift(base, -3));
	}
	
	@Test
	void Identity() {
		Range base = new Range(-10,10);
		assertEquals(base, Range.shift(base, 0));
		
	}
	
	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "AllowCrossing.csv", numLinesToSkip = 1)
	void CSVShiftCrossingTrue(String lower, String higher,String shift, 
			String ExpectedLower, String ExpectedHigher, String Comments) {
		Range base = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(new Range(Integer.parseInt(ExpectedLower), Integer.parseInt(ExpectedHigher)), 
				Range.shift(base, Integer.parseInt(shift),true), Comments);
	}
	
	@Test
	void Throwing() {
		assertThrows(InvalidParameterException.class, ()-> Range.shift(null, 10));
		assertThrows(InvalidParameterException.class, ()-> Range.shift(null, 10,true));
	}
}
