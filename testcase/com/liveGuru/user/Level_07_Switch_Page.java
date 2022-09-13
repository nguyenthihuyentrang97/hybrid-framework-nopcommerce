package com.liveGuru.user;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.AccessDetailPageObject;
import pageObject.liveGuru.DepositPageObject;
import pageObject.liveGuru.EditCustomerPageObject;
import pageObject.liveGuru.FundTransferPageObject;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.ManagerHomePageObject;
import pageObject.liveGuru.NewAccountPageObject;
import pageObject.liveGuru.NewCustomerPageObject;
import pageObject.liveGuru.PageManagerObject;
import pageObject.liveGuru.RegisterPageObject;
import pageObject.liveGuru.WithDrawalPageObject;

public class Level_07_Switch_Page extends BaseTest {

	WebDriver driver;

	EditCustomerPageObject editCustomerPage;

	FundTransferPageObject funTransferPage;

	HomePageObject homePage;

	ManagerHomePageObject managerHomePagePage;

	NewAccountPageObject newAccountPage;

	NewCustomerPageObject newCustomerPage;

	RegisterPageObject registerPage;

	WithDrawalPageObject withDrawalPage;

	AccessDetailPageObject accessDetailPage;
	
	DepositPageObject depositPage;

	String emailAddress = "abc" + fakeNumber() + "@gmail.com";

	String userID;

	String password;

	@Parameters("browser")

	@BeforeClass

	public void Beforeclass(String browserName) {

		driver = getBrowserDriver(browserName);

		registerPage = PageManagerObject.getRegisterPage(driver);
	}

	@Test

	public void User_01_Register() {

		registerPage.inputToEmailAddressTextbox(emailAddress);

		homePage = registerPage.clickButtonSubmit();
	}

	@Test

	public void User_02_Login() {

		userID = homePage.getUserText();

		password = homePage.getPasswordText();

		driver.get("https://demo.guru99.com/v4/");

		homePage.inputUserIDTextBox(userID);

		homePage.inputPasswordTextBox(password);

		managerHomePagePage = homePage.clickToButtonLogin();

		assertTrue(managerHomePagePage.isTextWellcomeDisplay());
	}

	@Test

	public void User_03_Switch_Page() {
		
		newCustomerPage = managerHomePagePage.openCustomerLink(driver);
		
		newAccountPage = newCustomerPage.openNewAccountLink(driver);
		
		withDrawalPage = newAccountPage.openWithDrawalLink(driver);
		
		managerHomePagePage = withDrawalPage.openManagerHomePageLink(driver);
		
		depositPage = managerHomePagePage.openDepositPage(driver);
		
		newCustomerPage = depositPage.openCustomerLink(driver);
	}

	@AfterClass

	public void Afterclass() {

//		driver.quit();
	}
}
