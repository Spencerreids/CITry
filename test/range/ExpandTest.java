package range;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExpandTest {
	// Note, the usage of Expand is strange, referencing the size of the given range and expanding by a
	// given percentage. As such, My testing will be limited using easy to work with ranges of 0-10
	private Range starting;
	@BeforeEach
	void setUp() throws Exception {
		starting =  new Range(0,10);
	}

	@AfterEach
	void tearDown() throws Exception{
		starting = null;
	}

	@Test
	void throwing() {
		assertThrows(InvalidParameterException.class, ()-> Range.expand(null, 0, 0));
	}
	
	@Test
	void typicalUse() {
		assertAll(
				() -> assertEquals(new Range(-10,20), Range.expand(starting, 1, 1), "Simple 100% in both directions"),
				() -> assertEquals(new Range(0,15), Range.expand(starting, 0, .5), "First value 0"),
				() -> assertEquals(new Range(-3,10), Range.expand(starting, .3, 0), "Second value 0"),
				() -> assertEquals(new Range(-30,40), Range.expand(starting, 3, 3), "Values larger than 100%"),
				() -> assertEquals(starting, Range.expand(starting, 0, 0), "In theory no expansions should occur")
				);
	}
	
	// Behavior for negative numbers unspecified, Assumptions made
	@Test
	void negativeExpansion() {
		assertAll(
				() -> assertEquals(new Range(0,5), Range.expand(starting, 0, -.5), "No restriction on the supplied values, One would think this implies shrinkage."),
				() -> assertEquals(new Range(5,10), Range.expand(starting, -.5, 0 ), "No restriction on the supplied values, One would think this implies shrinkage."),
				() -> assertEquals(new Range(1,10), Range.expand(starting, -5, 0 ), "No clue how this would handle a larger negative number"),
				() -> assertThrows(RuntimeException.class, ()->Range.expand(starting, -.6, -.6))
				
				);
	}
	
	

}
