package javaBasic;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {

	WebDriver driver;

	String projectPath = System.getProperty("user.dir");

	@Parameters("browser")

	public void TC_01(String browserName) {

	driver = getBrowserDriver(browserName);
		
	System.out.println(browserName);
		
	driver.quit();

	}

	public WebDriver getBrowserDriver(String browserName) {

		switch (browserName) {

		case "chrome":

			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();

		case "firefox":

			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		case "edge":

			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();

			break;

		default:

			new RuntimeException("Please input correct the browser name!");

			break;

		}

		System.out.println(browserName);
		System.out.println(driver.toString());

		driver.quit();
		return driver;
	}

	@Test

	public void TC_07() {

		int a;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		a = sc.nextInt();

		switch (a) {

		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 12:

			System.out.println("31");

			break;

		case 2:

			System.out.println("28");

			break;

		case 4:
		case 9:
		case 6:
		case 11:
			System.out.println("30");

			break;

		default:

			System.out.println("Nhập lại tháng");

			break;
		}
	}
}
