package com.coder6622.asm03.models;

import com.coder6622.asm02.models.Account;
import com.coder6622.utils.Utils;

public class SavingAccount extends Account {

  private final int SAVINGS_ACCOUNT_MAX_WITHDRAW = 5000000;

  private final int SAVINGS_ACCOUNT_MINIMUM_WITHDRAW = 50000;

  private final int SAVINGS_ACCOUNT_LIMIT_WITHDRAW = 50000;

  private double transactionFee;

  public SavingAccount() {
  }

  private void setTransactionFee(double amount) {
    transactionFee = 0;
  }

  public double getTransactionFee() {
    return transactionFee;
  }

  public SavingAccount(String accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public boolean withdraw(double amount) {
    double newBalance = 0.0;
    if (isAccepted(amount)) {
      this.setTransactionFee(amount);
      newBalance = this.getBalance() - amount - transactionFee;
      if (newBalance < SAVINGS_ACCOUNT_LIMIT_WITHDRAW) {
        System.out.println("Hạn mức còn lại sau khi rút tiền không được nhỏ hơn " + SAVINGS_ACCOUNT_LIMIT_WITHDRAW);
        return false;
      } else {
        this.setBalance(newBalance);
        log(amount);
        return true;
      }
    }
    return false;

  }

  @Override
  public boolean isAccepted(double amount) {
    if (amount < SAVINGS_ACCOUNT_MINIMUM_WITHDRAW) {
      System.out.println("Hạn mức không được nhỏ hơn " + SAVINGS_ACCOUNT_MINIMUM_WITHDRAW);
      return false;
    } else if (amount > SAVINGS_ACCOUNT_MAX_WITHDRAW && !this.isPremium()) {
      System.out.println("Tài khoản thường không được rút hơn " + SAVINGS_ACCOUNT_MAX_WITHDRAW);
      return false;
    } else if (!Utils.kiemTraBoiSoCua10(amount)) {
      System.out.println("Sô tiền rút phải là bội số của 10");
      return false;
    }
    System.out.println("Có lỗi xảy ra");
    return true;
  }

  @Override
  public void log(double amout) {
    System.out.println(Utils.getDivider());
    System.out.printf("%30s%n", "Bien lai giao dich Savings".toUpperCase());
    super.log(amout);
    System.out.printf("SO TIEN: %29s%n", Utils.formatMoney(amout));
    System.out.printf("SO DU: %31s%n", Utils.formatMoney(this.getBalance()));
    System.out.printf("PHI + VAT: %27s%n", Utils.formatMoney(this.getTransactionFee()));
    System.out.println(Utils.getDivider());
  }

  @Override
  public String toString() {
    String format = "%-12s | %-30s | %-20s | %-,29fđ | \n";
    return String.format(format, this.accountNumber, "Saving", isPremium() ? "Prenium" : "No Prenium",
        this.balance);

  }
}
