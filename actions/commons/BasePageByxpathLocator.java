package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.liveGuru.DepositPageObject;
import pageObject.liveGuru.ManagerHomePageObject;
import pageObject.liveGuru.NewAccountPageObject;
import pageObject.liveGuru.NewCustomerPageObject;
import pageObject.liveGuru.PageManagerObject;
import pageObject.liveGuru.WithDrawalPageObject;
import pageObjects.NopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerceportal.portal.UserAddressPageOject;
import pageObjects.nopCommerceportal.portal.UserBackInStockPageObject;
import pageObjects.nopCommerceportal.portal.UserChangePasswordPageObject;
import pageObjects.nopCommerceportal.portal.UserCustomerInfoPageObject;
import pageObjects.nopCommerceportal.portal.UserDownloadPageObject;
import pageObjects.nopCommerceportal.portal.UserHomePageObject;
import pageObjects.nopCommerceportal.portal.UserMyProductReviewObject;
import pageObjects.nopCommerceportal.portal.UserOrderPageObject;
import pageObjects.nopCommerceportal.portal.UserRewardPointObject;
import pageUIs.nopCommerce.User.BasePageUI;
import pageUIs.nopCommerce.User.HomePageUI;

public class BasePageByxpathLocator {

	public static BasePageByxpathLocator getBasePageObject() {

		return new BasePageByxpathLocator();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {

		driver.get(pageUrl);

	}

	public String getTitle(WebDriver driver) {

		return driver.getTitle();
	}

	public String getCurrentUrl(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	public String getPageSourceCode(WebDriver driver) {

		return driver.getPageSource();

	}

	public void backToPage(WebDriver driver) {

		driver.navigate().back();
	}

	public void backFowardToPage(WebDriver driver) {

		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();
	}

	public Alert waitForAlertPresence(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {

		waitForAlertPresence(driver).accept();
	}

	public void cancelAlert(WebDriver driver) {

		waitForAlertPresence(driver).dismiss();
	}

	public String getAlertText(WebDriver driver) {

		return waitForAlertPresence(driver).getText();
	}

	public void senkeyToAlert(WebDriver driver, String textValue) {

		waitForAlertPresence(driver).sendKeys(textValue);
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {

		Set<String> allWindowID = driver.getWindowHandles();

		for (String id : allWindowID) {

			if (!id.equals(parentID)) {

				driver.switchTo().window(id);

				break;
			}
		}
	}

	private By getByXpath(String xpathLocator) {

		By by = By.xpath(xpathLocator);
		return by;
	}

	public void switchToWindowbyTitle(WebDriver driver, String expectedTitle) {

		Set<String> allWindowID = driver.getWindowHandles();

		for (String id : allWindowID) {

			driver.switchTo().window(id);

			String currentPageTitle = driver.getTitle();

			if (currentPageTitle.equals(expectedTitle)) {

				break;
			}
		}

	}

	public void closeAllTabWindowWithoutParent(WebDriver driver, String parentID) {

		Set<String> allWindowID = driver.getWindowHandles();

		for (String id : allWindowID) {
			if (!id.equals(parentID)) {

				driver.switchTo().window(id);

				driver.close();

			}

		}

		driver.switchTo().window(parentID);
	}

	private WebElement getWebElement(WebDriver driver, String xpathLocator) {

		return driver.findElement(getByXpath(xpathLocator));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {

		return driver.findElements(getByXpath(xpathLocator));

	}

	public void clickToElement(WebDriver driver, String xpathLocator) {

		getWebElement(driver, xpathLocator).click();

	}

	public void senkeyToElement(WebDriver driver, String xpathLocator, String textValue) {

		WebElement element = getWebElement(driver, xpathLocator);

		element.clear();

		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {

		Select select = new Select(getWebElement(driver, xpathLocator));

		select.selectByValue(textItem);
	}

	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {

		Select select = new Select(getWebElement(driver, xpathLocator));

		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {

		Select select = new Select(getWebElement(driver, xpathLocator));

		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentXpathLocator, String childXpathLocator,
			String textExpectedItem) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		getWebElement(driver, parentXpathLocator).click();

		sleepInSecond(1);

		List<WebElement> allItem = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childXpathLocator)));

		for (WebElement item : allItem) {

			if (item.getText().trim().equals(textExpectedItem)) {

				JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;

				jsExcutor.executeScript("arguments[0].scrollsIntoView(true)", item);

				sleepInSecond(1);

				item.click();

				break;
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {

		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String xpathLocator, String name) {

		return getWebElement(driver, xpathLocator).getAttribute(name);

	}

	public String getElementText(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).getText();

	}

	public String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {

		return getWebElement(driver, xpathLocator).getCssValue(propertyName);

	}

	public String getHexaColorFromRGBA(String rgbaValue) {

		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSize(WebDriver driver, String xpathLocator) {

		return getListWebElement(driver, xpathLocator).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {

		WebElement element = getWebElement(driver, xpathLocator);

		if (!element.isSelected()) {

			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {

		WebElement element = getWebElement(driver, xpathLocator);

		if (element.isSelected()) {

			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isDisplayed();

	}

	public boolean isElementEnabled(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isEnabled();

	}

	public boolean isElementSelected(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isSelected();

	}

	public void switchToFrameIframe(WebDriver driver, String xpathLocator) {

		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	public void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	public void hoverMouseElement(WebDriver driver, String xpathLocator) {

		Actions action = new Actions(driver);

		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public void highlightElement(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement element = getWebElement(driver, xpathLocator);

		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");

		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));

	}

	public void scrollToElement(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));

	}

	public void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathLocator));

	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				try {

					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);

				} catch (Exception e) {

					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");

			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathLocator));

	}

	public boolean isImageLoaded(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, xpathLocator));

		if (status) {

			return true;

		} else {

			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForAllElementVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	public void waitForElementInVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	public void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}

	public void waitForElementClickable(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}

	public WebElement getShaDowDOM(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;

		WebElement element = (WebElement) jsExcutor.executeScript("return argments [0].shadowRoort;",
				getWebElement(driver, xpathLocator));

		return element;
	}

	// Nopcommerce

	public UserAddressPageOject clickToAddressLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getUserAddressOject(driver);
	}

	public UserMyProductReviewObject clickToMyProductReviewLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewObject(driver);
	}

