package pageObjects.nopCommerceportal.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.User.LoginPageUI;

public class UserLoginPageObject extends BasePage {

	private WebDriver driver;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;

	}

	public UserHomePageObject clickToLoginButton() {

		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);

		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);

		return PageGeneratorManager.getUserHomePage(driver);

	}

	public Object getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, LoginPageUI.ERROR_EMAIL_MESSAGE);

		return getTextElement(driver, LoginPageUI.ERROR_EMAIL_MESSAGE);
	}

	public void inputEmailTextBox(String email) {

		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);

		senkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void inputPasswordTextBox(String passWord) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);

		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);

	}

	public String getErrorMessageLogin() {
		waitForElementVisible(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
		return getTextElement(driver, LoginPageUI.ERROR_LOGIN_MESSAGE);
	}

	public UserHomePageObject loginAsUser(String email,String passWord) {
		
		inputEmailTextBox(email);
		
		inputPasswordTextBox(passWord);
		
		return clickToLoginButton();
	}

}
