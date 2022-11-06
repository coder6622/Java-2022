package com.coder6622.utils;

public class FunctionsCommon {
  public static boolean checkStringIsNumberic(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      Double.parseDouble(strNum);
    } catch (NumberFormatException ex) {
      return false;
    }
    return true;
  }

}
