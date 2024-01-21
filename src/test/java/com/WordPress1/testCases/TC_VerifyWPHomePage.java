package com.WordPress1.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.WordPress1.pageObjects.LoginPage;
import com.WordPress1.pageObjects.WP_HomePage;



public class TC_VerifyWPHomePage extends BaseClass {
	
	@Test 
	public void VerifyHomePage() {
		LoginPage login_page=new LoginPage(driver);
		login_page.Login_page(username, password);
		logger.info("Successfully loged in");
		WP_HomePage home=new WP_HomePage(driver);
		home.clickProfile_icon();
		String profile_name= home.getProfileName();
		System.out.println(profile_name+ "-Profile Name");
		logger.info("Profile name is verified successfully");
		
		if(profile_name.contains("Anand")) {
			Assert.assertTrue(true);
			System.out.println("TC PASS");
		} else { 
			Assert.assertTrue(false);
			System.out.println("TC FAIL");
		}
				
	}
}
