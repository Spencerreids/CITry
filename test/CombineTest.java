package range;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
	@CsvFileSource(resources = "Combine.csv", numLinesToSkip = 1)
	void CSV_Combine(String comments,String lower, String higher, String lower2, String higher2, 
			String ExpectedLower, String ExpectedHigher) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		Range given2 = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
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
