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

class ToStringTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest
	@Timeout (5)
	@CsvSource({
		"1,5,'Range[1.0,5.0]',Overall, ToString seems to accidentally be using midpoint as the lower bound",
		"5,5,'Range[5.0,5.0]',",
		"-5,5,'Range[-5.0,5.0]',",
		"0,10,'Range[0.0,10.0]',",
		"-10,0,'Range[-10.0,0.0]',",
		"-20,-10,'Range[-20.0,-10.0]',",
		"-30,40,'Range[-30.0,40.0]',",

	})
	void toString(String lower, String higher, String expected, String comments) {
		Range given = new Range(Integer.parseInt(lower), Integer.parseInt(higher));
		assertEquals(expected, given.toString(), comments);
	}


}
