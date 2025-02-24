package range;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class GetBoundsTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "GetLowerBounds.csv", numLinesToSkip = 1)
	void CSV_Lower(String lower, String higher, String expected, String comments) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(Integer.parseInt(expected), given.getLowerBound(), comments);
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "GetHigherBounds.csv", numLinesToSkip = 1)
	void CSV_Higher(String lower, String higher, String expected, String comments) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(Integer.parseInt(expected), given.getUpperBound(), comments);
	}

}
