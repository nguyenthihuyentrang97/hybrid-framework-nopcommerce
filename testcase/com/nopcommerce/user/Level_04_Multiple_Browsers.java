package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Level_04_Multiple_Browsers extends BaseTest {

	private WebDriver driver;

	private RegisterPageObject registerPage;

	private HomePageObject homePage;

	private String firstName = "trang";

	private String lastName = "huyen";

	private String emailAddress;

	private String passWord = "123456";

	@Parameters("browser")

	@BeforeClass

	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = new HomePageObject(driver);

		emailAddress = "abc" + generateFakeNumber() + "@mail.vn";

	}

	@Test

	public void Register_01_Emply_Data() {

		System.out.println("Register_01 - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_01 - Step 02: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Register_01 - Step 03: Verify error message displayed");

		assertEquals(registerPage.getErrorMessageAtFirtNameTextbox(), "First name is required.");

		assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");

		assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");

		assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");

		assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test

	public void Register_02_Invalid_Email() {

		System.out.println("Register_02 - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_02 - Step 02: Input required fields");

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox("123@123.126$%");

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		System.out.println("Register_02 - Step 03: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Register_02 - Step 04: Verify error message displayed");

		assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test

	public void Register_03_Success() {

		System.out.println("Register_03 - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_03 - Step 02: Input required fields");

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		System.out.println("Register_03 - Step 03: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Register_03 - Step 04: Verify success message displayed");

		assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		System.out.println("Register_03 - Step 05: Click Logout button");

		registerPage.clickToLogoutLink();

	}

	@Test

	public void Register_04_Email_Exist() {

		System.out.println("Register_04 - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_04 - Step 02: Input required fields");

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		System.out.println("Register_04 - Step 03: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Register_04 - Step 04: Verify error message displayed");

		assertEquals(registerPage.getErrorMessageExitsEmail(), "The specified email already exists");

	}

	@Test

	public void Register_05_Password_Less_Than_6_Character() {

		System.out.println("Register_05 - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_05 - Step 02: Input required fields");

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox("12345");

		registerPage.inputToConfirmPasswordTextBox("12345");

		System.out.println("Register_05 - Step 03: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Register_05 - Step 04: Verify error message displayed");

		assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test

	public void Register_06_Invalid_ConfirmPassword() {

		System.out.println("Register_06 - Step 01: Click Register link");

		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Register_06 - Step 02: Input required fields");

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox("1234567");

		System.out.println("Register_06 - Step 03: Click Register button");

		registerPage.clickToRegisterButton();

		System.out.println("Register_06 - Step 04: Verify error message displayed");

		assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");

	}

	@AfterClass

	public void afterClass() {

		driver.quit();
	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
