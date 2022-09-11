package pageObject.nopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.AddressPageUI;
import pageUIs.nopCommer.MyProductReviewPageUI;

public class RewardPointObject extends BasePage {
	WebDriver driver;

	public RewardPointObject(WebDriver driver) {
		this.driver = driver;
	}

	public AddressOject clickToAddressLink() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_LINK);
		clickToElement(driver, AddressPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressOject(driver);
	}

	public MyProductReviewObject clickToMyProductReviewLink() {
		waitForElementVisible(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, MyProductReviewPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewObject(driver);
	}

}
