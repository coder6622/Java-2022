package com.baitap;

public class NoTaxProduct extends Product {

  public NoTaxProduct(String _name, double _price) {
    super(_name, _price);

  }

  double getImportTax() {
    return 0;
  }

}
