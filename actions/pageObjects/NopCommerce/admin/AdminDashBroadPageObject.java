package pageObjects.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopCommerce.Admin.AdminDashBoardPageUI;

public class AdminDashBroadPageObject extends BasePage {
	WebDriver driver;

	public AdminDashBroadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashBoardTextDisplay() {
		waitForElementVisible(driver, AdminDashBoardPageUI.DASH_BOARD_TEXT);
		return isElementDisplayed(driver, AdminDashBoardPageUI.DASH_BOARD_TEXT);
	}
}
