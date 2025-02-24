package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EqualsTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void IntendedPass() {
		Range test = new Range(0,5);
		assertTrue(test.equals(new Range(0,5)));
	}
	@Test
	void IntendedFail() {
		Range test = new Range(0,5);
		assertFalse(test.equals(new Range(4,5)));
	}
	@Test
	void SecondIntendedFail() {
		Range test = new Range(0,5);
		assertFalse(test.equals(new Range(4,9)));
	}
	
	@Test
	void Identity() {
		Range test = new Range(0,5);
		assertTrue(test.equals(test));
	}
	@Test
	void InconsistentTypes() {
		Range test = new Range(0,5);
		assertFalse(test.equals(new ArrayList<String>()));
	}
	
	@Test
	void NegativeNumbers() {
		Range test = new Range(-5,10);
		assertTrue(test.equals(new Range(-5,10)));
	}
	
	@Test
	void ZeroRange() {
		Range test = new Range(0,0);
		assertTrue(test.equals(new Range(0,0)));
	}
}
