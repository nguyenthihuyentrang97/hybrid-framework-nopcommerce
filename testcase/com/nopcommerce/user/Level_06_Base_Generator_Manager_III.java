package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommer.CustomerInfoPageObject;
import pageObject.nopCommer.HomePageObject;
import pageObject.nopCommer.LoginPageObject;
import pageObject.nopCommer.PageGeneratorManager;
import pageObject.nopCommer.RegisterPageObject;

public class Level_06_Base_Generator_Manager_III extends BaseTest {

	private WebDriver driver;

	private HomePageObject homePage;

	private LoginPageObject loginPage;

	private RegisterPageObject registerPage;

	private CustomerInfoPageObject customerPage;

	private String firstName = "huyen";

	private String lastName = "trang";

	private String validEmail = "abc" + fakeNumber() + "@gmail.vn";

	private String notFoundEmail = "abc" + fakeNumber() + "@gmail.com";

	private String incorrectEmail = "!@#$%^&*#$%";

	private String passWord = "123456";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

		System.out.println("Pre-Condition - Step 01: Click Register link");

		registerPage = homePage.clickToRegisterLink(); // Page A = Page B.action

		System.out.println("Pre-Condition - Step 02: Input required fields");

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(validEmail);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		System.out.println("Pre-Condition - Step 03: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message displayed");

		assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		System.out.println("Pre-Condition - Step 05: Click Logout button");

		homePage = registerPage.clickToLogoutLink();

	}

	@Test

	public void Login_01_Empty_Data() {

		System.out.println("Login_01 - Step 01: Click Login link");

		loginPage = homePage.clickToLoginLink();

		System.out.println("Login_01 - Step 02: Click button");

		loginPage.clickToLoginButton();

		System.out.println("Login_01 - Step 03: Verify error message displayed");

		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {

		System.out.println("Login_02 - Step 01: Click Login link");

		loginPage = homePage.clickToLoginLink();

		System.out.println("Login_02 - Step 02: Input required fields");

		loginPage.inputEmailTextBox(incorrectEmail);

		loginPage.inputPasswordTextBox(passWord);

		System.out.println("Login_02 - Step 03: Click button");

		loginPage.clickToLoginButton();

		System.out.println("Login_02 - Step 04: Verify error message displayed");

		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
	}

	@Test
	public void Login_03_Email_Incorrect() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputEmailTextBox(notFoundEmail);

		loginPage.inputPasswordTextBox(passWord);

		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageLogin(),
				"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Email_Existing_Password_Empty() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputEmailTextBox(validEmail);

		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageLogin(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Email_Existing_Incorrect_Password() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputEmailTextBox(validEmail);

		loginPage.inputPasswordTextBox("12345786");

		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageLogin(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputEmailTextBox(validEmail);

		loginPage.inputPasswordTextBox(passWord);

		homePage = loginPage.clickToLoginButton();

		assertTrue(homePage.isMyAccountLinkDisplay());

		customerPage = homePage.clickToMyAccountLink();

	}

	@AfterClass

	public void afterClass() {

		driver.quit();
	}

}
