package javaBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_06_Condition_Statement {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	public void TC_01() {
		// public static void main(String[] args) {// Chạy theo dạng java application

		// * If

		boolean status = 5 > 3;

		System.out.println(status);

		// Phép gán ( assign)
		int studentNumber = 10;

		// == So sánh
		status = (studentNumber == 10);

		System.out.println(status);

		// If nhận vào 1 điều kiện đúng
		// Kiểm tra duy nhất 1 điều kiện
		// Nếu điều kiện đúng thì sẽ action phần thân
		if (status) {

			// Đúng thì vào phần thân của if
			// Sai thì bỏ qua

			System.out.println("go to if");
		}

		WebDriver driver = new FirefoxDriver();

		WebElement salePopup = driver.findElement(By.id(""));

		// Elemenet luôn luôn có trong DOM dù hiển thị hay không

		if (salePopup.isDisplayed()) {
		}
		// Element không có trong DOM khi popup không hiển thị
		List<WebElement> salePopups = driver.findElements(By.id(""));

		if (salePopups.size() > 0 && salePopups.get(0).isDisplayed()) {

		}

		// Uncheck to checkbox

		WebElement checkBox = driver.findElement(By.id(""));

		if (checkBox.isSelected()) {

			checkBox.click();
		}

		// Check to checkbox

		if (!checkBox.isSelected()) {

			checkBox.click();
		}

	}

	public void TC_02() {


		// * If - else
		// Nếu đúng thì vào if - sai thì vào else
		// Nếu driver start với browser như chrome / firefox/ egde/ safari thì dùng hàm click
		// Thông thường (builtin) của selenium webelement
		
		// Nếu driver là ID thì dùng hàm click của JavascriptExcutor
		
		System.setProperty("webdriver.ie.driver", projectPath + "\\browserDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		
		if(driver.toString().contains("internet explorer")) {
			System.out.println("click by JavaScript Executor");
		} else {
			System.out.println("click by Selenium WebElement");
		}
	}

	@Parameters("browser")

	public void TC_03_if_else_if(String browserName) {
		// * if - else - if
		// Có nhiều điều kiện
		// Best Practice: Không nên if- else quá nhiều
		
		if ( browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		} else if(browserName.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else { // IE/ safari/ cococ/...
			
			throw new RuntimeException("Please input correct the browser name!");

		}
		
		System.out.println(browserName);
		System.out.println(driver.toString());
		
		driver.quit();
	}
	
	public void TC_04_if_else_if() {
		
		// Page Object
		// Dynamic Page
		
		String pageName = "Login";
		
		if (pageName.equals("Login")) {
			
			// Login Page loginPage = new LoginPage();
			// return loginPage;
			
		} else if (pageName.equals("Register")) {

			// Register Page RegisterPage = new RegisterPage();
			// return RegisterPage;
			
		} else {
			// Home Page homePage = new homePage();
			// return homePage;
		}
		
		// * Biểu thức tam nguyên
		// * If - else
		int age = 20;
		
		String access = ( age < 18 ) ? "You can not access" : "Wellcom to our system!";
		
		if ( age < 20) {
			access = "You can not access";
			
		} else {
			
			access = "Wellcom to our system!";
		}
		
		System.out.println(access);
	}

}
