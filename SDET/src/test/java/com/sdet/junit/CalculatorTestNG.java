package com.sdet.junit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTestNG {

	Calculator cal = new Calculator();

	@Test(groups = "Regression", dataProvider = "dpAdd")
	public void addTest(int expvalue, int a, int b) {
		Assert.assertEquals(expvalue, cal.add(a, b));
	}

	@Test(groups = "Regression", dataProvider = "dpAdd")
	public void subTest(int expvalue, int a, int b) {
		Assert.assertEquals(expvalue, cal.sub(a, b));
	}

	@Test(groups = "Smoke", dataProvider = "dpAdd")
	public void multTest(int expvalue, int a, int b)
	{
		Assert.assertEquals(expvalue, cal.multiply(a, b));
	}

	@Test(groups = "Regression", dataProvider = "dpAdd")
	public void divTest(int expvalue, int a, int b)
	{
		Assert.assertEquals(expvalue, cal.multiply(a, b));
	}

	@DataProvider(name = "dpAdd")
	public Object[][] getData()
	{
		Object[][] obj = new Object[][]
				{
			{10,5,5},
			{11,6,5},
			{12,6,5},
			{12,7,5},
			{4,2,2},
			{0,0,0}
				};
				return obj;
	}
}
