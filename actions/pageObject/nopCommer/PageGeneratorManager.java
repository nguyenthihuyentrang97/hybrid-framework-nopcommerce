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

	public static AddressOject getAddressOject(WebDriver driver) {
		return new AddressOject(driver);

	}

	public static RewardPointObject getRewardPointObject(WebDriver driver) {
		return new RewardPointObject(driver);

	}

	public static MyProductReviewObject getMyProductReviewObject(WebDriver driver) {
		return new MyProductReviewObject(driver);

	}

	public static CustomerInfoPageObject getCustomerPageObject(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
