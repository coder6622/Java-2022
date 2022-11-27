package com.coder6622.asm02.models;

import com.coder6622.asm03.models.common.IReportService;
import com.coder6622.asm03.models.common.IWithdraw;
import com.coder6622.utils.Utils;

// import java.util.regex.Pattern;

public class Account implements IWithdraw, IReportService {
  protected String accountNumber;
  protected double balance;

  public Account() {
  }

  public Account(String accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

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
    } else if (Utils.checkStringIsNumberic(strNum) && strNum.length() == lengthAccountNumber) {
      return true;
    }
    return false;

  }

  public boolean isPremium() {
    return this.balance >= 10000000;
  }

  @Override
  public boolean withdraw(double amount) {
    return false;
  }

  @Override
  public boolean isAccepted(double amount) {
    return false;
  }

  @Override
  public void log(double amout) {
    System.out.println(Utils.getDivider());
    System.out.printf("NGAY G/D: %28s%n", Utils.getDateTimeNow());
    System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
    System.out.printf("SO TK: %31s%n", this.getAccountNumber());

  }

}
