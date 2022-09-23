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

	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {

		BrowserList browserList = BrowserList.valueOf(browserName.toLowerCase());

		if (browserList == BrowserList.FIREFOX) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserList == BrowserList.H_FIREFOX) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			options.addArguments("-headless");

			options.addArguments("windows-size=1920x1080");

			driver = new FirefoxDriver(options);

		} else if (browserList == BrowserList.CHROME) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserList == BrowserList.H_CHROME) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");

			options.addArguments("windows-size=1920x1080");

			driver = new ChromeDriver(options);

		} else if (browserList == BrowserList.EDGE) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browserList == BrowserList.COCCOC) {

			WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();

			ChromeOptions options = new ChromeOptions();

			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");

			driver = new ChromeDriver(options);

		} else {

			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(GlobalConstants.PORTAL_PAGE_URL);

//		driverBaseTest.get("https://demo.guru99.com/");
//		
//		driverBaseTest.get("http://live.techpanda.org/index.php/");
		return driver;
	}

	protected WebDriver getBrowserDriver(String browserName, String environmentName) {

		if (browserName.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else if (browserName.equals("h_firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			options.addArguments("-headless");

			options.addArguments("windows-size=1920x1080");

			driver = new FirefoxDriver(options);

		} else if (browserName.equals("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browserName.equals("h_chrome")) {

			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();

			options.addArguments("--headless");

			options.addArguments("windows-size=1920x1080");

			driver = new ChromeDriver(options);

		} else if (browserName.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browserName.equals("coccoc")) {

			WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();

			ChromeOptions options = new ChromeOptions();

			options.setBinary("C:\\Program Files\\CocCoc\\Browser\\Application\\browser.exe");

			driver = new ChromeDriver(options);

		} else {

			throw new RuntimeException("Browser name invalid");
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();

		driver.get(getEnviromentUrl(environmentName));
		return driver;
	}
	
//	protected String getEnviromentUrl(String enviromentName) {
//
//		String envUrl = null;
//
//		switch (enviromentName) {
//
//		case "PORTAL":
//
//			envUrl = GlobalConstants.PORTAL_PAGE_URL;
//			break;
//
//		case "ADMIN":
//
//			envUrl = GlobalConstants.ADMIN_PAGE_URL;
//
//			break;
//		}
//		return envUrl;
//
//	}

	private String getEnviromentUrl(String severName) {

		String envUrl = null;

		EnviromentList environment = EnviromentList.valueOf(severName.toUpperCase());

		if (environment == EnviromentList.DEV) {

			envUrl = "https://demo.nopcommerce.com";

		} else if (environment == EnviromentList.TEST) {

			envUrl = "https://admin-demo.nopcommerce.com";

		} else if (environment == EnviromentList.STG) {

			envUrl = "";

		} else if (environment == EnviromentList.PRD) {

			envUrl = "";

		}

		return envUrl;

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
