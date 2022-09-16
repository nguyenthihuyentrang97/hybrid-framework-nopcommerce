package javaOPP;

import java.util.Scanner;

public class ClassAndObject_Excercise {

	static int MaSV;

	static String HoTen;

	static float DiemLyThuyet, DiemThucHanh;

	// Khởi tạo giá trị
	@SuppressWarnings("static-access")
	public ClassAndObject_Excercise(int MaSV, String HoTen, float DiemLyThuyet, float DiemThucHanh) {

		this.MaSV = MaSV;
		this.HoTen = HoTen;
		this.DiemLyThuyet = DiemLyThuyet;
		this.DiemThucHanh = DiemThucHanh;
	}

	// Getter / setter
	protected int getMaSV() {
		return MaSV;
	}

	protected void setMaSV(int maSV) {
		MaSV = maSV;
	}

	protected String getHoTen() {
		return HoTen;
	}

	protected void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	protected float getDiemLyThuyet() {
		return DiemLyThuyet;
	}

	protected void setDiemLyThuyet(float diemLyThuyet) {
		DiemLyThuyet = diemLyThuyet;
	}

	protected float getDiemThucHanh() {
		return DiemThucHanh;
	}

	protected void setDiemThucHanh(float diemThucHanh) {
		DiemThucHanh = diemThucHanh;
	}

	public void Diemtrungbinh() {

		float DiemTrungBinh;

		DiemTrungBinh = (DiemLyThuyet + DiemThucHanh * 2) / 3;

		System.out.println("Diem trung binh = " + DiemTrungBinh);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập MaSV = ");

		MaSV = sc.nextInt();

		System.out.println("Nhập HoTen = ");

		HoTen = sc.next();

		System.out.println("Nhập diemLyThuyet = ");

		DiemLyThuyet = sc.nextFloat();

		System.out.println("Nhập diemThucHanh = ");

		DiemThucHanh = sc.nextFloat();

		ClassAndObject_Excercise sv1 = new ClassAndObject_Excercise(1, "Nguyen Van A", 7f, 5.6f);

		sv1.Diemtrungbinh();

		ClassAndObject_Excercise sv2 = new ClassAndObject_Excercise(2, "Nguyen Thi B", 5.5f, 9);

		sv2.Diemtrungbinh();

	}

}
