package com.coder6622.models;

// import java.util.regex.Pattern;

public class Account {
  private String accountNumber;
  private double balance;

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {

    if (checkAccountNumberValid(accountNumber)) {
      this.accountNumber = accountNumber;
      return;
    }

    System.out.println("Invalid account number");
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  @Override
  public String toString() {
    return String.format("%s |\t %,.3fđ |\t %s", accountNumber, balance, isPremium());
  }

  private boolean isNumberic(String strNum) {
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

  private boolean checkAccountNumberValid(String strNum) {
    if (strNum == null) {
      return false;
    } else if (isNumberic(strNum) && strNum.length() == 6) {
      return true;
    }
    return false;

  }

  public boolean isPremium() {
    return this.balance >= 10000000;
  }
}
