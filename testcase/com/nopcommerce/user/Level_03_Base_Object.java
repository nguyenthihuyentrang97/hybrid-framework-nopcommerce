package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePageObject;
import pageObject.RegisterPageObject;

public class Level_03_Base_Object {

	private WebDriver driver;

	private RegisterPageObject registerPage;

	private HomePageObject homePage;

	private String projectPath = System.getProperty("user.dir");

	private String firstName = "trang";

	private String lastName = "huyen";

	private String emailAddress;

	private String passWord = "123456";

	@BeforeClass

	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		registerPage = new RegisterPageObject(driver);

		homePage = new HomePageObject(driver);

		emailAddress = "abc" + generateFakeNumber() + "@mail.vn";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
	}

	@Test

	public void TC_01_Register_Emply_Data() {

		homePage.clickToRegisterLink();

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getErrorMessageAtFirtNameTextbox(), "First name is required.");

		assertEquals(registerPage.getErrorMessageAtLastNameTextbox(), "Last name is required.");

		assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");

		assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");

		assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test

	public void TC_02_Register_Invalid_Email() {

		homePage.clickToRegisterLink();

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox("123@123.126$%");

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test

	public void TC_03_Register_Success() {

		homePage.clickToRegisterLink();

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		registerPage.clickToLogoutLink();

	}

	@Test

	public void TC_04_Register_Email_Exist() {

		homePage.clickToRegisterLink();

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getErrorMessageExitsEmail(), "The specified email already exists");

	}

	@Test

	public void TC_05_Register_Password_Less_Than_6_Character() {

		homePage.clickToRegisterLink();

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox("12345");

		registerPage.inputToConfirmPasswordTextBox("12345");

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getErrorMessageAtPasswordTextbox(),
				"Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test

	public void TC_06_Register_Invalid_ConfirmPassword() {

		homePage.clickToRegisterLink();

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(emailAddress);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox("1234567");

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(),
				"The password and confirmation password do not match.");

	}

	@AfterClass

	public void afterClass() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

}
