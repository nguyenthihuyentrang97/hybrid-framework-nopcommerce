package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class LoginPageObject extends BasePage {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver, pageUI.liveGuru.LoginPageUI.CREATE_BUTTON);
		clickToElement(driver, pageUI.liveGuru.LoginPageUI.CREATE_BUTTON);
		return PageGeneratorManager.getRegisterPage(driver);

	}

	public void inputEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, pageUI.liveGuru.LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, pageUI.liveGuru.LoginPageUI.EMAIL_TEXTBOX, emailAddress);

	}

	public void inputPasswordTextbox(String passWord) {
		waitForElementVisible(driver, pageUI.liveGuru.LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, pageUI.liveGuru.LoginPageUI.PASSWORD_TEXTBOX, passWord);

	}

	public AccountPageObject clickLoginButton() {
		waitForElementClickable(driver, pageUI.liveGuru.LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, pageUI.liveGuru.LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAccountPage(driver);
	}

}
