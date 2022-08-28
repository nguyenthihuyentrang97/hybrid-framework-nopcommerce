package javaBasic;

public class Topic_09_While_Do_While {

	public static void main(String[] args) {

		int i = 0;

		for (i = 0; i < 5; i++) {

			System.out.println("For: " + i);

		}

		while (i < 5) {

			System.out.println("While: " + i);

			i++;
		}

		// do cho phep chạy ít nhất 1 lần rồi mới ktra điều kiện
		do {
			System.out.println("Do - While: " + i);

			i++;

		} while (i < 5);
	}
}
