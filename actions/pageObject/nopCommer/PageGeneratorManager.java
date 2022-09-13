package pageObject.nopCommer;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePage(WebDriver driver) {

		return new HomePageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {

		return new LoginPageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {

		return new RegisterPageObject(driver);
	}

	public static AddressPageOject getAddressOject(WebDriver driver) {
		return new AddressPageOject(driver);

	}

	public static RewardPointObject getRewardPointObject(WebDriver driver) {
		return new RewardPointObject(driver);

	}

	public static MyProductReviewObject getMyProductReviewObject(WebDriver driver) {
		return new MyProductReviewObject(driver);

	}

	public static CustomerInfoPageObject getCustomerPageObject(WebDriver driver) {

		return new CustomerInfoPageObject(driver);
	}

	public static DownloadPageObject getDownloadPageObject(WebDriver driver) {

		return new DownloadPageObject(driver);
	}

	public static BackInStockPageObject geBackInStockPageObject(WebDriver driver) {

		return new BackInStockPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPageObject(WebDriver driver) {

		return new ChangePasswordPageObject(driver);
	}

	public static OrderPageObject getOrderPageObject(WebDriver driver) {

		return new OrderPageObject(driver);
	}
}
