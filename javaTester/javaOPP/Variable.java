package javaOPP;

public class Variable {

	// Property
	public String Name;

	// Final variable
	final String NAME = "Huyen";
	
	// Constant variable 
	public final static String MY_NAME = "Huyen Trang";
	
	// Getter method
	private String getName() {
		return Name;
	}

	// Setter method
	private void setName(String Name) {
		this.Name = Name;
	}

	public class Employee{
		
		// instance variable
		public String name;
		
		
		// chỉ hiển thị được trong class 
		private double salary;
	}
	
	// Construstor ( hàm khởi tạo)
	public Variable( String newName) {
		// Name được gán cho giá trị mới
		Name = newName;
	}

	public static void main(String[] args) {


	}

}
