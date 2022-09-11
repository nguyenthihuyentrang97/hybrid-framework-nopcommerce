package com.liveguru.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.liveGuru.AccountPageObject;
import pageObject.liveGuru.HomePageObject;
import pageObject.liveGuru.LoginPageObject;
import pageObject.liveGuru.PageGeneratorManager;
import pageObject.liveGuru.RegisterPageObject;

public class Level_06_Base_Generator_Manager_III extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private AccountPageObject accountPage;

	private String firstName = "huyen", lastName = "trang", emailAddress = "abc" + fakeNumber() + "@gmail.com",
			passWord = "123456";

	@Parameters("browser")
	@BeforeClass

	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test

	public void User_01_Register() {

		loginPage = homePage.clickToMyAccountLink();

		registerPage = loginPage.clickToRegisterButton();

		registerPage.inputToFirtNameTextbox(firstName);

		registerPage.inputToLastNameTextbox(lastName);

		registerPage.inputToEmailAddressTextbox(emailAddress);

		registerPage.inputToPasswordTextbox(passWord);

		registerPage.inputToConfirmPasswordTextbox(passWord);

		accountPage = registerPage.clickToRegisterSubmitButton();

		assertEquals(accountPage.getTextRegisterSuccess(), "Thank you for registering with Main Website Store.");

		accountPage.clickToAccountButton();

		accountPage.clickToLogoutButton();

		sleepInSecond(5);
	}

	@Test

	public void User_02_Login() {

		loginPage = homePage.clickToMyAccountLink();

		loginPage.inputEmailTextbox(emailAddress);

		loginPage.inputPasswordTextbox(passWord);

		accountPage = loginPage.clickLoginButton();

		assertEquals(accountPage.getTextMyAccount(), "MY ACCOUNT");

	}

	@AfterClass

	public void afterClass() {

		driver.quit();
	}
}
