package pageObject.nopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.AddressPageUI;
import pageUIs.nopCommer.RewardPointPageUI;

public class AddressOject extends BasePage {
	WebDriver driver;

	public AddressOject(WebDriver driver) {
		this.driver = driver;
	}

	public MyProductReviewObject clickToMyProductReviewLink() {
		waitForElementVisible(driver, AddressPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, AddressPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewObject(driver);
	}

	public RewardPointObject clickToRewardPointLink() {
		waitForElementVisible(driver, RewardPointPageUI.REWARD_POINTS);
		clickToElement(driver, RewardPointPageUI.REWARD_POINTS);
		return PageGeneratorManager.getRewardPointObject(driver);
	}

}
