package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.nopCommer.AddressOject;
import pageObject.nopCommer.CustomerInfoPageObject;
import pageObject.nopCommer.HomePageObject;
import pageObject.nopCommer.LoginPageObject;
import pageObject.nopCommer.MyProductReviewObject;
import pageObject.nopCommer.PageGeneratorManager;
import pageObject.nopCommer.RegisterPageObject;
import pageObject.nopCommer.RewardPointObject;

public class Level_07_Switch_Page extends BaseTest {

	private WebDriver driver;

	private HomePageObject homePage;

	private LoginPageObject loginPage;

	private RegisterPageObject registerPage;

	private CustomerInfoPageObject customerInfoPage;

	private AddressOject addressPage;

	private RewardPointObject rewardPointPage;

	private MyProductReviewObject myProductReviewPage;

	private String firstName = "huyen";

	private String lastName = "trang";

	private String email = "abc" + fakeNumber() + "@gmail.vn";

	private String passWord = "123456";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test

	public void User_01_Register() {

		registerPage = homePage.clickToRegisterLink(); // Page A = Page B.action

		registerPage.inputToFristNameTextBox(firstName);

		registerPage.inputToLastNameTextBox(lastName);

		registerPage.inputToEmailTextBox(email);

		registerPage.inputToPasswordTextBox(passWord);

		registerPage.inputToConfirmPasswordTextBox(passWord);

		registerPage.clickToRegisterButton();

		assertEquals(registerPage.getSuccessMessage(), "Your registration completed");

		homePage = registerPage.clickToLogoutLink();

	}

	@Test
	public void User_02_Login() {

		loginPage = homePage.clickToLoginLink();

		loginPage.inputEmailTextBox(email);

		loginPage.inputPasswordTextBox(passWord);

		homePage = loginPage.clickToLoginButton();

		assertTrue(homePage.isMyAccountLinkDisplay());

	}

	@Test
	public void User_03_Customer_Info() {

		customerInfoPage = homePage.clickToMyAccountLink();

		assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {

		addressPage = customerInfoPage.clickToAddressLink();
		// Customer info -> Address

		myProductReviewPage = addressPage.clickToMyProductReviewLink();
		// Address -> My Product Review

		rewardPointPage = myProductReviewPage.clickToRewardPointLink();
		// My Product Review -> Reward Point

		addressPage = rewardPointPage.clickToAddressLink();
		// Reward point -> Address

		rewardPointPage = addressPage.clickToRewardPointLink();
		// Address -> Reward point

		myProductReviewPage = rewardPointPage.clickToMyProductReviewLink();
		// Reward point -> My Product review
	}

	@Test
	public void User_05_Switch_Role() {

//		Role user -> role admin, role admin -> role user
	}

	@AfterClass

	public void afterClass() {

		driver.quit();
	}

}
