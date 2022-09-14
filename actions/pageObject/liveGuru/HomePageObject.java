package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;
	public HomePageObject(WebDriver driver) {
 
		this.driver = driver;
	}
	public String getUserText() {
		
		waitForElementVisible(driver, HomePageUI.USER_ID_TEXT);
		return getTextElement(driver, HomePageUI.USER_ID_TEXT);
		
	}
	public String getPasswordText() {
		waitForElementVisible(driver, HomePageUI.PASSWORD_TEXT);
		
		return getTextElement(driver, HomePageUI.PASSWORD_TEXT);
		
	}
	public void inputUserIDTextBox(String userID) {
		waitForElementClickable(driver, HomePageUI.USER_ID_TEXTBOX);
		senkeyToElement(driver, HomePageUI.USER_ID_TEXTBOX, userID);
		
	}
	public void inputPasswordTextBox(String password) {
		waitForElementClickable(driver, HomePageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, HomePageUI.PASSWORD_TEXTBOX, password);
		
	}
	public ManagerHomePageObject clickToButtonLogin() {
		waitForElementClickable(driver, HomePageUI.LOGIN_BUTTON);
		clickToElement(driver, HomePageUI.LOGIN_BUTTON);
		return PageManagerObject.getManagerHomePageObject(driver);
		
	}


}
