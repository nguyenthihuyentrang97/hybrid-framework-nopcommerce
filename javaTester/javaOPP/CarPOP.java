package javaOPP;

public class CarPOP {

	static String carCompany;

	static String carType;

	static String fuelType;

	static Float mileAge;

	static Double carPrice;

	public static void main(String[] args) {

		carCompany = "Honda";

		carType = "City";

		fuelType = "Petrol";

		mileAge = 200f;

		carPrice = 5000d;

		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Car fuel type = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car Price = " + carPrice);

		carCompany = "Huyndai";

		carType = "City";

		fuelType = "Petrol";

		mileAge = 300f;

		carPrice = 5000d;

		System.out.println("Car company = " + carCompany);
		System.out.println("Car type = " + carType);
		System.out.println("Car fuel type = " + fuelType);
		System.out.println("Car mile Age = " + mileAge);
		System.out.println("Car Price = " + carPrice);
	}
}
