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

public class BasePage {

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

	private By getByLocator(String locatorType) {

		By by = null;

		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {

			by = By.id(locatorType.substring(3));

		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=")
				|| locatorType.startsWith("Class=")) {

			by = By.className(locatorType.substring(6));

		} else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=")
				|| locatorType.startsWith("Name=")) {

			by = By.name(locatorType.substring(5));

		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
				|| locatorType.startsWith("Xpath=") || locatorType.startsWith("XPath=")) {

			by = By.xpath(locatorType.substring(6));

		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {

			by = By.cssSelector(locatorType.substring(6));
		} else {

			throw new RuntimeException("Locator type is not support! ");
		}
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

	private String getDynamicXpath(String locatorType, String... dynamicValues) {

		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")
				|| locatorType.startsWith("XPath=")) {

			locatorType = String.format(locatorType, (Object[]) dynamicValues);
		}
		return locatorType;
	}

	private WebElement getWebElement(WebDriver driver, String locatorType) {

		return driver.findElement(getByLocator(locatorType));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String locatorType) {

		return driver.findElements(getByLocator(locatorType));

	}

	public void clickToElement(WebDriver driver, String locatorType) {

		getWebElement(driver, locatorType).click();

	}

	public void clickToElementDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).click();

	}

	public void senkeyToElement(WebDriver driver, String locatorType, String textValue) {

		WebElement element = getWebElement(driver, locatorType);

		element.clear();

		element.sendKeys(textValue);
	}

	public void senkeyToElementDymamic(WebDriver driver, String locatorType, String textValue,
			String... dynamicValues) {

		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));

		element.clear();

		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {

		Select select = new Select(getWebElement(driver, locatorType));

		select.selectByValue(textItem);
	}

	public void selectItemInDefaultDropdownDynamic(WebDriver driver, String locatorType, String textItem,
			String... dynamicValues) {

		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));

		select.selectByValue(textItem);
	}

	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {

		Select select = new Select(getWebElement(driver, locatorType));

		return select.getFirstSelectedOption().getText();

	}

	public String getFirstSelectedItemDefaultDropdownDynamic(WebDriver driver, String locatorType,
			String... dynamicValues) {

		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)));

		return select.getFirstSelectedOption().getText();

	}

	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {

		Select select = new Select(getWebElement(driver, locatorType));

		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentlocatorType, String childlocatorType,
			String textExpectedItem) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		getWebElement(driver, parentlocatorType).click();

		sleepInSecond(1);

		List<WebElement> allItem = explicitWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childlocatorType)));

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

	public String getElementAttribute(WebDriver driver, String locatorType, String name) {

		return getWebElement(driver, locatorType).getAttribute(name);

	}

	public String getElementAttributeDynamic(WebDriver driver, String locatorType, String name,
			String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getAttribute(name);

	}

	public String getTextElement(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).getText();

	}

	public String getTextElementDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();

	}

	public String getElementCssValue(WebDriver driver, String locatorType, String propertyName) {

		return getWebElement(driver, locatorType).getCssValue(propertyName);

	}

	public String getHexaColorFromRGBA(String rgbaValue) {

		return Color.fromString(rgbaValue).asHex();

	}

	public int getElementSize(WebDriver driver, String locatorType) {

		return getListWebElement(driver, locatorType).size();
	}

	public int getElementSizeDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		return getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).size();
	}

	public void checkToDefaultCheckboxRadio(WebDriver driver, String locatorType) {

		WebElement element = getWebElement(driver, locatorType);

		if (!element.isSelected()) {

			element.click();
		}
	}

	public void uncheckToDefaultCheckboxRadio(WebDriver driver, String locatorType) {

		WebElement element = getWebElement(driver, locatorType);

		if (element.isSelected()) {

			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).isDisplayed();

	}

	public boolean isElementDisplayedDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isDisplayed();

	}

	public boolean isElementEnabled(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).isEnabled();

	}

	public boolean isElementEnabledDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isEnabled();

	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).isSelected();

	}

	public boolean isElementSelectedDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		return getWebElement(driver, getDynamicXpath(locatorType, dynamicValues)).isSelected();

	}

	public void switchToFrameIframe(WebDriver driver, String locatorType) {

		driver.switchTo().frame(getWebElement(driver, locatorType));
	}

	public void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	public void hoverMouseElement(WebDriver driver, String locatorType) {

		Actions action = new Actions(driver);

		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public void highlightElement(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement element = getWebElement(driver, locatorType);

		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");

		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	public void highlightElementDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement element = getWebElement(driver, getDynamicXpath(locatorType, dynamicValues));

		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");

		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	public void clickToElementByJS(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));

	}

	public void scrollToElement(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));

	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locatorType));

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

	public String getElementValidationMessage(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locatorType));

	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));

		if (status) {

			return true;

		} else {

			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementVisibleDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions
				.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForAllElementVisibleDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions
				.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	public void waitForAllElementInVisibleDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions
				.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType, dynamicValues))));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public void waitForElementClickableDynamic(WebDriver driver, String locatorType, String... dynamicValues) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(
				ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType, dynamicValues))));
	}

	public WebElement getShaDowDOM(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;

		WebElement element = (WebElement) jsExcutor.executeScript("return argments [0].shadowRoort;",
				getWebElement(driver, locatorType));

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

	// Tối ưu dynamic

	public BasePage openPageAtMyAccountByName(WebDriver driver, String pageName) {

		waitForElementClickableDynamic(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);

		clickToElementDynamic(driver, BasePageUI.DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA, pageName);

		switch (pageName) {

		case "Addresses":

			return PageGeneratorManager.getUserAddressOject(driver);

		case "My product reviews":

			return PageGeneratorManager.getUserMyProductReviewObject(driver);

		case "Reward points":

			return PageGeneratorManager.getUserRewardPointObject(driver);

		case "Customer info":

			return PageGeneratorManager.getUserCustomerPageObject(driver);

		case "Downloadable products":

			return PageGeneratorManager.getUserDownloadPageObject(driver);

		case "Back in stock subscriptions":

			return PageGeneratorManager.getUserBackInStockPageObject(driver);

		case "Change password":

			return PageGeneratorManager.getUserChangePasswordPageObject(driver);

		case "Orders":

			return PageGeneratorManager.getUserOrderPageObject(driver);

		default:
			throw new RuntimeException("Invalid page name My account area.");
		}

	}

	// Switch Role
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
