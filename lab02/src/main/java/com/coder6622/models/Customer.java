package com.coder6622.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
  List<Account> accounts;

  public Customer() {
    accounts = new ArrayList<Account>();
  }

  public void addAccount(Account newAccount) {
    if (isContainAccountNumber(newAccount.getAccountNumber())) {
      System.out.println("Da ton tai account number");
      return;
    }
    accounts.add(newAccount);
  }

  public float getBalance() {
    float sum = 0;
    for (Account account : accounts) {
      sum += account.getBalance();
    }
    return sum;
  }

  // ! chua viet
  // private List<Account> getAccounts() {
  // return new ArrayList<Account>();
  // }

  private boolean isPremium() {

    for (Account account : accounts) {
      if (account.isPremium()) {
        return true;
      }
    }
    return false;
  }

  private boolean isContainAccountNumber(String accountNumber) {
    for (Account account : accounts) {
      if (account.getAccountNumber() == accountNumber) {
        return true;
      }
    }
    return false;
  }

  public void DisplayInformation() {
    String row1 = String.format(
        "%s \t|\t %s \t|\t %s \t|\t %,.3fđ",
        this.getCustomerId(),
        this.getName(),
        this.isPremium() ? "Premium" : "Normal",
        this.getBalance());
    System.out.println(row1);
  }

}
