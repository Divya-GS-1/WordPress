package com.WordPress1.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(id = "usernameOrEmail")
	WebElement input_username;
	
	@FindBy(xpath = "//*[@class='button form-button is-primary']")
	WebElement button_continue;
	
	@FindBy(id = "password" )
	WebElement input_password;
	
	@FindBy(xpath = "//*[@class='button form-button is-primary']")
	WebElement button_login;
	
	
	public void Login_page(String user, String pwd) {
		input_username.sendKeys(user);
		button_continue.click();
		input_password.sendKeys(pwd);
		button_login.click();
	}

}
