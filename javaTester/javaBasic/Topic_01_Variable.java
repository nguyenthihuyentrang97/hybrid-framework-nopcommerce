package javaBasic;

public class Topic_01_Variable {
	
	
	public Topic_01_Variable() { // Hàm khởi tạo có cùng tên với tên class ( không phải kiểu trả về, không có void, int, class chỉ có pulic + tên giống tên class)
		
		
	}

	static int studentNumber; // Trong 1 hàm static nếu muốn sử dụng biến bên ngoài thì phải dùng static - Biến stacic(biến class)

	static boolean statusValue;

	static final String BROWSER_NAME = "Chrome";// constants - hằng số // Không cho phép gán giá trị khác

	String StudentName = "Automation";

	String homePageUrl = ""; // Biến toàn cục(instance): Sử dụng được tất cả hàm hoặc khối lệnh

	public static void main(String[] args) {

		String HomePage = ""; // Biến cục bộ ( local): Sử dụng trong phạm vi của Testcase/ Hàm
		
		Topic_01_Variable topic = new Topic_01_Variable(); // new 1 đối tượng
		
		System.out.println(topic.StudentName); // truy cập thông qua "topic" thì sẽ in được hàm không có giá trị mặc định, chưa được khởi tạo ( String StudentName = "Automation"; ) 
		
		System.out.println(Topic_01_Variable.BROWSER_NAME);
		
		
//		int studentPrice;
//		
//		System.out.println(studentPrice); => Báo lỗi vì giá trị biến cục bộ không có giá trị mặc định, chưa được khởi tạo
		
		int studentPrice = 5; // Khởi tạo = 5 thì mới có thể dùng được
		
		System.out.println(studentPrice); 
		

		// Khối lệnh
		if (3 < 5) {
			String homePageTitle = ""; // Biến cục bộ

			System.out.println(homePageTitle);
			
			
		}

	}
	
	public void TC_01() {
		System.out.println(homePageUrl); // Biến toàn cục
	}
	

// Hàm Getter - Hàm để lấy dữ liệu (getCurrentTitle/ getTitle/ getText/ getCssValue/ getSize/ getLocation/getPosition,..)
	public String getStudentName() {

		return this.StudentName;

	}

// Hàm Setter - Hàm để set dữ liệu (click/senkey/clear/select/back/forward/refresh/get/..)
	public void setStudentName(String stdName) {

		this.StudentName = stdName;

	}
}
