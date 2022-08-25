package javaBasic;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic_02_Data_Type {
// Global variable

	static int number;

// Primitive type: Kiểu dữ liệu nguyên thủy	

	byte bNumber = 6;

	short sNumber = 1500;

	int iNumber = 6500;

	long lNumber = 65000;

	float fNumber = 15.67f;

	double dNumber = 15.28d;

	char cChar = '1';

	boolean bStatus = true;

	// Reference type: Kiểu dữ kiệu tham chiếu
	// String

	String address = " Ha noi";

	// Array
	String[] studentAddress = { address, "Ho Chi Minh", "Da Nang" };

	Integer[] studentNumber = { 15, 20, 50 };

	// class
	Topic_02_Data_Type topic;

	// Interface
	WebDriver driver;

	// Object
	Object aObject;
	
	// Collection
	// List/ Set/ Queue/ Map
	List<WebElement> homePageLinks = driver.findElements(By.tagName("a"));
	
	Set<String> allWindows = driver.getWindowHandles();
	
	List<String> productName = new ArrayList<String>();
	
	
	// Khác nhau giữa dữ liệu nguyên thủy và tham chiếu
//	1. Nguyên thủy không có funcion đi theo
//	
//	VD: 
//		
	public void clickToElemnet() {
//	fNumber. - Không có funcion đi theo

	address.trim();
	
	studentAddress.clone();
	
	driver.getCurrentUrl();
	
	homePageLinks.clear();
	
	aObject.toString();
	
	allWindows.clear();
	
	Topic_02_Data_Type topic = new Topic_02_Data_Type();
	
	topic.address = "Ho Chi Minh";
	
	}
	
//	2. Cách thức lưu trữ dư liệu
	
	// 

	public static void main(String[] args) {
		// Local variable

		int studentNumber = 5;

		Topic_02_Data_Type topic = new Topic_02_Data_Type();

		System.out.println(number);

		System.out.println(studentNumber);

		System.out.println(topic.address);
	}
}
