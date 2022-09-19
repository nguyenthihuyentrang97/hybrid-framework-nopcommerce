package javaOPP;

public class Topic_04_Non_Access_Modifier {

	// Static: Variable / Method
	// Dùng cho tất cả các instance / object
	// Phạm vi toàn bộ system sử dụng nó
	// có thể override được ( gán lại)

	static String browserName = "chrome";

	// Non static

	String severName = "STG";

	public static void main(String[] args) {

		// Biến static truy cập trực tiếp trong hàm static
		// Nếu ngoài phạm vi class thì gọi ra theo phương thức ( Tên_class.Tên_biến VD: Topic_04_Non_Access_Modifier.browserName)

		System.out.println(browserName);

		browserName = "firefox";

		// Hàm static truy cập trực tiếp trong hàm static trong cùng 1 class
		// Nếu ngoài phạm vi class thì gọi ra theo phương thức ( Tên_class.Tên_hàm_static VD: Topic_04_Non_Access_Modifier.sendkeyToElemnet)
		// Dùng trong trường hợp khởi tạo các class ( Bài BasePage_II)
		
		sendkeyToElemnet("Textbox");
		
		// Biến non-static không truy cập trực tiếp trong hàm static => Cần thông qua biến Instance của class

		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();

		System.out.println(topic.severName);
		
		// Hàm non-static không truy cập trực tiếp trong hàm static => Cần thông qua biến Instance/ object
		
		topic.clickToElemnet("Button");
	}

	// non-static
	public void clickToElemnet(String elementName) {

		System.out.println(elementName);
	}
	
	// static
	public static void sendkeyToElemnet(String elementName) {

		System.out.println(elementName);
	}
}
