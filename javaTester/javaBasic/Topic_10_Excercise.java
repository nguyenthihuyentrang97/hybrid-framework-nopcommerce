package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_Excercise {

	@Test
	public void TC_01() {

		int a;

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập a = ");

		a = sc.nextInt();

		for (int i = a; i <= 12; i++) {
			if (i == 1) {
				System.out.println("Jan");

				break;
			}

			else if (i == 2) {
				System.out.println("February");

				break;

			}

			else if (i == 3) {
				System.out.println("March");

				break;

			} else if (i == 4) {
				System.out.println("April");

				break;

			} else if (i == 5) {
				System.out.println("May");

				break;

			} else if (i == 6) {
				System.out.println("June");

				break;

			} else if (i == 7) {
				System.out.println("July");

				break;

			} else if (i == 8) {
				System.out.println("August");

				break;

			} else if (i == 9) {
				System.out.println("September ");

				break;

			} else if (i == 10) {
				System.out.println("October");

				break;

			} else if (i == 11) {
				System.out.println("November");

				break;

			} else if (i == 12) {
				System.out.println("December");

				break;
			}

		}

	}
}
