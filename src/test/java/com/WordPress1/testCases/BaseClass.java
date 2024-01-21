package com.WordPress1.testCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.WordPress1.Library.ReadConfig;
import com.WordPress1.Library.Utility;

public class BaseClass {
	WebDriver driver;
	Logger logger;
	ReadConfig config = new ReadConfig();
	String baseURL = config.getApplicationURL();
	String username = config.getUserName();
	String password = config.getPassword();

	@BeforeMethod
	@Parameters("Browser")
	public void setUp(String browser) {
		logger=Logger.getLogger("Automation");
		PropertyConfigurator.configure("./log4j.properties");
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			System.out.println(result.getName()+ " -This TC is failed with below exception");
			System.out.println(result.getThrowable().getMessage());
			
			Utility.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
