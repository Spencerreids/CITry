package test;

import static org.junit.jupiter.api.Assertions.*;

import org.jfree.data.Range;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GetCentralValueTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void general() {
		Range One = new Range(3,7);
		Range Two = new Range(-4,4);
		Range Three = new Range(-9,-3);
		Range Four = new Range(4,4);
		assertAll(
				() -> assertEquals(5,One.getCentralValue(),"Typical positive range"),
				() -> assertEquals(0,Two.getCentralValue(), "Typical Range over 0"),
				() -> assertEquals(-6,Three.getCentralValue(), "Typical Negative Range"),
				() -> assertEquals(4,Four.getCentralValue(), "The Zero Range")
				);
	}
	
	@Test
	void infinity() {
		Range One = new Range(3,Float.POSITIVE_INFINITY);
		Range Two = new Range(Float.NEGATIVE_INFINITY, -3);
		assertAll(
				() -> assertEquals(Float.POSITIVE_INFINITY,One.getCentralValue(),"Infinite ranges yeild Infinite midpoints"),
				() -> assertEquals(Float.NEGATIVE_INFINITY,Two.getCentralValue(), "Infinite ranges yeild infinite midpoints")
				);
	}


}
