package com.coder6622.models;

import com.coder6622.utils.FunctionsCommon;

// import java.util.regex.Pattern;

public class Account {
  private String accountNumber;
  private double balance;

  public String getAccountNumber() {
    return accountNumber;
  }

  public boolean setAccountNumber(String accountNumber) {
    if (checkAccountNumberValid(accountNumber)) {
      this.accountNumber = accountNumber;
      return true;
    }
    System.out.println("Invalid account number");
    return false;
  }

  public double getBalance() {
    return balance;
  }

  public boolean setBalance(double balance) {
    if (balance >= 50000) {
      this.balance = balance;
      return true;
    } else {
      System.out.println("Số dư phải lớn hơn 50_000 VNĐ");
      return false;
    }
  }

  @Override
  public String toString() {
    String format = "%-12s | %-,29fđ | %-20s | \n";
    return String.format(format, accountNumber, balance, isPremium() ? "Prenium" : "No Prenium");
  }

  private boolean checkAccountNumberValid(String strNum) {
    int lengthAccountNumber = 6;
    if (strNum == null) {
      return false;
    } else if (FunctionsCommon.checkStringIsNumberic(strNum) && strNum.length() == lengthAccountNumber) {
      return true;
    }
    return false;

  }

  public boolean isPremium() {
    return this.balance >= 10000000;
  }
}
