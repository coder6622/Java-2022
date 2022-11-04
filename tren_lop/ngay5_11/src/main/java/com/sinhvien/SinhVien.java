package com.sinhvien;

public abstract class SinhVien {
  protected String hoTen;

  public SinhVien(String hoTen) {
    this.hoTen = hoTen;
  }

  abstract float tinhDiemTB();
}
