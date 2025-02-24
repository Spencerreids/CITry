package range;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class ConstructorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "ConstructorPass.csv", numLinesToSkip = 1)
	void CSVConstructorsPass( String lower, String higher, String comments) {
		assertDoesNotThrow(()-> new Range(Integer.parseInt(lower), Integer.parseInt(higher)),comments);
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvFileSource(resources = "ConstructorThrow.csv", numLinesToSkip = 1)
	void CSVConstructorsThrow(String lower, String higher, String comments) {
		assertThrows(RuntimeException.class,()-> new Range(Integer.parseInt(lower), Integer.parseInt(higher)),comments);
	}
	// NAN values are presumed to be invalid for this use case. It appears this implementation does not 
	// follow the same structure
	@Test
	void NANTest() {
		assertAll(
				()->assertThrows(RuntimeException.class,()-> new Range (Float.NaN, Float.NaN),"This should probably throw some sort of error"),
				()->assertThrows(RuntimeException.class,()-> new Range (0, Float.NaN),"This should probably throw some sort of error"),
				()->assertThrows(RuntimeException.class,()-> new Range (Float.NaN, 0),"This should probably throw some sort of error")
				);
	}
	

}
