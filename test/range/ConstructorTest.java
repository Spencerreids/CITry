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
import org.junit.jupiter.params.provider.CsvSource;

class ConstructorTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"3,3,In theory identical low and high range is perfectly valid",
		"-20,10,Testing that negative numbers regardless of absolute scale is valid",
		"-4,20,Typical Negative value case",
		"-4,0,How do negative values compare aginst 0",

	})
	void CSVConstructorsPass( String lower, String higher, String comments) {
		assertDoesNotThrow(()-> new Range(Integer.parseInt(lower), Integer.parseInt(higher)));
	}
	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"0,-1,If this is the only error, issues arise with lower bound=0",
		"-0.01,0,This one handles small errors around 0",
		"5,4,Typical Fail Case",
		"16,6,Typical Fail Case"

	})
	void CSVConstructorsThrow(String lower, String higher, String comments) {
		assertThrows(RuntimeException.class,()-> new Range(Integer.parseInt(lower), Integer.parseInt(higher)));
	}
	// NAN values are presumed to be invalid for this use case. It appears this implementation does not 
	// follow the same structure
	@Test
	void NANTest() {
		assertAll(
				()->assertThrows(RuntimeException.class,()-> new Range (Float.NaN, Float.NaN)),
				()->assertThrows(RuntimeException.class,()-> new Range (0, Float.NaN)),
				()->assertThrows(RuntimeException.class,()-> new Range (Float.NaN, 0))
				);
	}
	

}
