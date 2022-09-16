package javaOPP;

public class ClassAndObject_Excercise {

	private int MaSV;

	private String HoTen;

	private float DiemLyThuyet, DiemThucHanh;

	private int getMaSV() {
		return MaSV;
	}

	private void setMaSV(int maSV) {
		this.MaSV = maSV;
	}

	private String getHoTen() {
		return HoTen;
	}

	private void setHoTen(String hoTen) {
		this.HoTen = hoTen;
	}

	private float getDiemLyThuyet() {
		return DiemLyThuyet;
	}

	private void setDiemLyThuyet(float diemLyThuyet) {
		this.DiemLyThuyet = diemLyThuyet;
	}

	private float getDiemThucHanh() {
		return DiemThucHanh;
	}

	private void setDiemThucHanh(float diemThucHanh) {
		this.DiemThucHanh = diemThucHanh;
	}

	private float Diemtrungbinh() {

		return (DiemLyThuyet + DiemThucHanh * 2) / 3;
	}

	private void showInfo() {

		System.out.println("Nhập MaSV = " + getMaSV());

		System.out.println("Nhập HoTen = " + getHoTen());

		System.out.println("Nhập diemLyThuyet = " + getDiemLyThuyet());

		System.out.println("Nhập diemThucHanh = " + getDiemThucHanh());

		System.out.println("Điểm trung bình = " + Diemtrungbinh());
	}

	public static void main(String[] args) {

		ClassAndObject_Excercise sv1 = new ClassAndObject_Excercise();
		sv1.setMaSV(1);
		sv1.setHoTen("A");
		sv1.setDiemLyThuyet(4);
		sv1.setDiemThucHanh(7);
		sv1.showInfo();


	}

}
