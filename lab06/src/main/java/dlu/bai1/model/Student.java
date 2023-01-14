/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dlu.bai1.model;

/**
 *
 * @author coder6622
 */
public class Student {

    private String maSV, hoTen, email, soDT, diaChi;
    private int gioiTinh;

    public Student() {
    }

    public Student(String maSV, String hoTen, String email, String soDT, String diaChi, int gioiTinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
    }
    
}
