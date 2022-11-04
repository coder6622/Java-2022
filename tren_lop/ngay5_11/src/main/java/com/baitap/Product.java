package com.baitap;

import javax.xml.crypto.Data;

public class Product implements DAO {
  private String _name;
  private double _price;

  public Product(String _name, double _price) {
    this._name = _name;
    this._price = _price;
  }

  public String getName() {
    return _name;
  }

  public void setName(String name) {
    this._name = name;
  }

  public double getPrice() {
    return _price;
  }

  public void setPrice(double price) {
    this._price = price;
  }

  double getImportTax() {
    return 0.1 * getPrice();
  }

  @Override
  public String toString() {
    return "Name: " + getName() + "\t" + "Gia: " + getPrice();
  }

  @Override
  public void insert() {
    System.out.println("Them thanh cong");

  }

  @Override
  public void update() {
    System.out.println("Update thanh cong");

  }

  @Override
  public void delete() {

    System.out.println("Xoa thanh cong");
  }

  @Override
  public void select() {
    System.out.println("Select thanh cong");
  }
}
