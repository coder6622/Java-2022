package com.coder6622.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
  List<Account> accounts;

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
      if (account.getAccountNumber().equals(accountNumber)) {
        return true;
      }
    }
    return false;
  }

  public void displayInformation() {
    String row1 = String.format(
        "%s \t|\t %s \t|\t %s \t|\t %,.3fđ",
        this.getCustomerId(),
        this.getName(),
        this.isPremium() ? "Premium" : "Normal",
        this.sumBalanceOfAccount());
    System.out.println(row1);
    for (Account account : accounts) {
      System.out.println(account);

    }
  }

}
