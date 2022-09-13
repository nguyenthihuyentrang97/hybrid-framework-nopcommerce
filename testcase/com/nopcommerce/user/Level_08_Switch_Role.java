package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.NopCommerce.admin.AdminDashBroadPageObject;
import pageObjects.NopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerceportal.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerceportal.portal.UserHomePageObject;
import pageObjects.nopCommerceportal.portal.UserLoginPageObject;
import pageObjects.nopCommerceportal.portal.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest {

	private WebDriver driver;

	private UserHomePageObject userHomePage;

	private UserLoginPageObject userLoginPage;

	private UserRegisterPageObject userRegisterPage;
	
	private UserCustomerInfoPageObject userCustomerInfoPage;

	private AdminLoginPageObject adminLoginPage;

	private AdminDashBroadPageObject adminDashBoardPage;

	private String userFirstName = "huyen";

	private String userLastName = "trang";

	private String userEmail = "abc" + fakeNumber() + "@gmail.vn";

	private String userPassWord = "123456";

	private String adminEmail = "admin@yourstore.com";

	private String adminPassword = "admin";

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(String browserName) {

		driver = getBrowserDriver(browserName);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);

	}

	@Test

	public void Role_01_User_To_Admin() {

		userRegisterPage = userHomePage.clickToRegisterLink(); // Page A = Page B.action

		userRegisterPage.userRegister(userFirstName, userLastName, userEmail, userPassWord, userPassWord);

		assertEquals(userRegisterPage.getSuccessMessage(), "Your registration completed");

		userHomePage = userRegisterPage.clickToLogoutLinkAtUser(driver);

		userLoginPage = userHomePage.clickToLoginLink();

		userHomePage = userLoginPage.loginAsUser(userEmail, userPassWord);

		assertTrue(userHomePage.isMyAccountLinkDisplay());
		
		userCustomerInfoPage = userHomePage.clickToMyAccountLink(driver);
		
		userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUser(driver);
		
		// Navigate link Admin
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);

		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		// Login as Admin Role
		adminDashBoardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);

		assertTrue(adminDashBoardPage.isDashBoardTextDisplay());
		
		adminLoginPage = adminDashBoardPage.clickToLogoutLinkAtAdmin(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {

		adminLoginPage.openPageUrl(driver, GlobalConstants.PORTAL_PAGE_URL);

		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
		userLoginPage = userHomePage.clickToLoginLink();
		
		userHomePage = userLoginPage.loginAsUser(userEmail, userPassWord);

		assertTrue(userHomePage.isMyAccountLinkDisplay());

	}

	@AfterClass

	public void afterClass() {

		driver.quit();
	}

}
