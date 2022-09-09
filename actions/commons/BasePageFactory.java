package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
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
	
	protected void waitForElementVisible(WebDriver driver, WebElement element ) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForAllElementVisible(WebDriver driver, List<WebElement> elements) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

	protected void waitForElementInVisible(WebDriver driver, WebElement element ) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}

	protected void waitForAllElementInVisible(WebDriver driver, List<WebElement> elements) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element ) {

		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeOut);

		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	protected void clickToElement(WebDriver driver,  WebElement element) {

		element.click();

	}

	protected void senkeyToElement(WebDriver driver,  WebElement element, String textValue) {

		element.clear();

		element.sendKeys(textValue);
	}
	
	protected String getElementText(WebDriver driver, WebElement element) {

		return element.getText();

	}
	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {

		return element.isDisplayed();

	}
	
	private long longTimeOut = 30;
}
