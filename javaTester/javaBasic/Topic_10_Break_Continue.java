package javaBasic;

public class Topic_10_Break_Continue {

	public static void main(String[] args) {
		
		
	for (int i = 0; i < 10; i++) {
		
		// in từ 1 - 9 mà không in 5
		// Loại trừ điều kiện này ra
		// continue chỉ ảnh hưởng đến vòng for đang đứng
		if ( i==5) {
			
			continue;
		}
		
		System.out.println(i);
	}

	}

}
