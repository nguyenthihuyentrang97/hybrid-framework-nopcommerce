package javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;

public class Topic_06_Excecise {

	public void TC_01() {

		int n;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập số: ");

		n = sc.nextInt();

		if (n % 2 == 0) { // Nếu dư là 0 thì là số chẵn, nếu phần dư khác 0 là số lẻ

			System.out.println("n là số chẵn");

		} else {

			System.out.println("n là số lẻ");
		}

	}

	public void TC_02() {

		int a;

		int b;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");
		a = sc.nextInt();

		System.out.println("Nhập b = ");
		b = sc.nextInt();

		if (a >= b) {

			System.out.println(" a lớn hơn hoặc bằng b");

		} else {

			System.out.println(" a nhỏ hơn hoặc bằng b");
		}
	}

	public void TC_03() {

		String Name1;

		String Name2;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập tên 1: ");

		Name1 = sc.nextLine();

		System.out.println("Nhập tên 2: ");

		Name2 = sc.nextLine();

		if (Name1 == Name2) {

			System.out.println("2 người cùng tên");
		} else {

			System.out.println("2 người khác tên");
		}
	}


	public void TC_04() {

		int a;

		int b;

		int c;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		a = sc.nextInt();

		System.out.println("Nhập b = ");

		b = sc.nextInt();

		System.out.println("Nhập c = ");

		c = sc.nextInt();
	
		if ( a > b && a > c) {
			
			System.out.println(a);
			
		} else if (b > a && b > c) {
			
			System.out.println(b);
			
		} else if ( c > a && c > b) {
			
			System.out.println(c);
		}
		
	}
	

	
	public void TC_05() {
		
		int a;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập a = ");
		
		a = sc.nextInt();
		
		if( a >= 10 && a <= 100) {
			 
			System.out.println("a nằm trong [ 10; 100]");
		
		} else {
			
			System.out.println("a không nằm trong [ 10; 100]");
		}
		
		
	}
	

	
	public void TC_06() {
	
	float a;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Nhập điểm = ");
	
	a = sc.nextFloat();

	if ( a == 0 || a < 5) {
		
		System.out.println("Điểm D");
		
	} else if (a >= 5 || a < 7.5) {
		
		System.out.println("Điểm C");
		
	} else if (a >= 7.5 || a < 8.5 ) {
		
		System.out.println("Điểm B");
		
	} else if (a >= 8.5 || a <= 10 ) {
		
		System.out.println("Điểm A");
	} else {
		
		System.out.println("Vui lòng nhập điểm lại!");
	}
}

@Test

public void TC_07() {
	
	int a;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("Nhập a = ");
	
	a = sc.nextInt();
	
	if ( a == 1 || a == 3 || a == 5 || a == 7 || a == 8 || a == 12) {
		
		System.out.println("31");
		
	} else if (a == 2) {
		
		System.out.println("28");
		
	} else if (a == 4 || a == 6 || a == 9 || a == 11) {
		
		System.out.println("30");
		
	}  else {
		
		System.out.println(" Vui lòng nhập lại tháng");
	}
}
}
