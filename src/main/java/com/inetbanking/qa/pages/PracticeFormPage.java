package com.inetbanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.qa.base.TestBase;

public class PracticeFormPage extends TestBase{

	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="gender-radio-1")
	WebElement gender;
	
	@FindBy(id="userNumber")
	WebElement usernumber;
	
	@FindBy(id="subjectsInput")
	WebElement subjectsinput;
	
	@FindBy(id="hobbies-checkbox-1")
	WebElement hobbies;
	
	@FindBy(id="currentAddress")
	WebElement currentaddress;
	
	public PracticeFormPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterStudentInformation(String firstName, String lastName, String userEmail, 
			String number, String subjects, String address) { 
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		useremail.sendKeys(userEmail);
		usernumber.sendKeys(number);
		subjectsinput.sendKeys(subjects);
		currentaddress.sendKeys(address);
	}
}
