package javaOPP;

public class Topic_04_Non_Access_Modifier {

	// Static: Variable / Method
	// Dùng cho tất cả các instance / object
	// Phạm vi toàn bộ system sử dụng nó
	// có thể override được ( gán lại)
	static String browserName = "chrome";

	// final variable
	final String colorCar = "Red";
	
	final static String REGISTER_BUTTON ="";
	
	// Non static
	String severName = "STG";

	public static void main(String[] args) {
	
		// Biến static truy cập trực tiếp trong hàm static
		// Nếu ngoài phạm vi class thì gọi ra theo phương thức ( Tên_class.Tên_biến VD: Topic_04_Non_Access_Modifier.browserName)
		System.out.println(browserName);

		browserName = "firefox";

		// Hàm static truy cập trực tiếp trong hàm static trong cùng 1 class
		// Nếu ngoài phạm vi class thì gọi ra khởi tạo theo phương thức ( Tên_class.Tên_hàm_static VD: Topic_04_Non_Access_Modifier.sendkeyToElemnet)
		// Dùng trong trường hợp khởi tạo các class ( Bài BasePage_II)
		sendkeyToElemnet("Textbox");
		
		// Biến non-static không truy cập trực tiếp trong hàm static => Cần thông qua biến Instance của class
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();

		System.out.println(topic.severName);
		
		// Hàm non-static không truy cập trực tiếp trong hàm static => Cần thông qua biến Instance/ object
		topic.clickToElemnet("Button");
		
		// Final variable không được phép gán lại giá trị
		// Nếu ngoài phạm vi class thì gọi ra theo phương thức ( Tên_class.Tên_biến VD: Topic_04_Non_Access_Modifier.colorCar)
		System.out.println(topic.colorCar);
		
	
	}

	// non-static
	public void clickToElemnet(String elementName) {

		System.out.println(elementName);
	}
	
	// static
	public static void sendkeyToElemnet(String elementName) {

		System.out.println(elementName);
	}
	
	// final
	public final void setCarName() {
		
		
	}
}
