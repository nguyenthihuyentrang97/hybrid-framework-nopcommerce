package javaBasic;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Topic_08_For_ForEach {
	WebDriver driver;

	@Test

	public void TC_01_for() {

		// Vế 1: Biến tạm dùng để tăng giá trị lên sau mỗi lần duyệt
		// Dùng để so sánh với tổng giá trị
		// Vế 2: So sánh với tổng
		// Vế 3: Tăng lên 1 đơn vị sau khi chạy vào thân vòng for

		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}

		System.out.println("=================");

		// Có thể kết hợp với if

		String[] nameCity = { "Hà Nội", "Hải Phòng", "Đà Nẵng", "Hồ Chí Minh" };

		for (int i = 0; i < nameCity.length; i++) {

			if (nameCity[i] == "Đà Nẵng") {

				System.out.println("Action!");

				break;
			}
		}

		System.out.println("=================");

	}

@Test
	
	public void TC_02_for_each() {
	
	String[] nameCity = {"Hà Nội", "Hải Phòng", "Đà Nẵng", "Hồ Chí Minh"};
	
	// Dùng để chạy qua tất cả element
			for (String city : nameCity) {
				
				System.out.println(city);
			}
			
			System.out.println("================");
			
			List<String> cityAddress = new ArrayList<String>();
			
			// Compile ( coding)
			
			cityAddress.add("Hà Nam");
			
			cityAddress.add("Hưng Yên");
			
			System.out.println(cityAddress.size());
			
			// Runtime(Runing)
			
			for (String city : nameCity) {
				
				cityAddress.add(city);
				
			}
			
			System.out.println(cityAddress.size());

			
			List<WebElement> links = driver.findElements(By.id("//a"));
			
			// xử lý dữ liệu: get ra text/ value/ css/ attribute 
			for (WebElement link : links) {
				// Lưu ý dùng hàm click để chuyển page / refresh/ thì sẽ không tồn tại elemnet => Fail ( StaleElementException)
				link.getText();
			}
			
			
}

}
