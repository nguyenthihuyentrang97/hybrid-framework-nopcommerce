package javaBasic;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Excecise {

	public void TC_01_Viet_chuong_trinh_nhap_ten_tuoi() {

		Scanner sc = new Scanner(System.in); // Khởi tạo scanner

		String name;

		System.out.print("Nhập tên:");

		name = sc.nextLine(); // Nhập name

		int age;

		System.out.print("Nhập tuổi:");

		age = sc.nextInt(); // Nhập tuổi

		System.out.println("After 15 year, age of " + name + "will be" + (age + 15)); // in ra màn hình tên và tuổi + 15
	}

	public void TC_02_Hoan_doi() {
		int a;

		int b;

		
		Scanner sc = new Scanner(System.in); // Khởi tạo scanner

		System.out.println("Nhập a: ");
		a = sc.nextInt();

		System.out.println("Nhập b: ");

		b = sc.nextInt();

		a = a + b;

		b = a - b;

		a = a - b;

		System.out.println(" Số hoán đổi a = " + a + " Số hoán đổi b = " + b);

	}

	@Test
	public void TC_03() {
		int a;

		int b;

		Scanner sc = new Scanner(System.in); // Khởi tạo scanner
		System.out.println("Nhập a: ");
		a = sc.nextInt();

		System.out.println("Nhập b: ");

		b = sc.nextInt();
		
//		boolean status = (a > b) ?true :false;
//		System.out.println(status);
		
		if (a>b) {
			System.out.println("true");
		} else {
			System.out.println("false");
				
			}
		}
	}

