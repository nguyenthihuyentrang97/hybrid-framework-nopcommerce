package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Register_DRY {

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

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("button#register-button")).click();

		assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");

		assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");

		assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");

		assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");

		assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");

	}

	@Test

	public void TC_02_Register_Invalid_Email() {

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("trang");

		driver.findElement(By.cssSelector("input#LastName")).sendKeys("huyen");

		driver.findElement(By.cssSelector("input#Email")).sendKeys("123@123.126$%");

		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");

		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");

	}

	@Test

	public void TC_03_Register_Success() {

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("trang");

		driver.findElement(By.cssSelector("input#LastName")).sendKeys("huyen");

		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);

		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");

		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

		driver.findElement(By.cssSelector("a.ico-logout")).click();

	}

	@Test

	public void TC_04_Register_Email_Exist() {

		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("trang");

		driver.findElement(By.cssSelector("input#LastName")).sendKeys("huyen");

		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);

		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");

		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");

		driver.findElement(By.cssSelector("button#register-button")).click();

		assertEquals(driver.findElement(By.cssSelector("div.message-error li")).getText(), "The specified email already exists");

	}

	@Test

	public void TC_05_Register_Password_Less_Than_6_Character() {
		
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("trang");

		driver.findElement(By.cssSelector("input#LastName")).sendKeys("huyen");

		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);

		driver.findElement(By.cssSelector("input#Password")).sendKeys("12345");

		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345");

		driver.findElement(By.cssSelector("button#register-button")).click();
		
		assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password must meet the following rules:\n"
				+ "must have at least 6 characters");


	}

	@Test

	public void TC_06_Register_Invalid_ConfirmPassword() {
		
		driver.findElement(By.cssSelector("a.ico-register")).click();

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("trang");

		driver.findElement(By.cssSelector("input#LastName")).sendKeys("huyen");

		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);

		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");

		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123457");

		driver.findElement(By.cssSelector("button#register-button")).click();
		
		assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "The password and confirmation password do not match.");

		
	}

	@AfterClass

	public void afterClass() {

	}

	public int generateFakeNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}
}