//package com.nopcommerce.user;
//
//import static org.testng.Assert.assertEquals;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_02_Apply_Base_Page_II {
//
//	WebDriver driver;
//
//	BasePage basePage;
//
//	String projectPath = System.getProperty("user.dir");
//
//	String emailAddress;
//
//	@BeforeClass
//
//	public void beforeClass() {
//
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//
//		driver = new FirefoxDriver();
//
//		basePage = BasePage.getBasePageObject();
//
//		emailAddress = "abc" + generateFakeNumber() + "@mail.vn";
//
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		driver.get("https://demo.nopcommerce.com/");
//	}
//
//	@Test
//
//	public void TC_01_Register_Emply_Data() {
//
//		// Trước khi click element cần wait cho element sẵn sàng click
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//
//	}
//
//	@Test
//
//	public void TC_02_Register_Invalid_Email() {
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "trang");
//
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "huyen");
//
//		basePage.senkeyToElement(driver, "//input[@id='Email']", "123@123.126$%");
//
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//
//	}
//
//	@Test
//
//	public void TC_03_Register_Success() {
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "trang");
//
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "huyen");
//
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-logout']");
//
//	}
//
//	@Test
//
//	public void TC_04_Register_Email_Exist() {
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "trang");
//
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "huyen");
//
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		assertEquals(basePage.getElementText(driver, "//div[@class='message-error validation-summary-errors']//li"),
//				"The specified email already exists");
//
//	}
//
//	@Test
//
//	public void TC_05_Register_Password_Less_Than_6_Character() {
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "trang");
//
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "huyen");
//
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "12345");
//
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "12345");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
//				"Password must meet the following rules:\n" + "must have at least 6 characters");
//
//	}
//
//	@Test
//
//	public void TC_06_Register_Invalid_ConfirmPassword() {
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.senkeyToElement(driver, "//input[@id='FirstName']", "trang");
//
//		basePage.senkeyToElement(driver, "//input[@id='LastName']", "huyen");
//
//		basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
//
//		basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
//
//		basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123457");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
//				"The password and confirmation password do not match.");
//
//	}
//
//	@AfterClass
//
//	public void afterClass() {
//
//	}
//
//	public int generateFakeNumber() {
//		Random rand = new Random();
//		return rand.nextInt(99999);
//	}
//}
