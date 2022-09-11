package pageObject.nopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {

	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, CustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	public AddressOject clickToAddressLink() {
		waitForElementVisible(driver, CustomerInfoPageUI.ADDRESS_LINK);
		clickToElement(driver, CustomerInfoPageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressOject(driver);
	}

}