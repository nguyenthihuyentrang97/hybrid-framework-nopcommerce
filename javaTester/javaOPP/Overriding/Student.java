package javaOPP.Overriding;

public class Student extends Person {

	@Override
	public void eat() {

		System.out.println("suất cơm 15.000VND");
	}
	
	@Override
	public void sleep() {

		System.out.println("Ngủ 6h/ ngày");
	}
}
