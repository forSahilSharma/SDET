package com.sdet.junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


// This file contains 2 methods loginAndRegister() & findAndView() and both methods can only be run one by one. One method has to be commented before runnign the other.

public class OpenMRS {
	WebDriver driver;
	
	@org.testng.annotations.BeforeClass
	public void beforeClass()
	{
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	}
	
	/*
	 * Test Scenario’s: Login, Logout, Register a Patient, Find Patient Record, View the Patient, Search a Patient, Book an Appointment
	 * Automate all the scenarios and submit the script
	 * (copy paste to notepad) and share it to my mail Id on or before 10th July 2023
	 */
	
  @Test
  public void loginAndRegister() throws InterruptedException
  {
	  //Login to OpenMRS
	    driver.get("https://demo.openmrs.org/openmrs/login.htm");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("username")).sendKeys("Admin");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).sendKeys("Admin123");
	    Thread.sleep(1000);
	    driver.findElement(By.id("Inpatient Ward")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input[class=\"btn confirm\"]")).click();
	    Thread.sleep(3000);
	    
	  //Register a Patient
	    driver.findElement(By.id("referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")).click();
	    Thread.sleep(3000);      
	    driver.findElement(By.name("givenName")).sendKeys("Amanda");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@name=\"familyName\"]")).sendKeys("Rees");
	    driver.findElement(By.id("next-button")).click();
	    Thread.sleep(2000);
	    
	    Select gender = new Select(driver.findElement(By.id("gender-field")));
	    gender.selectByValue("M");
	    Thread.sleep(1000);
	    driver.findElement(By.id("next-button")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//input[@id=\"birthdateDay-field\"]")).sendKeys("30");
	    Thread.sleep(1000);
	    Select month = new Select(driver.findElement(By.xpath("//select[@id=\"birthdateMonth-field\"]")));
	    month.selectByVisibleText("December");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"birthdateYear-field\"]")).sendKeys("1989");
	    Thread.sleep(1000);
	    driver.findElement(By.id("next-button")).click();
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("Green Park Residency");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"address2\"]")).sendKeys("Street 5A");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"cityVillage\"]")).sendKeys("Noida");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"stateProvince\"]")).sendKeys("UP");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"country\"]")).sendKeys("India");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"postalCode\"]")).sendKeys("301201");
	    Thread.sleep(1000);
	    driver.findElement(By.id("next-button")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name=\"phoneNumber\"]")).sendKeys("1234567890");
	    Thread.sleep(1000);
	    driver.findElement(By.id("next-button")).click();
	    Thread.sleep(2000);
	    
	    Select relationshipType = new Select(driver.findElement(By.id("relationship_type")));
	    relationshipType.selectByVisibleText("Sibling");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"relationship\"]/p[2]/input[1]")).sendKeys("Arun Kumar");
	    Thread.sleep(2000);
	    driver.findElement(By.id("next-button")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.id("submit")).click();
	    Thread.sleep(3000);
	    
	  //Logout from OpenMRS
	    driver.findElement(By.xpath("//i[@class=\"icon-signout small\"]")).click();
	    Thread.sleep(2000);
	    driver.close();
	    Thread.sleep(2000);
  }
  
  @Test
  public void findAndView() throws InterruptedException
  {
	  //Login to Application
	  driver.get("https://demo.openmrs.org/openmrs/login.htm");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("username")).sendKeys("Admin");
	    Thread.sleep(1000);
	    driver.findElement(By.id("password")).sendKeys("Admin123");
	    Thread.sleep(1000);
	    driver.findElement(By.id("Inpatient Ward")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input[class=\"btn confirm\"]")).click();
	    Thread.sleep(3000);
	    
	    //Find a Patient
	    driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@id=\"patient-search\"]")).sendKeys("Sarah Hall");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"patient-search-results-table\"]/tbody/tr/td[2]")).click();
	    Thread.sleep(5000);
	    
	    //View the Patient & Book an Appointment
	    driver.findElement(By.id("appointmentschedulingui.requestAppointmentDashboardLink")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("appointment-type")).sendKeys("Personal");
	    Thread.sleep(1000);
	    driver.findElement(By.id("provider")).sendKeys("Test Provider");
	    Thread.sleep(1000);
	    driver.findElement(By.id("min-time-frame-value")).sendKeys("1");
	    Thread.sleep(1000);
	    Select day1 = new Select(driver.findElement(By.id("min-time-frame-units")));
	    day1.selectByVisibleText("Day(s)");
	    Thread.sleep(1000);
	    driver.findElement(By.id("max-time-frame-value")).sendKeys("5");
	    Thread.sleep(1000);
	    Select day2 = new Select(driver.findElement(By.id("max-time-frame-units")));
	    day2.selectByVisibleText("Day(s)");
	    Thread.sleep(1000);
	    driver.findElement(By.id("notes")).sendKeys("Please book my Appointment. Thanks.");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@class=\"confirm\"]")).click();
	    Thread.sleep(1000);
	    
	    //Logout from Application
	    driver.findElement(By.xpath("//i[@class=\"icon-signout small\"]")).click();
	    Thread.sleep(2000);
	    driver.close();
  }
  
}
