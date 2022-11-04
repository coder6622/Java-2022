package com.sinhvien;

public class SinhVienIT extends SinhVien {

  public SinhVienIT(String hoTen) {
    super(hoTen);
  }

  protected float diemJava, diemPhp;

  public SinhVienIT(String hoTen, float diemJava, float diemPhp) {
    super(hoTen);
    this.diemJava = diemJava;
    this.diemPhp = diemPhp;
  }

  @Override
  float tinhDiemTB() {
    return (diemJava * 2 + diemPhp) / 3;
  }

}
