package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_08_Excecise {

	public void TC_01() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập n = ");

		int n = sc.nextInt();

		for (int i = 0; i <= n; i++) {

			System.out.println(" " + i);
		}

	}

	public void TC_02() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		int a = sc.nextInt();

		System.out.println("Nhập b = ");

		int b = sc.nextInt();

		for (int i = a; i <= b; i++) {

			System.out.println(i);
		}

	}

	public void TC_03() {

		int count = 0;

		for (int i = 1; i <= 10; i++) {

			if (i % 2 == 0) {

				count++;

				System.out.println(i);
			}
		}

		System.out.println(count);

	}


	public void TC_04() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		int a = sc.nextInt();

		System.out.println("Nhập b = ");

		int b = sc.nextInt();
		
		int sum = 0;
		
		for (int i = a; i <= b; i++) {
			
			sum += i;
			
			System.out.println(i);
		}

		System.out.println(sum);
	}
	


	public void TC_05() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập n = ");

		int n = sc.nextInt();
		
		int sum = 0;
		
		for (int i = 0; i <= n; i++) {
			
			if((i%2) != 0) {
				
				sum += i;
			}
			
			System.out.println(i);
		}
		
		System.out.println(sum);
	}
	

	public void TC_06() {
		// Các số có tổng chia hết cho 3 thì chia hết cho 3
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		int a = sc.nextInt();

		System.out.println("Nhập b = ");

		int b = sc.nextInt();
		
		for (int i = a; i <= b; i++) {
			
			if(i%3 == 0) {
				System.out.println(i);
			}
			
		}
	}
		@Test

		public void TC_07() {
			
			int giaithua = 1; // giai thừa của 1 số luôn bằng 1
			
			Scanner sc = new Scanner(System.in);

			System.out.println("Nhập n = ");

			int n = sc.nextInt();
			
			for (int i = 1; i <= n; i++) {
				
				giaithua = giaithua * i;			
			}
			
			System.out.println("giai thừa của " + n + " là " + giaithua);
		}
	}
