package com.coder6622.asm02.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
  protected List<Account> accounts;

  public Customer() {
    accounts = new ArrayList<Account>();
  }

  public boolean addAccount(Account newAccount) {
    if (isContainAccountNumber(newAccount.getAccountNumber())) {
      System.out.println("Đã tồn tại account number");
      return false;
    }
    accounts.add(newAccount);
    return true;
  }

  /**
   * @return
   *         Tính toán số dư trong tài khoản của khách hàng
   */
  public float sumBalanceOfAccount() {
    float sum = 0;
    for (Account account : accounts) {
      sum += account.getBalance();
    }
    return sum;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  protected boolean isPremium() {

    for (Account account : accounts) {
      if (account.isPremium()) {
        return true;
      }
    }
    return false;
  }

  public boolean isContainAccountNumber(String accountNumber) {
    for (Account account : accounts) {
      if (account.getAccountNumber().equals(accountNumber)) {
        return true;
      }
    }
    return false;
  }

  public Account getAccountByAccountNumber(String accountNumber) {
    for (Account account : accounts) {
      if (account.getAccountNumber().equals(accountNumber)) {
        return account;
      }
    }
    return null;
  }

  public void displayInformation() {
    // %,.3fđ
    System.out.println();
    String format = "%-12s | %-30s | %-20s | %-,29fđ | \n";
    System.out.printf(format, this.getCustomerId(),
        this.getName(),
        this.isPremium() ? "Premium" : "Normal",
        this.sumBalanceOfAccount());
    System.out
        .println("-------------");
    for (Account account : accounts) {
      System.out.print(account);
    }
  }

}
