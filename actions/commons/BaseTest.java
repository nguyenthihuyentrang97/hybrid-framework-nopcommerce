package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private WebDriver driverBaseTest;

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driverBaseTest = new FirefoxDriver();

		} else if (browserName.equals("h_firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			options.addArguments("-headless");

			options.addArguments("windows-size=1920x1080");

			driverBaseTest = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driverBaseTest = new ChromeDriver();

		} else if (browserName.equals("h_chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");

			options.addArguments("windows-size=1920x1080");

			driverBaseTest = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			driverBaseTest = new EdgeDriver();

		} else if (browserName.equals("coccoc")) {

			WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();

			ChromeOptions options = new ChromeOptions();

			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");

			driverBaseTest = new ChromeDriver(options);

		} else {

			throw new RuntimeException("Browser name invalid");
		}

		driverBaseTest.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driverBaseTest.get("https://demo.nopcommerce.com/");

		return driverBaseTest;
	}

	public int fakeNumber() {

		Random random = new Random();
		return random.nextInt(99999);

	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
