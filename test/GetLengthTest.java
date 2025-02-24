package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class GetLengthTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "GetLength.csv", numLinesToSkip = 1)
	void CSV_Length(String lower, String higher, String expected, String comments) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(Integer.parseInt(expected), given.getLength(), comments);
	}

}
