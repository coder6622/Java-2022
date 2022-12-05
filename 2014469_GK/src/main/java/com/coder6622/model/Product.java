/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coder6622.model;

import javax.crypto.MacSpi;

/**
 *
 * @author coder6622
 */
public class Product {

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    private String maSP;
    private String tenSP;
    private String dvt;
    private int donGia;
    private String nhaCungCap;

    public Product(String maSP, String tenSP, String dvt, int donGia, String nhaCungCap) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.dvt = dvt;
        this.donGia = donGia;
        this.nhaCungCap = nhaCungCap;
    }

    public Product(String tenSP, String dvt, int donGia, String nhaCungCap) {
        this.tenSP = tenSP;
        this.dvt = dvt;
        this.donGia = donGia;
        this.nhaCungCap = nhaCungCap;
    }

}
