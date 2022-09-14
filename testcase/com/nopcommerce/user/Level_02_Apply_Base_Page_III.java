package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_Base_Page_III extends BasePage {

	WebDriver driver;

	String projectPath = System.getProperty("user.dir");

	String emailAddress;

	@BeforeClass

	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		emailAddress = "abc" + generateFakeNumber() + "@mail.vn";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://demo.nopcommerce.com/");
	}

	@Test

	public void TC_01_Register_Emply_Data() {

		// Trước khi click element cần wait cho element sẵn sàng click

		waitForElementClickable(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//a[@class='ico-register']");

		waitForElementClickable(driver, "//button[@id='register-button']");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getTextElement(driver, "//span[@id='FirstName-error']"), "First name is required.");

		assertEquals(getTextElement(driver, "//span[@id='LastName-error']"), "Last name is required.");

		assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Email is required.");

		assertEquals(getTextElement(driver, "//span[@id='Password-error']"), "Password is required.");

		assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");

	}

	@Test

	public void TC_02_Register_Invalid_Email() {

		waitForElementClickable(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//a[@class='ico-register']");

		senkeyToElement(driver, "//input[@id='FirstName']", "trang");

		senkeyToElement(driver, "//input[@id='LastName']", "huyen");

		senkeyToElement(driver, "//input[@id='Email']", "123@123.126$%");

		senkeyToElement(driver, "//input[@id='Password']", "123456");

		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getTextElement(driver, "//span[@id='Email-error']"), "Wrong email");

	}

	@Test

	public void TC_03_Register_Success() {

		waitForElementClickable(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//a[@class='ico-register']");

		senkeyToElement(driver, "//input[@id='FirstName']", "trang");

		senkeyToElement(driver, "//input[@id='LastName']", "huyen");

		senkeyToElement(driver, "//input[@id='Email']", emailAddress);

		senkeyToElement(driver, "//input[@id='Password']", "123456");

		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");

		waitForElementClickable(driver, "//a[@class='ico-logout']");

		clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test

	public void TC_04_Register_Email_Exist() {

		waitForElementClickable(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//a[@class='ico-register']");

		senkeyToElement(driver, "//input[@id='FirstName']", "trang");

		senkeyToElement(driver, "//input[@id='LastName']", "huyen");

		senkeyToElement(driver, "//input[@id='Email']", emailAddress);

		senkeyToElement(driver, "//input[@id='Password']", "123456");

		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

		waitForElementClickable(driver, "//button[@id='register-button']");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getTextElement(driver, "//div[@class='message-error validation-summary-errors']//li"),
				"The specified email already exists");

	}

	@Test

	public void TC_05_Register_Password_Less_Than_6_Character() {

		waitForElementClickable(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//a[@class='ico-register']");

		senkeyToElement(driver, "//input[@id='FirstName']", "trang");

		senkeyToElement(driver, "//input[@id='LastName']", "huyen");

		senkeyToElement(driver, "//input[@id='Email']", emailAddress);

		senkeyToElement(driver, "//input[@id='Password']", "12345");

		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");

		waitForElementClickable(driver, "//button[@id='register-button']");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getTextElement(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\n" + "must have at least 6 characters");

	}

	@Test

	public void TC_06_Register_Invalid_ConfirmPassword() {

		waitForElementClickable(driver, "//a[@class='ico-register']");

		clickToElement(driver, "//a[@class='ico-register']");

		senkeyToElement(driver, "//input[@id='FirstName']", "trang");

		senkeyToElement(driver, "//input[@id='LastName']", "huyen");

		senkeyToElement(driver, "//input[@id='Email']", emailAddress);

		senkeyToElement(driver, "//input[@id='Password']", "123456");

		senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");

		waitForElementClickable(driver, "//button[@id='register-button']");

		clickToElement(driver, "//button[@id='register-button']");

		assertEquals(getTextElement(driver, "//span[@id='ConfirmPassword-error']"),
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
