package pageObject.nopCommer;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommer.AddressPageUI;
import pageUIs.nopCommer.RewardPointPageUI;

public class AddressPageOject extends BasePage {
	WebDriver driver;

	public AddressPageOject(WebDriver driver) {
		this.driver = driver;
	}

}
