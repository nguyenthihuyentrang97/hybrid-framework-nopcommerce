package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_Excecise {

	public static void TC_01() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập n = ");

		int n = sc.nextInt();

		while (n < 100) {

			if (n % 2 == 0) {

				System.out.println(n);

			}
			n++;
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

		while (a < b) {

			if (a % 5 == 0 && a % 3 == 0) {

			}

			a++;

			System.out.println(a);

		}

	}

	public void TC_03() {

		int n;

		int sum = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập n = ");

		n = sc.nextInt();

		while (n > 0) {

			if (n % 2 != 0) {

				System.out.println(n);

				sum += n;

				// sum = sum + n;
			}

			n--;

		}
		System.out.println(sum);

	}

	public void TC_04() {

		int a;

		int b;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		a = sc.nextInt();

		System.out.println("Nhập b = ");

		b = sc.nextInt();

		while (a < b) {

			if (a % 3 == 0) {

				System.out.println(a);
			}
			a++;
		}
	}

	public void TC_05() {

		int n;

		int giaithua = 1;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập n = ");

		n = sc.nextInt();

		while (n > 0) {

			giaithua = giaithua * n;

			n--;

		}
		System.out.println(giaithua);
	}

	@Test
	public void TC_06() {
// Tính tổng 1-10 của số chẵn

		int n = 1;

		int sum = 0;

		while (n <= 10) {

			if (n % 2 == 0) {

				sum += n;
			}
			n++;

		}
		System.out.println(sum);

	}
}
