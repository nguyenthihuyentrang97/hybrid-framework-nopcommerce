package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerceportal.portal.UserBackInStockPageObject;
import pageObjects.nopCommerceportal.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerceportal.portal.UserDownloadPageObject;
import pageObjects.nopCommerceportal.portal.UserMyProductReviewObject;
import pageObjects.NopCommerce.admin.AdminDashBroadPageObject;
import pageObjects.NopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerceportal.portal.UserAddressPageOject;
import pageObjects.nopCommerceportal.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerceportal.portal.UserHomePageObject;
import pageObjects.nopCommerceportal.portal.UserLoginPageObject;
import pageObjects.nopCommerceportal.portal.UserOrderPageObject;
import pageObjects.nopCommerceportal.portal.UserRegisterPageObject;
import pageObjects.nopCommerceportal.portal.UserRewardPointObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePage(WebDriver driver) {

		return new UserHomePageObject(driver);
	}

	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {

		return new UserLoginPageObject(driver);
	}

	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {

		return new UserRegisterPageObject(driver);
	}

	public static UserAddressPageOject getUserAddressOject(WebDriver driver) {
		return new UserAddressPageOject(driver);

	}

	public static UserRewardPointObject getUserRewardPointObject(WebDriver driver) {
		return new UserRewardPointObject(driver);

	}

	public static UserMyProductReviewObject getUserMyProductReviewObject(WebDriver driver) {
		return new UserMyProductReviewObject(driver);

	}

	public static UserCustomerInfoPageObject getUserCustomerPageObject(WebDriver driver) {

		return new UserCustomerInfoPageObject(driver);
	}

	public static UserDownloadPageObject getUserDownloadPageObject(WebDriver driver) {

		return new UserDownloadPageObject(driver);
	}

	public static UserBackInStockPageObject getUserBackInStockPageObject(WebDriver driver) {

		return new UserBackInStockPageObject(driver);
	}

	public static UserChangePasswordPageObject getUserChangePasswordPageObject(WebDriver driver) {

		return new UserChangePasswordPageObject(driver);
	}

	public static UserOrderPageObject getUserOrderPageObject(WebDriver driver) {

		return new UserOrderPageObject(driver);
	}
	
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {

		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashBroadPageObject  getAdminDashBroad(WebDriver driver) {

		return new AdminDashBroadPageObject(driver);
	}
}
