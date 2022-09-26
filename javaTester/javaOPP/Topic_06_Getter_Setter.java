package javaOPP;

import org.jsoup.select.Evaluator.IsEmpty;

public class Topic_06_Getter_Setter {

	private String personName;
	
	private int personAge;
	
	private int personPhone;
	
	private float personBankAccountAmount;

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		
		if (personName == null || personName.isEmpty() || personName.isBlank()) {
			
			throw new IllegalArgumentException("Tên nhập vào không được bỏ trống");
			
		} else {
			
			this.personName = personName;
		}
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		
		if (personAge < 0 && personAge >= 150 ) {
			
			throw new IllegalArgumentException("Tuổi không hợp lệ");
		} else {

			this.personAge = personAge;
			
		}
		
	}

	public int getPersonPhone() {
		return personPhone;
	}

	public void setPersonPhone(int personPhone) {
		
		if (!String.valueOf(personPhone).startsWith("0")) {
			
			throw new IllegalArgumentException("Số điện thoại phải bắt đầu bằng: 09 - 03- 012- 016- 018- 019");

		} else if (personPhone < 10 || personPhone > 11) {
			
			throw new IllegalArgumentException("Số điện thoại phải từ 10-11 số.");

		} else {
			
			this.personPhone = personPhone;
		}
		
	}

	public float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}

	public void setPersonBankAccountAmount(float personBankAccountAmount) {
		
		if (personBankAccountAmount < 0) {
			
			throw new IllegalArgumentException("Số tiền không hợp lệ");
			
		} else {
			
			this.personBankAccountAmount = personBankAccountAmount;

		}
	}
	
	
}
