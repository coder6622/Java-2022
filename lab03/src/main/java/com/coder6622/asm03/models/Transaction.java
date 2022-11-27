package com.coder6622.asm03.models;

import java.util.Random;

public class Transaction {

  private String id;
  private String accountNumber;
  private Double amount;
  private String time;
  private boolean status;

  public Transaction() {
  }

  public Transaction(String accountNumber, Double amount, String time, boolean status) {
    this.id = uuid();
    this.accountNumber = accountNumber;
    this.amount = amount;
    this.time = time;
    this.status = status;
  }

  public String getId() {
    return id;
  }

  // private void setId() {
  // this.id = uuid();
  // }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  private static String uuid() {
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = upper.toLowerCase();
    String digits = "0123456789";
    String alphanum = upper + lower + digits;

    Random random = new Random();
    char[] buf = new char[6];
    char[] symbols = alphanum.toCharArray();

    for (int i = 0; i < buf.length; i++) {
      buf[i] = symbols[random.nextInt(symbols.length)];
    }

    return String.valueOf(buf);
  }

  @Override
  public String toString() {
    String format = "%-12s | %-,29fđ | %-20s | \n";
    return String.format(format, accountNumber, amount, time);
  }
}
