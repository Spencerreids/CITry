package range;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
	
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"5, 5, Boundaries seem to be inclusive",
		"25,25,Boundaries seem to be inclusive"
})
	void BoundaryValues(String value,String constrainee, String comments ) {
		Range given = new Range(5,25);
		assertEquals(Integer.parseInt(value), given.constrain(Integer.parseInt(constrainee)), comments);
//		assertAll(
//				() -> assertEquals(5,given.constrain(5),"Boudaries seem to be inclusive"),
//				() -> assertEquals(25,given.constrain(25), "Boundaries seem to be inclusive"));
	}
	
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"5, 2, This should actually constrain",
		"25, 25, This should actually constrain"
})
	void ExternalValues(String value,String constrainee, String comments ) {
		Range given = new Range(5,25);
		assertEquals(Integer.parseInt(value), given.constrain(Integer.parseInt(constrainee)), comments);
//		assertAll(
//				() -> assertEquals(5,given.constrain(2.4),"This should actually constrain"),
//				() -> assertEquals(25,given.constrain(25.3), "This should actually constrain"));
	}
	
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"5, -7, Negative numbers, whos absolute values lie in range",
		"5,-20, Negative numbers, whos absolute values lie in range"
})
	void NegativeValues(String value,String constrainee, String comments ) {
		Range given = new Range(5,25);
		assertEquals(Integer.parseInt(value), given.constrain(Integer.parseInt(constrainee)), comments);
//		assertAll(
//				() -> assertEquals(5,given.constrain(-7),"Negative numbers, whos absolute values lie in range"),
//				() -> assertEquals(5,given.constrain(-20), "Negative numbers, whos absolute values lie in range"));
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"-0, The range ought still contain 0",
		"2, But should not contain any other numbers",
		"-20, And should handle negative numbers fine"
})
	void ZeroRange(String constrainee, String comments) {
		Range given = new Range(0,0);
		assertEquals(0, given.constrain(Integer.parseInt(constrainee)), comments);

//		assertAll(
//				() -> assertEquals(0,given.constrain(0),"The range ought still contain 0"),
//				() -> assertEquals(0,given.constrain(2),"But should not contain any other numbers"),
//				() -> assertEquals(0,given.constrain(-20), "And should handle negative numbers fine"));
	}
}
