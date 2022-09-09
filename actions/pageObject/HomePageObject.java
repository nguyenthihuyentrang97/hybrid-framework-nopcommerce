package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) { // Khởi tạo hàm
		this.driver = driver;
	}

	public void clickToRegisterLink() {

		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);

		clickToElement(driver, HomePageUI.REGISTER_LINK);

	}

	public void clickToLoginLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);

		clickToElement(driver, HomePageUI.LOGIN_LINK);

	}

	public boolean isMyAccountLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplay() {
		waitForElementVisible(driver, HomePageUI.LOG_OUT_LINK);
		return isElementDisplayed(driver, HomePageUI.LOG_OUT_LINK);
	}

}
