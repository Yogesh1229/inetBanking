package com.inetbanking.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.qa.base.TestBase;
import com.inetbanking.qa.pages.LoginPage;
import com.inetbanking.qa.pages.PracticeFormPage;
import com.inetbanking.qa.pages.ProfilePage;
import com.inetbanking.qa.util.TestUtil;

public class PracticeFormPageTest extends TestBase{

	LoginPage loginPage;
	ProfilePage profilePage;
	PracticeFormPage practiceFormPage;
	
	public PracticeFormPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		profilePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1, enabled = false)
	public void fillStudentRegistrationFormTest() {
		practiceFormPage = profilePage.clickOnPracticeFormLink();
		practiceFormPage.RegisterStudentInformation("Yogesh", "Chugh", "Test@test.com", "1234567890", "Hindi", "Panipat");
	}
	
	@DataProvider
	public Object[][] getTestDataFromExcel() {
		Object data[][] = TestUtil.getTestData("RegistrationFormData");
		return data;
	}
	
	@Test(priority = 2, dataProvider="getTestDataFromExcel")
	public void validateStudentRegistrationFormTest(String firstname, String lastname, String email, 
			String number, String subjects, String address ) {
		practiceFormPage = profilePage.clickOnPracticeFormLink();
		practiceFormPage.RegisterStudentInformation(firstname, lastname, email, number, subjects, address);
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
