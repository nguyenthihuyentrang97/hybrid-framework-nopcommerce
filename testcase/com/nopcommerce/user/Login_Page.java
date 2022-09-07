package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.HomePageObject;
import pageObject.LoginPageObject;

public class Login_Page {

	private WebDriver driver;

	HomePageObject homePage;

	LoginPageObject loginPage;

	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");

		driver = new FirefoxDriver();

		homePage = new HomePageObject(driver);

		loginPage = new LoginPageObject(driver);

		driver.get("https://demo.nopcommerce.com");
	}

	@Test

	public void TC_01_Login_Emply_Data() {

		homePage.clickToLoginLink();

		loginPage.clickToLoginButton();

		assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");

	}

	@AfterClass

	public void afterClass() {

	}
}
