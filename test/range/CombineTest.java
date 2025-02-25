package range;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class CombineTest {
	// TODO: Infinity Combinations
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"Common Interesect Case,1,5,3,9,1,9",
		"Common Interesect Case,3,9,1,5,1,9",
		"No Interesct Case (1<2),1,5,7,9,1,9",
		"No Interesct Case (1>2),7,9,1,5,1,9",
		"Touching Boundries (1<2),1,5,5,9,1,9",
		"Touching Boundries (1>2),5,9,1,5,1,9",
		"Fully Encompassing (1 element of 2),4,4,1,20,1,20",
		"Fully Encompassing (2 element of 1),1,20,4,4,1,20",
		"Negative numbers seperation,-4,-1,3,7,-4,7",
})
	void CSV_Combine(String comments,String lower, String higher, String lower2, String higher2, 
			String ExpectedLower, String ExpectedHigher) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		Range given2 = new Range(Integer.parseInt(lower2), Integer.parseInt(higher2));
		Range result = Range.combine(given, given2);
		Range expected = new Range(Integer.parseInt(ExpectedLower), Integer.parseInt(ExpectedHigher));
		assertEquals(expected, result, comments);
	}
	
	@Test
	void firstNull() {
		Range given = new Range(3,7);
		Range result = Range.combine(given, null);
		assertEquals(given, result, "Something is going wrong with the null check");
	}
	
	@Test
	void secondNull() {
		Range given = new Range(3,7);
		Range result = Range.combine(null, given);
		assertEquals(given, result, "Something is going wrong with the null check");
	}

}
