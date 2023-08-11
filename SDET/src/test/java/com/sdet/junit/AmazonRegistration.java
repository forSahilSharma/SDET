package com.sdet.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonRegistration {

	//Declare WebDriver Variabe
	WebDriver driver;

	@Test
	public void amazonRegistration() throws InterruptedException
	{
		//Instruct Webdriver Manager to load Chrome Driver
		WebDriverManager.chromedriver().setup();

		//Initiate ChromeDriver
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id=\"createAccountSubmit\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("customerName")).sendKeys("Sahil Sharma");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class=\"a-input-text a-span12 a-spacing-micro auth-required-field auth-require-phone-validation\"]")).sendKeys("1234567890");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div/form/div/div/div[3]/div/input")).sendKeys("xyz.abc@test.com");
		Thread.sleep(2000);
		driver.findElement(By.id("ap_password")).sendKeys("123456");
		Thread.sleep(2000);
		//driver.findElement(By.id("continue")).click();
	}
}
