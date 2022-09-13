package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPageObject extends BasePage {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver, pageUI.techpanda.LoginPageUI.CREATE_BUTTON);
		clickToElement(driver, pageUI.techpanda.LoginPageUI.CREATE_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);

	}

	public void inputEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, pageUI.techpanda.LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, pageUI.techpanda.LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void inputPasswordTextbox(String passWord) {
		waitForElementVisible(driver, pageUI.techpanda.LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, pageUI.techpanda.LoginPageUI.PASSWORD_TEXTBOX, passWord);

	}

	public AccountPageObject clickLoginButton() {
		waitForElementClickable(driver, pageUI.techpanda.LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, pageUI.techpanda.LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAccountPage(driver);
	}

}
