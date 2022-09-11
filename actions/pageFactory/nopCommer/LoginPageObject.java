package pageFactory.nopCommer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;
import pageUIs.nopCommer.LoginPageUI;

public class LoginPageObject extends BasePageFactory{
	
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) { // Khởi tạo hàm
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	
	@FindBy (id = "Email")

	private WebElement emailTextBox;
	
	@FindBy (id = "Password")

	private WebElement passwordTextBox;
	
	@FindBy (xpath ="//button[@class='button-1 login-button']")

	private WebElement buttonLogin;
	
	@FindBy (id = "Email-error")

	private WebElement emailErrorMessage;
	
	@FindBy (xpath = "//div[@class='message-error validation-summary-errors']")

	private WebElement unsuccessErrorMessage;
	
	public void clickToLoginButton() {

		waitForElementClickable(driver, buttonLogin);

		clickToElement(driver, buttonLogin);

	}

	public Object getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);;

		return getElementText(driver,  emailErrorMessage);
	}

	public void inputEmailTextBox(String email) {

		waitForElementVisible(driver, emailTextBox);

		senkeyToElement(driver, emailTextBox, email);

	}

	public void inputPasswordTextBox(String passWord) {
		waitForElementVisible(driver, passwordTextBox);

		senkeyToElement(driver, passwordTextBox, passWord);

	}

	public String getErrorMessageLogin() {
		waitForElementVisible(driver, unsuccessErrorMessage );
		return getElementText(driver, unsuccessErrorMessage );
	}

}
