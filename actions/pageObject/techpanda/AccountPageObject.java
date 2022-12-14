package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.techpanda.AccountPageUI;

public class AccountPageObject extends BasePage {
	WebDriver driver;

	public AccountPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public String getTextRegisterSuccess() {
		waitForElementVisible(driver, AccountPageUI.TEXT_REGISTER_SUCCESS);

		return getTextElement(driver, AccountPageUI.TEXT_REGISTER_SUCCESS);
	}

	public void clickToAccountButton() {
		waitForElementClickable(driver, AccountPageUI.ACCOUNT_BUTTON);

		clickToElement(driver, AccountPageUI.ACCOUNT_BUTTON);

	}

	public void clickToLogoutButton() {
		waitForElementClickable(driver, AccountPageUI.LOGOUT_BUTTON);

		clickToElement(driver, AccountPageUI.LOGOUT_BUTTON);

	}

	public String getTextMyAccount() {
		waitForElementVisible(driver, AccountPageUI.MY_ACCOUNT_TEXT);
		return getTextElement(driver, AccountPageUI.MY_ACCOUNT_TEXT);
	}

}
