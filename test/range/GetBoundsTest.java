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

class GetBoundsTest {
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"1,5,1,Typical Case",
		"5,5,5,Small Range",
		"-5,5,-5,Negative case",
		"0,10,0,Handling with 0",
		"-10,0,-10,Negative case with 0"
	})
	void CSV_Lower(String lower, String higher, String expected, String comments) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(Integer.parseInt(expected), given.getLowerBound(), comments);
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"1,5,5,Typical Case",
		"5,5,5,Small Range",
		"-5,5,5,",
		"0,10,10,Handling with 0",
		"-10,0,0,Negative case with 0",
		"-20,-10,-10,Full Negative Case",
		"-30,40,40,Overall, it seems that this is an unintentional clone of getLowerBound"

	})
	void CSV_Higher(String lower, String higher, String expected, String comments) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(Integer.parseInt(expected), given.getUpperBound(), comments);
	}

}
