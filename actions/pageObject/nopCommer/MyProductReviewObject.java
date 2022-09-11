package pageObject.nopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.RewardPointPageUI;

public class MyProductReviewObject extends BasePage {
	WebDriver driver;

	public MyProductReviewObject(WebDriver driver) {
		this.driver = driver;
	}

	public RewardPointObject clickToRewardPointLink() {
		waitForElementVisible(driver, RewardPointPageUI.REWARD_POINTS);
		clickToElement(driver, RewardPointPageUI.REWARD_POINTS);
		return PageGeneratorManager.getRewardPointObject(driver);
	}

}
