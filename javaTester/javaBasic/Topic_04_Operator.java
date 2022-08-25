package javaBasic;

import java.util.Iterator;

public class Topic_04_Operator {

	public static void main(String[] args) {

		// Math ( Toán học)

		int number = 10;

		number += 5; // number = number + 5;

		System.out.println(number);

		// 15/5 = 3
		System.out.println(number / 5);

		// 15 % 7 = 1 dư 1
		System.out.println(number % 7);

		System.out.println(number++);
		// thực hiện in trước
		// ++ = tăng number lên 1

		System.out.println(++number);
		// thực hiện ++ trước tăng number lên 1
		// in ra sauu

		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(i);
		}

		System.out.println(number--);

		// Biểu thức quan hệ

		String address = "Ha Noi";
		
		int number1 = 5; // Phép gán
		
		int number2 = 6;

		if (address == "Ha Noi") { // So sánh bằng

			System.out.println("Address is the same - So sánh bằng");

		}
		

		if (address != "Ho Chi Minh") { // So sánh khác

			System.out.println("Address not the same - So sánh khác");

		}
		
		if (number1 < number2) { // So sánh nhỏ hơn

			System.out.println(" 5 < 6 So sánh nhỏ hơn");

		}
		

		if (number2 > number1) { // So sánh lớn hơn

			System.out.println(" 6 > 5 So sánh lớn hơn");

		}
		
		if (number1 <= number2) { // So sánh < hoặc =

			System.out.println(" 5 < 6 So sánh < hoặc =");

		}
		
		if (number2 >= number1) { // So sanh > hoặc =

			System.out.println(" 6 > 5 So sanh > hoặc =");

		}
		
		// Biểu thức Logic
		
		if(address != "Ho Chi Minh" && address != "Da Nang") { // So sánh và cả 2 giá trị đều đúng
			System.out.println("Address not the same - So sánh và cả 2 giá trị đều đúng");
		}
		
		if(address != "Ha Noi" || address != "Da Nang") { // So sánh hoặc chỉ 1 trong các điều kiện đúng
			System.out.println("Address not the same - So sánh hoặc chỉ 1 trong các điều kiện đúng");
		}
		
		if (!(address == "Ho Chi Minh")) { // So sánh phủ định giá trị

			System.out.println("Address not the same - So sánh phủ định giá trị");

		}
		
		// Biểu thức điều kiện
		
		// Biểu thức tam nguyên ( = ? : )
		boolean status = (address == "Ha Noi") ?true :false;
		System.out.println(status);
	}
}
