package com.coder6622.asm03.models;

import java.util.ArrayList;
import java.util.List;

import com.coder6622.asm02.models.Customer;

public class TransactionCustomer {

  private Customer customer;
  private final List<Transaction> transactions;

  public TransactionCustomer() {
    transactions = new ArrayList<Transaction>();
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public TransactionCustomer(Customer customer) {
    this.customer = customer;
    transactions = new ArrayList<Transaction>();
  }

  public boolean addTransaction(Transaction newTransaction) {
    if (!isContainTransaction(newTransaction.getId())) {
      transactions.add(newTransaction);
      return true;
    }
    return false;
  }

  private boolean isContainTransaction(String id) {
    for (Transaction transaction : transactions) {
      if (transaction.getId().equals(id)) {
        return true;
      }
    }
    return false;
  }

  public void displayInformation() {
    customer.displayInformation();
    System.out.println("-------");
    for (Transaction transaction : transactions) {
      System.out.print(transaction);
    }
  }

}
