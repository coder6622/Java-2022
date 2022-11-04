package com.sinhvien;

public class MainClass {
  SinhVien sv1 = new SinhVienBus("Duat", 0, 0, 0);

  public static void main(String[] args) {
    SinhVien sv = new SinhVienIT("Long", 1.9f, 1.2f);
    System.out.println("Long: " + sv.tinhDiemTB());

  }

}
