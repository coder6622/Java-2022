package com.sinhvien;

public class SinhVienBus extends SinhVien {

  public SinhVienBus(String hoTen) {
    super(hoTen);
  }

  protected float keToan, marketing, banHang;

  public SinhVienBus(String hoTen, float keToan, float marketing, float banHang) {
    super(hoTen);
    this.keToan = keToan;
    this.marketing = marketing;
    this.banHang = banHang;
  }

  @Override
  float tinhDiemTB() {
    return (keToan + marketing + banHang) / 3;
  }

}
