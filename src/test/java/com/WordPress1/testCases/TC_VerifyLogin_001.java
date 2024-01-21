package com.WordPress1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WordPress1.pageObjects.LoginPage;



public class TC_VerifyLogin_001 extends BaseClass{

	@Test
	public void VerifyLogin() throws Exception {
		LoginPage login_page=new LoginPage(driver);
		login_page.Login_page(username, password);
		logger.info("Successfully loged in");
		Thread.sleep(10000);
		String page_Title=driver.getTitle();
		System.out.println("Page Title : "+page_Title);
		logger.info("Obtained Page Title");
		if(page_Title.contains("My Home")) {
			Assert.assertTrue(true);
			System.out.println("TC PASS");
		} else { 
			Assert.assertTrue(false);
			System.out.println("TC FAIL");
		}
		}
	
	}
