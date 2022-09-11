package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static pageObject.liveGuru.HomePageObject getHomePage(WebDriver driver) {

		return new pageObject.liveGuru.HomePageObject(driver);

	}

	public static LoginPageObject getLoginPage(WebDriver driver) {

		return new LoginPageObject(driver);

	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {

		return new RegisterPageObject(driver);
	}

	public static AccountPageObject getAccountPage(WebDriver driver) {

		return new AccountPageObject(driver);

	}
}
