package javaBasic;

public class Topic_12_String {

	public static void main(String[] args) {

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

		String productPice = "$1000";

		productPice = productPice.replace("$", ""); // Thay thế kí tự bằng 1 kí tự khác

		float productPiceF = Float.parseFloat(productPice); // convege String sang float

		String.valueOf(productPiceF); // convege từ float sang String

	}
}