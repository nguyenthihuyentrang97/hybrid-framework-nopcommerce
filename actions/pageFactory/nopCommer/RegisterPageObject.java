package pageFactory.nopCommer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) { // Khởi tạo hàm
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	
	@FindBy (id = "FirstName")

	private WebElement firstNameTextBox;
	
	@FindBy (id = "LastName")

	private WebElement lastNameTextBox;
	
	@FindBy (id = "Email")

	private WebElement emailTextBox;
	
	@FindBy (id = "Password")

	private WebElement passWordTextBox;
	
	@FindBy (id = "ConfirmPassword")

	private WebElement ConfirmPasswordTextBox;
	
	@FindBy (id = "register-button")

	private WebElement registerButton;
	
	@FindBy (xpath = "//span[@id='FirstName-error']")

	private WebElement firstNameErrorMessage;
	
	@FindBy (xpath ="//span[@id='LastName-error']")

	private WebElement lastNameErrorMessage;
	
	@FindBy (id = "Email-error")

	private WebElement emailErrorMessage;
	
	@FindBy (id = "Password-error")

	private WebElement passwordErrorMessage;
	
	@FindBy (id = "ConfirmPassword-error")

	private WebElement confirmpasswordErrorMessage;
	
	@FindBy (xpath= "//div[@class='result']")

	private WebElement registerSuccessMessage;
	
	@FindBy (xpath= "//a[@class='ico-logout']")

	private WebElement logOutLink;
	
	@FindBy (xpath= "//div[@class='message-error validation-summary-errors']//li")

	private WebElement existingEmailMessage;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);

		clickToElement(driver, registerButton);

	}

	public String getErrorMessageAtFirtNameTextbox() {
		waitForElementVisible(driver, firstNameErrorMessage);

		return getElementText(driver, firstNameErrorMessage);
	}

	public String getErrorMessageAtLastNameTextbox() {
		waitForElementVisible(driver, lastNameErrorMessage);

		return getElementText(driver, lastNameErrorMessage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMessage);

		return getElementText(driver,  emailErrorMessage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMessage);

		return getElementText(driver, passwordErrorMessage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmpasswordErrorMessage);

		return getElementText(driver, confirmpasswordErrorMessage);
	}

	public void inputToFristNameTextBox(String firstName) {
		waitForElementVisible(driver, firstNameTextBox);

		senkeyToElement(driver, firstNameTextBox, firstName);

	}

	public void inputToLastNameTextBox(String lastName) {
		waitForElementVisible(driver, lastNameTextBox);

		senkeyToElement(driver, lastNameTextBox, lastName);

	}

	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, emailTextBox);

		senkeyToElement(driver, emailTextBox, email);

	}

	public void inputToPasswordTextBox(String passWord) {
		waitForElementVisible(driver, passWordTextBox);

		senkeyToElement(driver, passWordTextBox, passWord);

	}

	public void inputToConfirmPasswordTextBox(String confirmPassWord) {
		waitForElementVisible(driver, ConfirmPasswordTextBox);

		senkeyToElement(driver, ConfirmPasswordTextBox, confirmPassWord);

	}

	public String getSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);

		return getElementText(driver, registerSuccessMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver,logOutLink);

		clickToElement(driver, logOutLink);

	}

	public String getErrorMessageExitsEmail() {
		waitForElementVisible(driver, existingEmailMessage);

		return getElementText(driver, existingEmailMessage);
	}

}
