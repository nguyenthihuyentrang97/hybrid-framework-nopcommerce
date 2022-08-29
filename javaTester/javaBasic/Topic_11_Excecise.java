package javaBasic;

import org.testng.annotations.Test;

public class Topic_11_Excecise {

	int ID;

	String Name;

	int Age;

	int Score;

	public void TC_01_Max() {

		// Cho x = 1 số So sánh số x > B => Gán x = B

		int arr[] = { 2, 7, 8, 6, 9 };

		int x = 0;

		for (int i = 0; i < arr.length; i++) {

			if (x < arr[i]) {

				x = arr[i];
			}

		}
		System.out.println("First number = " + arr[0]);

		System.out.println("Last number = " + arr[arr.length - 1]);

		System.out.println("Max number = " + x);

	}

	public void TC_02_Tong() {

		int x = 0;

		int arr[] = { 2, 7, 6, 8, 9 };

		for (int i = 0; i < arr.length; i++) {

			x = arr[0] + arr[arr.length - 1];

			System.out.println(x);

			break;
		}
	}

	public void TC_03() {

		int arr[] = { 2, 7, 6, 8, 9, 16, 17, 20 };

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] % 2 == 0) {

				System.out.println(arr[i]);
			}
		}
	}

	public void TC_04() {

		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };

		for (int i = 0; i < arr.length; i++) {

			if ((arr[i] > 0) && (arr[i] % 2 != 0)) {

				System.out.println(arr[i]);
			}

		}
	}

	public void TC_05() {

		int arr[] = { 3, -7, 2, 5, 9, -6, 10, 12 };

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] >= 0 && arr[i] <= 10) {

				System.out.println(arr[i]);
			}
		}
	}

	public void TC_06() {

		int arr[] = { 3, 5, 7, 30, 10, 5, 8, 23, 0, -5 };

		int sum = 0;

		int avg = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

		}
		System.out.println("Tổng = " + sum);

		System.out.println("Trung bình cộng = " + (sum / arr.length));

	}

	public Topic_11_Excecise(int ID, String Name, int Age, int Score) {

		this.ID = ID;

		this.Name = Name;

		this.Age = Age;

		this.Score = Score;

	}
	public void display() {
		
		System.out.println("ID" + ID);
		
		System.out.println("Name" + Name);
		
		System.out.println("Age" + Age);
		
		System.out.println("Score" + Score);
		
	}
	public static void main(String[]args) {
		
		Topic_11_Excecise[] point = new Topic_11_Excecise[3];
		
		point[0] = new Topic_11_Excecise(1, "Nguyễn Văn A", 18, 7);
		
		point[1] = new Topic_11_Excecise(1, "Nguyễn Văn B", 18, 7);
		
		point[2] = new Topic_11_Excecise(1, "Nguyễn Văn C", 18, 7);
		
		for (int i = 0; i < point.length; i++) {
			
			point[i].display();
		}
		
	}
}
