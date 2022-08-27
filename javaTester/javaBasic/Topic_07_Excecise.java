package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Excecise {

	public void TC_01() {

		int a;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		a = sc.nextInt();

		switch (a) {

		case 1:

			System.out.println("One");
			break;

		case 2:

			System.out.println("Two");
			break;

		case 3:

			System.out.println("Three");
			break;

		case 4:

			System.out.println("Four");
			break;

		case 5:

			System.out.println("Five");
			break;

		case 6:

			System.out.println("Six");
			break;

		case 7:

			System.out.println("Seven");
			break;

		case 8:

			System.out.println("Eight");
			break;

		case 9:

			System.out.println("Nine");
			break;

		case 10:

			System.out.println("Then");

			break;

		}
	}

	@Test

	public void TC_02() {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		
		int b = sc.nextInt();
		
		String ketQua = sc.next();

		switch (ketQua) {

		case "+":

			System.out.println("Tổng: " + (a + b));

			break;
			
		case "-":

			System.out.println("Hiệu: " + (a - b));

			break;
			
		case "*":

			System.out.println("Tích: " + (a * b));

			break;
			
		case "/":

			System.out.println("Thương: " + (a / b));

			break;
			
		case "%":

			System.out.println("Chia lấy dư: " + (a % b));

			break;

		}
	}
}
