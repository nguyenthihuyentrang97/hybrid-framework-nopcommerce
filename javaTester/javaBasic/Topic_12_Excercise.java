package javaBasic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_12_Excercise {



	public void TC_01() {

		String auto = "Automation FC 2022";

		char[] autoArray = auto.toCharArray(); // Tách thành mảng string

		int countUp = 0;
		
		int countLow = 0;
		
		int countNumber = 0;

		for (char character : autoArray) { // Duyệt từng kí tự trong mảng

			System.out.println(character);

			if (character <= 'Z' && character >= 'A') { // Điều kiện kiểm tra xem có phải chữ in hoa không

				countUp++;
				
				
			}

			else if (character <= 'z' && character >= 'a') { // Điều kiện kiểm tra xem có phải chữ thường không

				countLow++;

				
			}

			else if (character <= '9' && character >= '0') { // Điều kiện kiểm tra xem bao nhiêu kí tự
				
				countNumber++;

				
			}

		}
		System.out.println(" Sum of uppercase = " + countUp);

		System.out.println(" Sum of lowercase = " + countLow);
		
		System.out.println(" Sum of character = " + countNumber);
	}

	

	public void TC_02() {
		
		String auto = "Automation Testing 345 Tutorials Online 789";
		
		auto = auto.toLowerCase(); // chuỗi thành chữ thường
		
		char[] autoArray = auto.toCharArray();
		
		int counta = 0;
		
		for (char character : autoArray) {
			
			if(character == 'a') {
				
				counta++;
			}
			
		}
		System.out.println(" số tự tự a = " + counta);
		
		//================
		
		auto = "Automation Testing 345 Tutorials Online 789";
		
		auto.contains("Testing"); // Kiểm tra có chứa kí tự điều kiện không
		
		System.out.println(auto.contains("Testing"));

		//================
		
		auto.startsWith("Auto");
		
		System.out.println(auto.startsWith("Auto")); // Kiểm tra bắt đầu bằng kí tự
		
		//================
		
		auto.endsWith("Online");// Kiểm tra kết thúc bằng kí tự
		
		System.out.println(auto.endsWith("Online"));
		
		//================
		
		auto.indexOf("Tutorials");
		
		System.out.println(auto.indexOf("Tutorials"));
		
		//================
		
		auto.replace("Online", "Offline");
		
		System.out.println(auto.replace("Online", "Offline"));
		
		
		//================
		
		int countNumber = 0;
		
		auto = "Automation Testing 345 Tutorials Online 789";
		
		char[] characterArray = auto.toCharArray();

		for (char character : characterArray) {
			
			if (character <= '9' && character >= '0') {
				
				countNumber++;
				
			}
		} 
		System.out.println(countNumber);
	}
	@Test

	public void TC_03() {
		
		// Đảo ngược chuỗi
		
		Scanner sc = new Scanner(System.in);
		
		String auto = sc.nextLine();
		
		char[] autoArray = auto.toCharArray();
		
		for (int i = autoArray.length - 1; i >= 0; i--) {
			
			System.out.println(autoArray[i]);
		}
		
		
		
	}
}
