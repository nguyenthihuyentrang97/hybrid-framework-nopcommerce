package commons;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

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

		WebDriverWait explicitWait = new WebDriverWait(driver, 30);

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

	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		
		return driver.findElement(By.xpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {

		getWebElement(driver, xpathLocator).click();

	}

	public void senkeyToElement(WebDriver driver, String xpathLocator, String textValue) {
		
		WebElement element = getWebElement(driver, xpathLocator);

		element.clear();

		element.sendKeys(textValue);
	}

	public String getElementText(WebDriver driver, String xpathLocator) {

		return driver.findElement(By.xpath(xpathLocator)).getText();
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
}
