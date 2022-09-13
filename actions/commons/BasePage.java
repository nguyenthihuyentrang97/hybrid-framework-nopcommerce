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
import pageObject.nopCommer.AddressPageOject;
import pageObject.nopCommer.BackInStockPageObject;
import pageObject.nopCommer.ChangePasswordPageObject;
import pageObject.nopCommer.CustomerInfoPageObject;
import pageObject.nopCommer.DownloadPageObject;
import pageObject.nopCommer.MyProductReviewObject;
import pageObject.nopCommer.OrderPageObject;
import pageObject.nopCommer.PageGeneratorManager;
import pageObject.nopCommer.RewardPointObject;
import pageUIs.nopCommer.BasePageUI;

public class BasePage {

	protected static BasePage getBasePageObject() {

		return new BasePage();
	}

	protected void openPageUrl(WebDriver driver, String pageUrl) {

		driver.get(pageUrl);

	}

	protected String getTitle(WebDriver driver) {

		return driver.getTitle();
	}

	protected String getCurrentUrl(WebDriver driver) {

		return driver.getCurrentUrl();
	}

	protected String getPageSourceCode(WebDriver driver) {

		return driver.getPageSource();

	}

	protected void backToPage(WebDriver driver) {

		driver.navigate().back();
	}

	protected void backFowardToPage(WebDriver driver) {

		driver.navigate().forward();
	}

	protected void refreshCurrentPage(WebDriver driver) {

		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {

		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {

		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {

		return waitForAlertPresence(driver).getText();
	}

	protected void senkeyToAlert(WebDriver driver, String textValue) {

		waitForAlertPresence(driver).sendKeys(textValue);
	}

	protected void switchToWindowByID(WebDriver driver, String parentID) {

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

	protected void switchToWindowbyTitle(WebDriver driver, String expectedTitle) {

		Set<String> allWindowID = driver.getWindowHandles();

		for (String id : allWindowID) {

			driver.switchTo().window(id);

			String currentPageTitle = driver.getTitle();

			if (currentPageTitle.equals(expectedTitle)) {

				break;
			}
		}

	}

	protected void closeAllTabWindowWithoutParent(WebDriver driver, String parentID) {

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

	protected void clickToElement(WebDriver driver, String xpathLocator) {

		getWebElement(driver, xpathLocator).click();

	}

	protected void senkeyToElement(WebDriver driver, String xpathLocator, String textValue) {

		WebElement element = getWebElement(driver, xpathLocator);

		element.clear();

		element.sendKeys(textValue);
	}

	protected void selectItemInDefaultDropdown(WebDriver driver, String xpathLocator, String textItem) {

		Select select = new Select(getWebElement(driver, xpathLocator));

		select.selectByValue(textItem);
	}

	protected String getFirstSelectedItemDefaultDropdown(WebDriver driver, String xpathLocator) {

		Select select = new Select(getWebElement(driver, xpathLocator));

		return select.getFirstSelectedOption().getText();

	}

	protected boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {

		Select select = new Select(getWebElement(driver, xpathLocator));

		return select.isMultiple();
	}

	protected void selectItemInCustomDropdown(WebDriver driver, String parentXpathLocator, String childXpathLocator,
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

	protected void sleepInSecond(long timeInSecond) {

		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected String getElementAttribute(WebDriver driver, String xpathLocator, String name) {

		return getWebElement(driver, xpathLocator).getAttribute(name);

	}

	protected String getElementText(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).getText();

	}

	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {

		return getWebElement(driver, xpathLocator).getCssValue(propertyName);

	}

	protected String getHexaColorFromRGBA(String rgbaValue) {

		return Color.fromString(rgbaValue).asHex();

	}

	protected int getElementSize(WebDriver driver, String xpathLocator) {

		return getListWebElement(driver, xpathLocator).size();
	}

	protected void checkToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {

		WebElement element = getWebElement(driver, xpathLocator);

		if (!element.isSelected()) {

			element.click();
		}
	}

	protected void uncheckToDefaultCheckboxRadio(WebDriver driver, String xpathLocator) {

		WebElement element = getWebElement(driver, xpathLocator);

		if (element.isSelected()) {

			element.click();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isDisplayed();

	}

	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isEnabled();

	}

	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {

		return getWebElement(driver, xpathLocator).isSelected();

	}

	protected void switchToFrameIframe(WebDriver driver, String xpathLocator) {

		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}

	protected void switchToDefaultContent(WebDriver driver) {

		driver.switchTo().defaultContent();
	}

	protected void hoverMouseElement(WebDriver driver, String xpathLocator) {

		Actions action = new Actions(driver);

		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	protected void scrollToBottomPage(WebDriver driver) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	protected void highlightElement(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		WebElement element = getWebElement(driver, xpathLocator);

		String originalStyle = element.getAttribute("style");

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				"border: 2px solid red; border-style: dashed;");

		sleepInSecond(1);

		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
				originalStyle);

	}

	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));

	}

	protected void scrollToElement(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));

	}

	protected void removeAttributeInDOM(WebDriver driver, String xpathLocator, String attributeRemove) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, xpathLocator));

	}

	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {

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

	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, xpathLocator));

	}

	protected boolean isImageLoaded(WebDriver driver, String xpathLocator) {

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

	protected void waitForElementVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	protected void waitForAllElementVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(xpathLocator)));
	}

	protected void waitForElementInVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(xpathLocator)));
	}

	protected void waitForAllElementInVisible(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}

	protected void waitForElementClickable(WebDriver driver, String xpathLocator) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(xpathLocator)));
	}
	
	// Nopcommerce
	
	public AddressPageOject clickToAddressLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return PageGeneratorManager.getAddressOject(driver);
	}
	
	public MyProductReviewObject clickToMyProductReviewLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getMyProductReviewObject(driver);
	}

	public RewardPointObject clickToRewardPointLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.REWARD_POINTS_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINTS_LINK);
		return PageGeneratorManager.getRewardPointObject(driver);
	}
	
	public CustomerInfoPageObject clickToCustomerInfoLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CUSTOMER_INFO_LINK);
		clickToElement(driver, BasePageUI.CUSTOMER_INFO_LINK);
		return PageGeneratorManager.getCustomerPageObject(driver);
	}
	
	public DownloadPageObject clickToDownloadableProductLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		clickToElement(driver, BasePageUI.DOWNLOADABLE_PRODUCT_LINK);
		return PageGeneratorManager.getDownloadPageObject(driver);
	}
	
	public BackInStockPageObject clickToBackInStockSubscriptionLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.BACK_IN_STOCK_SUBSCIPTION_LINK);
		clickToElement(driver, BasePageUI.BACK_IN_STOCK_SUBSCIPTION_LINK);
		return PageGeneratorManager.geBackInStockPageObject(driver);
	}
	
	public ChangePasswordPageObject clickToChangePasswordLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_PASSWORD_LINK);
		return PageGeneratorManager.getChangePasswordPageObject(driver);
	}
	
	public OrderPageObject clickToOrderLink(WebDriver driver) {
		waitForElementClickable(driver, BasePageUI.ORDER_LINK);
		clickToElement(driver, BasePageUI.ORDER_LINK);
		return PageGeneratorManager.getOrderPageObject(driver);
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
