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

public class BasePageAllLocator {

	public static BasePageAllLocator getBasePageObject() {

		return new BasePageAllLocator();
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

	private WebElement getWebElement(WebDriver driver, String locatorType) {

		return driver.findElement(getByLocator(locatorType));
	}

	private List<WebElement> getListWebElement(WebDriver driver, String locatorType) {

		return driver.findElements(getByLocator(locatorType));

	}

	public void clickToElement(WebDriver driver, String locatorType) {

		getWebElement(driver, locatorType).click();

	}

	public void senkeyToElement(WebDriver driver, String locatorType, String textValue) {

		WebElement element = getWebElement(driver, locatorType);

		element.clear();

		element.sendKeys(textValue);
	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {

		Select select = new Select(getWebElement(driver, locatorType));

		select.selectByValue(textItem);
	}

	public String getFirstSelectedItemDefaultDropdown(WebDriver driver, String locatorType) {

		Select select = new Select(getWebElement(driver, locatorType));

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

	public String getElementText(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).getText();

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

	public boolean isElementEnabled(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).isEnabled();

	}

	public boolean isElementSelected(WebDriver driver, String locatorType) {

		return getWebElement(driver, locatorType).isSelected();

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

	public void waitForAllElementVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}

	public void waitForElementInVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}

	public void waitForAllElementInVisible(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}

	public void waitForElementClickable(WebDriver driver, String locatorType) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}

	public WebElement getShaDowDOM(WebDriver driver, String locatorType) {

		JavascriptExecutor jsExcutor = (JavascriptExecutor) driver;

		WebElement element = (WebElement) jsExcutor.executeScript("return argments [0].shadowRoort;",
				getWebElement(driver, locatorType));

		return element;
	}

	private long longTimeOut = 30;

}
