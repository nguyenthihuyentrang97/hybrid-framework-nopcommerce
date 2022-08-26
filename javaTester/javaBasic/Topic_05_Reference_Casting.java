package javaBasic;

public class Topic_05_Reference_Casting {

	public String studentName;
	
	public String getstudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public void showStudentName() {
		System.out.println("studentName : " + studentName);
		
	}
	public static void main(String[] agrs) {
		
		Topic_05_Reference_Casting firstStudent = new Topic_05_Reference_Casting();
		
		Topic_05_Reference_Casting secondStudent = new Topic_05_Reference_Casting();
		
		firstStudent.setStudentName("Nguyen Van Nam");
		
		secondStudent.setStudentName("Le Van Long");
		
		firstStudent.showStudentName();
		
		secondStudent.showStudentName();
		
		//Ép kiểu
		
		firstStudent = secondStudent;
		
		firstStudent.showStudentName();
		
		secondStudent.showStudentName();
		
		secondStudent.setStudentName("Dao Van Giang");
		
		firstStudent.showStudentName();
		
		secondStudent.showStudentName();
	}
}
