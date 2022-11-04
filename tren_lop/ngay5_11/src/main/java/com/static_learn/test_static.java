package com.static_learn;

public class test_static {
  public static void main(String[] args) {
    MyClass o = new MyClass();

    o.x += 300;
    MyClass.x += 500;
    MyClass.method();
    System.out.println(MyClass.x);
  }

}
