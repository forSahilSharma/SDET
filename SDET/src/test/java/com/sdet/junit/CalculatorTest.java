package com.sdet.junit;

import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	
	Calculator cal = new Calculator();

	@Test
	public void testAdd() {
		assertEquals(10, cal.add(5, 5));
	}

	@Test
	public void testSub() {
		assertEquals(0, cal.sub(5, 5));
	}

}
