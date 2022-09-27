package javaOPP.Overriding;

public class Employee extends Person{

	@Override
	public void eat() {

		System.out.println("suất cơm 45.000VND");
	}
	
	@Override
	public void sleep() {

		System.out.println("Ngủ 12h/ ngày");
	}
}
