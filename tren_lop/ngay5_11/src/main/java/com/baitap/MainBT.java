package com.baitap;

import java.util.Scanner;

public class MainBT {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Product p1 = InputProduct();
    // System.out.println(p1);
    // Product p2 = InputProduct();
    // System.out.println(p2);
    // Product p3 = InputProduct();
    // System.out.println(p3);
    // Product p4 = InputProduct();
    // System.out.println(p4);
    // Product p5 = InputProduct();
    // System.out.println(p5);

    Product p1NoTax = InputProducNoTax();
    System.out.println(p1NoTax);
    // Product p2NoTax = InputProducNoTax();
    // System.out.println(p2NoTax);
    // Product p3NoTax = InputProducNoTax();
    // System.out.println(p3NoTax);

    p1NoTax.select();
    p1NoTax.delete();
    p1NoTax.select();
  }

  public static Product InputProduct() {
    System.out.print("Nhap name: ");
    String name = scanner.nextLine();
    System.out.print("Nhap gia: ");
    double price = scanner.nextDouble();
    scanner.nextLine();
    return new Product(name, price);
  }

  public static Product InputProducNoTax() {
    System.out.print("Nhap name: ");
    String name = scanner.nextLine();
    System.out.print("Nhap gia: ");
    double price = scanner.nextDouble();
    scanner.nextLine();
    return new NoTaxProduct(name, price);
  }
}
