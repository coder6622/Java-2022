package com.coder6622.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {
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

  public static String getDivider() {
    return "+-----------------------------+-----------------------------+-----------------------------|";
  }

  public static void getTitle() {

  }

  public static String getDateTimeNow() {
    return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
  }

  public static boolean kiemTraBoiSoCua10(double amount) {
    return (amount / 1000) % 10 == 0;
  }

  public static String formatMoney(double money) {
    new String();
    return String.format("%,.3fđ", money);
  }
}
