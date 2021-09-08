package com.inetbanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="userName")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;

	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(className="main-header")
	WebElement loginHeader;
	
	//Page factory will be used to initialize the web elements
	//Will create constructor of this class
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateLoginHeaderDisplayed() {
		return loginHeader.isDisplayed();
	}
	
	public ProfilePage login(String username, String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new ProfilePage();
	}
}
