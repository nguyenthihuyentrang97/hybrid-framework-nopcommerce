package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {

	private WebDriver driver;

	public HomePageObject(WebDriver driver) { // Khởi tạo hàm
		this.driver = driver;
	}

	public void clickToRegisterLink() {

		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);

		clickToElement(driver, HomePageUI.REGISTER_LINK);

	}

}