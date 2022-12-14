package pageObject.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.techpanda.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageObject clickToMyAccountLink() {

		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);

		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);

		return PageGeneratorManager.getLoginPage(driver);

	}

}
