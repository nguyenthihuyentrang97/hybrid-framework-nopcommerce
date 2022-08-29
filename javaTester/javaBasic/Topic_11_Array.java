package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Topic_11_Array {

	String name;
	
	int age;
	
	public Topic_11_Array(String name, int age) {
		this.name = name;
		
		this.age = age;
		
	}
	
	public void display() {
		
		System.out.println("Name: " + name);
		
		System.out.println("Age: " + age);
	}
	
	// Mảng object
	public static void main1(String[] args) {
		
		Topic_11_Array[] students = new Topic_11_Array[3];
		
		students[0] = new Topic_11_Array("Tuan", 24);
		
		students[1] = new Topic_11_Array("Cuong", 25);
		
		students[2] = new Topic_11_Array("Trang", 24);
		
		for(int i = 0; i< students.length; i++) {
			
			students[i].display();
		}
	}
	
	public static void main(String[] args) {
		// Mảng: Tập hợp các phần tử có cùng kiểu dữ liệu

//		int number[] = { 12,7,5,51,15};
//		
//		int []student = {12,7,5,51,15};
//		
		// Lấy ra phần tử đầu tiên
//		System.out.println(student[0]);
//		
//		System.out.println(student[1]);
//		
		// Define cố định bao nhiêu phần tử khi viết code ( compile)
		// Cố định các phần tử
		String studentName[] = { "Trường", "Ngọc", "Trang" };

		String stdNewName[] = studentName.clone(); // clone 1 mảng lấy tất cả giá trị của mảng cũ

		// Gán đè
		studentName[0] = "Hoa";
//		
//		int b[] = new int [5];
//		b[0] = 10;

		// Duyệt qua tất cả phần tử của mảng
		for (int i = 0; i < studentName.length; i++) {

			System.out.println(studentName[i]);

			if (studentName[i].equals("Trường")) { // Nếu so sánh với String thì dùng equal

				System.out.println("Click vào");

			}

		}

		// không kết hợp với điều kiện
		for (String std : studentName) {

			if (std.equals("Trường")) { // Nếu so sánh với String thì dùng equal

				System.out.println("Click vào");

			}

		}
		// Khi chạy code muốn add thêm giá trị
		ArrayList<String> stdName = new ArrayList<String>();

		for (String std : studentName) {

			stdName.add(std);
		}

		// Convege mảng qua list array
		List<String> names = Arrays.asList("Tom", "Jenny", "Donal");

		for (String name : names) {

			System.out.println("Name: " + name);

		}

		String std_Name = Arrays.toString(studentName); // Chuyển mảng thành chuỗi string
	}

	


}
