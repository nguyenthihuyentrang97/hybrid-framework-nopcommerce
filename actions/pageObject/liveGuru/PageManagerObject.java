package pageObject.liveGuru;

import org.openqa.selenium.WebDriver;

public class PageManagerObject {

	public static RegisterPageObject getRegisterPage(WebDriver driver) {

		return new RegisterPageObject(driver);

	}

	public static HomePageObject getHomePage(WebDriver driver) {

		return new HomePageObject(driver);
	}

	public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {

		return new EditCustomerPageObject(driver);
	}

	public static FundTransferPageObject getFundTransferPage(WebDriver driver) {

		return new FundTransferPageObject(driver);
	}

	public static ManagerHomePageObject getManagerHomePageObject(WebDriver driver) {

		return new ManagerHomePageObject(driver);
	}

	public static NewAccountPageObject getNewAccountPageObject(WebDriver driver) {

		return new NewAccountPageObject(driver);
	}

	public static NewCustomerPageObject getNewCustomerPageObject(WebDriver driver) {

		return new NewCustomerPageObject(driver);
	}

	public static WithDrawalPageObject getWithDrawalPageObject(WebDriver driver) {

		return new WithDrawalPageObject(driver);
	}
	
	public static AccessDetailPageObject getAccessDetailPageObject(WebDriver driver) {

		return new AccessDetailPageObject(driver);
	}

	public static DepositPageObject getDepositPageObject(WebDriver driver) {

		return new DepositPageObject(driver);
	}

}
