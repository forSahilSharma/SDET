package com.sdet.junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {
	WebDriver driver;
	
	@Test
	public void chrome() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void edge() throws InterruptedException
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("http://www.leafground.com/");
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		driver.quit();
	}
}
