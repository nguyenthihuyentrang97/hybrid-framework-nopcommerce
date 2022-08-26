package javaBasic;

import org.testng.annotations.Test;
import java.util.Scanner;


public class Topic_05_Excecise {

	@Test
	public void TC_01() {
		
		int n;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhập số: ");
		
		n = sc.nextInt();
		
		if(n%2==0) {
			
			System.out.println("n là số chẵn");
			
		} else {
			
			System.out.println("n là số lẻ");
		}
		
		
	}
}
