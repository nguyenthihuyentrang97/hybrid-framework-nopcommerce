package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.liveGuru.RegisterPageUI;

public class RegisterPageObject extends BasePage{

	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void inputToEmailAddressTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ID);
		
		senkeyToElement(driver, RegisterPageUI.EMAIL_ID, emailAddress);
		
	}
	public HomePageObject clickButtonSubmit() {
		waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
		return PageManagerObject.getHomePage(driver);
	}

}
