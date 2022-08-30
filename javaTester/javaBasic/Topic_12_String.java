package javaBasic;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_12_String {

	public static void main(String[] args) {

//		System.setProperty("webdriver.gecko.driver", ".\\browserDrivers\\geckodriver.exe");
//		
//		WebDriver driver = new FirefoxDriver();
		
		
		String s1 = "Cat";

		s1 = "Dog";

		String s2 = s1;

		String s3 = new String("Cat");

		System.out.println(s1 == s2); // so sánh giá trị + vùng nhớ

		System.out.println(s1 == s3); // == dùng cho dữ liệu nguyên thủy. equal dùng cho dữ liệu tham chiếu

		System.out.println(s2 == s3);

		System.out.println(s2.equals(s3)); // chỉ so sánh giá trị

		String schoolName = "Automation Testing";

		String schoolAddress = "Hà Nội";

		String courseName = "AUTOMATION TESTING";

		// Lấy ra độ dài chuỗi kí tự. Bdau từ 0 đến ( n - 1)

		schoolName.length();

		System.out.println(schoolName.length());

		// Lấy ra kí tự từ vị trí nào đó

		schoolName.charAt(4);

		System.out.println(schoolName.charAt(4));

		// Nối 2 chuỗi

		System.out.println("Nối 2 chuỗi " + schoolName.concat(schoolAddress));
		System.out.println("Nối 2 chuỗi " + schoolName + (schoolAddress));

		// So sánh tuyệt đối ( equal)

		System.out.println(schoolAddress.equals(schoolName));
		System.out.println(schoolAddress.equals("Hà Nội"));

		// So sánh tương đối ( equainogeCase)

		System.out.println(schoolName.equalsIgnoreCase(courseName));

		// startWith / endWith/ Contain

		System.out.println(schoolName.startsWith("A"));
		System.out.println(schoolName.endsWith("g"));
		System.out.println(schoolName.contains("Auto"));

		// Index: Vị trí của từ trong chuỗi
		schoolName.indexOf(3);
		System.out.println("Vị trí chuỗi =" + schoolName.indexOf(3));

		// Subtring: Tách kí tự/ chuỗi kí tự từ chuỗi cho trước
		System.out.println("Tách chuỗi =" + schoolName.substring(3));
		System.out.println("Tách chuỗi = " + schoolName.substring(3, 9));

		String result = "View 48 of 132 results"; // Lấy ra 48 trong chuỗi

		// split
		String[] results = result.split(" "); // tách chuỗi thành 1 mảng dựa vào 1 kí tự nào đó

		for (String string : results) {

			System.out.println(string);
		}
		System.out.println(results[1]);

		// replace - Thay thế 1 chuỗi / kí tự bằng chuỗi / kí tự khác

		String productPrice = "$1000";

		productPrice = productPrice.replace("$", ""); // Thay thế kí tự bằng 1 kí tự khác
		

		// Sắp xếp nó: Sort Data (Asc/ Desc)
		float productPiceF = Float.parseFloat(productPrice); // convert float sang string

		String.valueOf(productPiceF); 
		
		productPrice = String.valueOf(productPiceF); 
		
		int productPriceI = Integer.parseInt(productPrice); // convert từ int sang string
		
		

//		// split and Substring
//		
//		String text = "Viewing 72 of 1879 results";
//		
//		String[] subString = text.split(" ");
//		
//		for(int i =0; i<subString.length; i++) {
//			
//			System.out.println("Vi tri thu " + i + ":" + subString[i]);
//		}
//		
//		System.out.println(extractNumberFromString(text, 1));
//		System.out.println(extractNumberFromString(text, 3));
//		
//		public static int extractNumberFromString(String text, int number) {
//			
//			String[] subString = text.split(" ");
//			
//			int result = Integer.parseInt(subString[number]); // từ String chuyển sang int
//			
//			return result;
//		}
//
//	}
		
		
		// Upper / Lower Case
		
		String osName = System.getProperty("os.name");
		
		System.out.println(osName);
		// Handle multiple OS: MAC/ windows ( Action - keys - Ctrl / Command)
		
		if(osName.toLowerCase().contains("windows")) {
			
			Keys key = Keys.CONTROL;
		} else {
			
			Keys key = Keys.COMMAND; 
		}
		
		// Multiple browser:UpperCase
		// firefox = FIREFOX
		
//		String driverInstanceName = driver.toString();
		
//		System.out.println(driverInstanceName);
//		
//		if (driverInstanceName.contains("internetexplorer")) {
			// Sleep cứng thêm 5s sau mỗi lần chuyển page
			
		
		
		
		// Trim
		String helloWord = "         "
				+ "Hello World!          ";
		System.out.println(helloWord.trim());
			
		
		// Convert int - string hoặc double - string  
		
		// Dynamic locator
		// Đại diện cho 1 chuỗi: %s
		
		String dynamicButonXpath = "//button[@id='%s']";
		
		System.out.println("Click to Login button = " + dynamicButonXpath.format(dynamicButonXpath, "login"));
		
		}

		

}
