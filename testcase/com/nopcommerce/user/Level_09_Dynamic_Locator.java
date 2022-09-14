package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerceportal.portal.UserAddressPageOject;
import pageObjects.nopCommerceportal.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerceportal.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerceportal.portal.UserHomePageObject;
import pageObjects.nopCommerceportal.portal.UserLoginPageObject;
import pageObjects.nopCommerceportal.portal.UserMyProductReviewObject;
import pageObjects.nopCommerceportal.portal.UserRegisterPageObject;
import pageObjects.nopCommerceportal.portal.UserRewardPointObject;

public class Level_09_Dynamic_Locator extends BaseTest {

	private WebDriver driver;

	private UserHomePageObject userHomePage;

	private UserLoginPageObject userLoginPage;

	private UserRegisterPageObject userRegisterPage;

	private UserCustomerInfoPageObject userCustomerInfoPage;

	private UserAddressPageOject userAddressPage;

	private UserRewardPointObject userRewardPointPage;

	private UserMyProductReviewObject userMyProductReviewPage;

	private UserChangePasswordPageObject userChangePasswordPage;

	private String firstName = "huyen";

	private String lastName = "trang";

	private String email = "abc" + fakeNumber() + "@gmail.vn";

	private String passWord = "123456";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test

	public void User_01_Register_Login() {

		userRegisterPage = userHomePage.clickToRegisterLink(); // Page A = Page B.action

		userRegisterPage.inputToFristNameTextBox(firstName);

		userRegisterPage.inputToLastNameTextBox(lastName);

		userRegisterPage.inputToEmailTextBox(email);

		userRegisterPage.inputToPasswordTextBox(passWord);

		userRegisterPage.inputToConfirmPasswordTextBox(passWord);

		userRegisterPage.clickToRegisterButton();

		assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickToLogoutLinkAtUser(driver);

		userLoginPage = userHomePage.clickToLoginLink();

		userLoginPage.inputEmailTextBox(email);

		userLoginPage.inputPasswordTextBox(passWord);

		userHomePage = userLoginPage.clickToLoginButton();

		assertTrue(userHomePage.isMyAccountLinkDisplay());

		userCustomerInfoPage = userHomePage.clickToMyAccountLink(driver);

		assertTrue(userCustomerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void User_02_Switch_Page() {

		userAddressPage = userCustomerInfoPage.clickToAddressLink(driver);
		// Customer info -> Address

		userMyProductReviewPage = userAddressPage.clickToMyProductReviewLink(driver);
		// Address -> My Product Review

		userRewardPointPage = userMyProductReviewPage.clickToRewardPointLink(driver);
		// My Product Review -> Reward Point

		userAddressPage = userRewardPointPage.clickToAddressLink(driver);
		// Reward point -> Address

		userRewardPointPage = userAddressPage.clickToRewardPointLink(driver);
		// Address -> Reward point

		userMyProductReviewPage = userRewardPointPage.clickToMyProductReviewLink(driver);
		// Reward point -> My Product review

		userChangePasswordPage = userMyProductReviewPage.clickToChangePasswordLink(driver);

		userMyProductReviewPage = userRewardPointPage.clickToMyProductReviewLink(driver);

		userRewardPointPage = userCustomerInfoPage.clickToRewardPointLink(driver);

	}

	@Test
	public void User_03_Dynamic_Page_01() {

		userAddressPage = (UserAddressPageOject) userRewardPointPage.openPageAtMyAccountByName(driver, "Addresses");
		// Reward point -> Address

		userRewardPointPage = (UserRewardPointObject) userAddressPage.openPageAtMyAccountByName(driver,
				"Reward points");
		// Address -> Reward point

		userMyProductReviewPage = (UserMyProductReviewObject) userRewardPointPage.openPageAtMyAccountByName(driver,
				"My product reviews");
		// Reward point -> My Product review

		userChangePasswordPage = (UserChangePasswordPageObject) userMyProductReviewPage
				.openPageAtMyAccountByName(driver, "Change password");

		userMyProductReviewPage = (UserMyProductReviewObject) userRewardPointPage.openPageAtMyAccountByName(driver,
				"My product reviews");

		userRewardPointPage = (UserRewardPointObject) userCustomerInfoPage.openPageAtMyAccountByName(driver,
				"Reward points");
	}

	@AfterClass

	public void afterClass() {

		driver.quit();
	}

}
