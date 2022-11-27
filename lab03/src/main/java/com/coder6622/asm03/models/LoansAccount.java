package com.coder6622.asm03.models;

import com.coder6622.asm02.models.Account;
import com.coder6622.asm03.models.common.IReportService;
import com.coder6622.asm03.models.common.IWithdraw;
import com.coder6622.utils.Utils;

public class LoansAccount extends Account implements IReportService {

  private double transactionFee;

  private final double LOAN_ACCOUNT_WITHDRAW_FEE = 0.05;
  private final double LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE = 0.01;
  private final double LOAN_ACCOUNT_MAX_BALANCE = 100000000;
  private final double LOAN_ACCOUNT_LIMIT = 50000;

  private void setTransactionFee(double amount) {
    if (this.isPremium()) {
      transactionFee = LOAN_ACCOUNT_WITHDRAW_PREMIUM_FEE * amount;
    } else {
      transactionFee = LOAN_ACCOUNT_WITHDRAW_FEE * amount;

    }
  }

  public double getTransactionFee() {
    return transactionFee;
  }

  public LoansAccount(String accountNumber, double balance) {
    super(accountNumber, balance);
  }

  public LoansAccount() {
  }

  @Override
  public boolean withdraw(double amount) {
    double newBalance = 0.0;
    if (isAccepted(amount)) {
      this.setTransactionFee(amount);
      newBalance = this.getBalance() - amount - transactionFee;
      if (newBalance < LOAN_ACCOUNT_LIMIT) {
        System.out.println("Hạn mức còn lại sau khi rút tiền không được nhỏ hơn " + LOAN_ACCOUNT_LIMIT);
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
    if (amount > LOAN_ACCOUNT_MAX_BALANCE) {
      System.out.println("Hạn mức không được lớn hơn " + LOAN_ACCOUNT_MAX_BALANCE);
      return false;
    }
    return true;
  }

  @Override
  public void log(double amout) {
    System.out.println(Utils.getDivider());
    System.out.printf("%30s%n", "Bien lai giao dich Loans".toUpperCase());
    System.out.printf("NGAY G/D: %28s%n", Utils.getDateTimeNow());
    System.out.printf("ATM ID: %30s%n", "DIGITAL-BANK-ATM 2022");
    System.out.printf("SO TK: %31s%n", this.getAccountNumber());
    System.out.printf("SO TIEN: %29s%n", amout);
    System.out.printf("SO DU: %31s%n", this.getBalance());
    System.out.printf("PHI + VAT: %27s%n", this.getTransactionFee());
    System.out.println(Utils.getDivider());
  }

  @Override
  public String toString() {
    String format = "%-12s | %-30s | %-20s | %-,29fđ |\n";
    return String.format(format, this.accountNumber, "Loans", isPremium() ? "Prenium" : "No Prenium", this.balance);
  }

}
