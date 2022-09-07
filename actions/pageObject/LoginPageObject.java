package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {

	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public void clickToLoginButton() {

		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);

		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

	}

	public Object getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE);

		return getElementText(driver, LoginPageUI.ERROR_EMAIL_MESSAGE);
	}
}
