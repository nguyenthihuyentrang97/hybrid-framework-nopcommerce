package pageObjects.nopCommerceportal.portal;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.User.RegisterPageUI;

public class UserRegisterPageObject extends BasePage {

	private WebDriver driver;

	public UserRegisterPageObject(WebDriver driver) {

		this.driver = driver;
	}

	public UserRegisterPageObject clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);

		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserRegisterPage(driver);

	}

	public String getErrorMessageAtFirtNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);

		return getTextElement(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);

		return getTextElement(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);

		return getTextElement(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);

		return getTextElement(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);

		return getTextElement(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFristNameTextBox(String userFirstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);

		senkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, userFirstName);

	}

	public void inputToLastNameTextBox(String userLastName) {
		waitForElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);

		senkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, userLastName);

	}

	public void inputToEmailTextBox(String userEmail) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);

		senkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, userEmail);

	}

	public void inputToPasswordTextBox(String userPassWord) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);

		senkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, userPassWord);

	}

	public void inputToConfirmPasswordTextBox(String confirmPassWord) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);

		senkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassWord);

	}
	
	public UserRegisterPageObject userRegister(String userFirstName, String userLastName, String userEmail, String userPassWord, String confirmPassWord) {
		inputToFristNameTextBox(userFirstName);
		inputToLastNameTextBox(userLastName);
		inputToEmailTextBox(userEmail);
		inputToPasswordTextBox(userPassWord);
		inputToConfirmPasswordTextBox(confirmPassWord);
		return clickToRegisterButton();
	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);

		return getTextElement(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}


	public String getErrorMessageExitsEmail() {
		
		waitForElementVisible(driver, RegisterPageUI.EXITING_EMAIL_MESSAGE);

		return getTextElement(driver, RegisterPageUI.EXITING_EMAIL_MESSAGE);
	}

}