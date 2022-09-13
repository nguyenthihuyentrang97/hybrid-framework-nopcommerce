package pageObjects.NopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUI.nopCommerce.Admin.AdminLoginPageUI;

public class AdminLoginPageObject extends BasePage{

	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String adminEmail) {
		waitForElementVisible(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmail);
		
	}

	public void inputToPasswordTextbox(String adminPassWord) {
		waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassWord);
	}

	public AdminDashBroadPageObject clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBroad(driver);
	}
	
	public AdminDashBroadPageObject loginAsAdmin(String adminEmail, String adminPassWord) {
		
		inputToEmailTextbox(adminEmail);
		
		inputToPasswordTextbox(adminPassWord);
		
		return clickToLoginButton();
	}
	
}
