package com.inetbanking.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.inetbanking.qa.base.TestBase;

public class ProfilePage extends TestBase {

	@FindBy(className = "main-header")
	WebElement profileHeader;
	
	@FindBy(xpath = "//div[@class='header-text' and text() = 'Forms']")
	WebElement formLink;
	
	@FindBy(xpath = "//span[contains(text(), 'Practice Form')]")
	WebElement practiceFormLink;

	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateProfileHeader() {
		return profileHeader.isDisplayed();
	}
	
	public PracticeFormPage clickOnPracticeFormLink() {
		formLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			if(practiceFormLink.isDisplayed()) {
				practiceFormLink.click();
			}else {
				Assert.fail("Practice form link is not displayed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new PracticeFormPage();
	}

}
