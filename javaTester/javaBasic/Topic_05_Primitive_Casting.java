package javaBasic;

public class Topic_05_Primitive_Casting {
	
	// Kiểu dữ liệu nguyên thủy(byte/short/int/long/float/double)
	
	// Ép kiểu ngầm định ( Implicit) nhỏ -> lớn (byte -> short -> int -> long -> float -> double) => không làm mất giá trị dữ liệu
	// Ép kiểu tường minh (Explicit) lớn -> nhỏ (double -> float -> long -> int -> short -> byte) => có thể làm mất giá trị dữ liệu
	
	public static void main (String[] args) {
	
		// Ép kiểu ngầm định 
		
//	byte bNumber = 126;
//	
//	System.out.println(bNumber);
//	
//	short sNumber = bNumber; 
//	
//	System.out.println(sNumber);
//	
//	int iNumber = sNumber;
//	
//	System.out.println(iNumber);
//	
//	long lNumber = iNumber;
//	
//	System.out.println(lNumber);
//	
//	float fNumber = lNumber;
//	
//	System.out.println(fNumber);
//	
//	double dNumber = fNumber;
//	
//	System.out.println(dNumber);
	
	// Ép kiểu tường minh
	
	double dNumber = 65432176234267834d;
	
	System.out.println(dNumber);
	
	float fNumber = (float) dNumber;
	
	System.out.println(fNumber);
	
	long lNumber = (long) fNumber;
	
	System.out.println(lNumber);
	
	int iNumber = (int) lNumber;
	
	System.out.println(iNumber);
	
	short sNumber = (short) iNumber;
	
	System.out.println(sNumber);
	
	byte bNumber = (byte) sNumber;
}
}