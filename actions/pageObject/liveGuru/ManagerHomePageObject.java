package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.ManagerHomePageUI;

public class ManagerHomePageObject extends BasePage {

	WebDriver driver;
	public ManagerHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isTextWellcomeDisplay() {
		waitForElementVisible(driver, ManagerHomePageUI.WELLCOME_TEXT);
		return isElementDisplayed(driver, ManagerHomePageUI.WELLCOME_TEXT);
	}


}