	public UserRewardPointObject clickToRewardPointLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getUserRewardPointObject(driver);
	}

	public UserCustomerInfoPageObject clickToCustomerInfoLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getUserCustomerPageObject(driver);
	}

	public UserDownloadPageObject clickToDownloadableProductLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getUserDownloadPageObject(driver);
	}

	public UserBackInStockPageObject clickToBackInStockSubscriptionLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.BACK_IN_STOCK_SUBSCIPTION_LINK);
		clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCIPTION_LINK);
		return PageGeneratorManager.getUserBackInStockPageObject(driver);
	}

	public UserChangePasswordPageObject clickToChangePasswordLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getUserChangePasswordPageObject(driver);
	}

	public UserOrderPageObject clickToOrderLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ORDER_LINK);
		clickToElement(driver, BasePageUI.ORDER_LINK);
		return PageGeneratorManager.getUserOrderPageObject(driver);

	}

	public UserCustomerInfoPageObject clickToMyAccountLink(WebDriver driver) {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerPageObject(driver);
	}

	public UserHomePageObject clickToLogoutLinkAtUser(WebDriver driver) {

		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_USER);

		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_USER);

		return PageGeneratorManager.getUserHomePage(driver);

	}

	public AdminLoginPageObject clickToLogoutLinkAtAdmin(WebDriver driver) {

		waitForElementClickable(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);

		clickToElement(driver, BasePageUI.LOGOUT_LINK_AT_ADMIN);

		return PageGeneratorManager.getAdminLoginPage(driver);

	}

	// LiveGuru

	public NewCustomerPageObject openCustomerLink(WebDriver driver) {
		waitForElementClickable(driver, pageUI.liveGuru.BasePageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, pageUI.liveGuru.BasePageUI.NEW_CUSTOMER_LINK);
		return PageManagerObject.getNewCustomerPageObject(driver);
	}

	public ManagerHomePageObject openManagerHomePageLink(WebDriver driver) {
		waitForElementClickable(driver, pageUI.liveGuru.BasePageUI.MANAGER_LINK);
		clickToElement(driver, pageUI.liveGuru.BasePageUI.MANAGER_LINK);
		return PageManagerObject.getManagerHomePageObject(driver);
	}

	public WithDrawalPageObject openWithDrawalLink(WebDriver driver) {
		waitForElementClickable(driver, pageUI.liveGuru.BasePageUI.WITH_DRAWAL_LINK);
		clickToElement(driver, pageUI.liveGuru.BasePageUI.WITH_DRAWAL_LINK);
		return PageManagerObject.getWithDrawalPageObject(driver);
	}

	public NewAccountPageObject openNewAccountLink(WebDriver driver) {
		waitForElementClickable(driver, pageUI.liveGuru.BasePageUI.NEW_ACCOUNT_LINK);
		clickToElement(driver, pageUI.liveGuru.BasePageUI.NEW_ACCOUNT_LINK);
		return PageManagerObject.getNewAccountPageObject(driver);
	}

	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForElementClickable(driver, pageUI.liveGuru.BasePageUI.DEPOSIT_LINK);
		clickToElement(driver, pageUI.liveGuru.BasePageUI.DEPOSIT_LINK);
		return PageManagerObject.getDepositPageObject(driver);
	}

	private long longTimeOut = 30;

}
