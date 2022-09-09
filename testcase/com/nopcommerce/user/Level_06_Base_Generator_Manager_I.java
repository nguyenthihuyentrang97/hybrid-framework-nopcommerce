package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Level_06_Base_Generator_Manager_I  extends BaseTest{

	private WebDriver driver;

	private	HomePageObject homePage;

	private	LoginPageObject loginPage;

	private	RegisterPageObject registerPage;

	private	String firstName = "huyen";

	private	String lastName = "trang";

	private	String validEmail= "abc" + fakeNumber() + "@gmail.vn";
	
	private	String notFoundEmail = "abc" + fakeNumber() + "@gmail.com";
	
	private	String incorrectEmail = "!@#$%^&*#$%";

	private	String passWord = "123456";

	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = new HomePageObject(driver);

		System.out.println("Pre-Condition - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

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

		registerPage.clickToLogoutLink();

		homePage = new HomePageObject(driver);

	}

	@Test

	public void Login_01_Empty_Data() {

		System.out.println("Login_01 - Step 01: Click Login link");
		
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);

		System.out.println("Login_01 - Step 02: Click button");
		
		loginPage.clickToLoginButton();

		System.out.println("Login_01 - Step 03: Verify error message displayed");

		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}
	@Test
	public void Login_02_Invalid_Email() {

		System.out.println("Login_02 - Step 01: Click Login link");

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

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

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputEmailTextBox(notFoundEmail);
		
		loginPage.inputPasswordTextBox(passWord);

		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}
	@Test
	public void Login_04_Email_Existing_Password_Empty() {

		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputEmailTextBox(validEmail);
		
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
		
	}
	@Test
	public void Login_05_Email_Existing_Incorrect_Password() {
		
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputEmailTextBox(validEmail);
		
		loginPage.inputPasswordTextBox("12345786");

		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageLogin(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}
	@Test
	public void Login_06_Valid_Email_Password() {
		
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputEmailTextBox(validEmail);
		
		loginPage.inputPasswordTextBox(passWord);

		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		
		assertTrue(homePage.isMyAccountLinkDisplay());
		
		assertTrue(homePage.isLogoutLinkDisplay());
		
	}

	@AfterClass

	public void afterClass() {

	}

}
