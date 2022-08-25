package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Excecise {
@Test

public void TC_01() {
	int a = 6;
	int b = 2;
	
	System.out.println("Tong = " + ( a + b ));
	System.out.println("Hieu = " + ( a - b ));
	System.out.println("Thuong = " + ( a / b ));
	System.out.println("Tich = " + (a * b ));
}

@Test
public void TC_02() {
	double chieurong = 3.8;
	double chieudai = 7.5;
	
	System.out.println("P =" + (chieudai * chieurong));
}

@Test
public void TC_03() {
	String name ="Automation Testing";
	
	System.out.println("Hello " + name);
}
}
