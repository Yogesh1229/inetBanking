package com.inetbanking.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.inetbanking.qa.base.TestBase;
import com.inetbanking.qa.pages.LoginPage;
import com.inetbanking.qa.pages.ProfilePage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	ProfilePage profilePage;

	public LoginPageTest() {
		// Super will initialize the property file
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "ToolsQA");
	}

	@Test(priority = 2)
	public void loginHeaderTest() {
		Boolean isLoginHeaderDisplayed = loginPage.validateLoginHeaderDisplayed();
		Assert.assertTrue(isLoginHeaderDisplayed);
	}

	@Test(priority = 3)
	public void loginTest() {
		profilePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(profilePage.validateProfileHeader(), "Login not successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
