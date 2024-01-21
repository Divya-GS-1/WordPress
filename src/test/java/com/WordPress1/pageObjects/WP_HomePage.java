package com.WordPress1.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WP_HomePage {

	WebDriver driver;
	
	public WP_HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
		
	}
	
	
	@FindBy(xpath = "//*[@class='gravatar masterbar__item-me-gravatar']")
	WebElement Profile_icon;
	
	@FindBy(xpath = "//div[@class='profile-gravatar is-in-sidebar']//h2")
	WebElement User_name;
	
	public void clickProfile_icon()
	{
		Profile_icon.click();
	}
	
	public String getProfileName() {
		return User_name.getText();
	}

}

