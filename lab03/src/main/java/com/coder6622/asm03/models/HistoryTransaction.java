package com.coder6622.asm03.models;

import java.util.ArrayList;
import java.util.List;

import com.coder6622.asm02.models.Customer;
import com.coder6622.utils.Utils;

public class HistoryTransaction {
  private final List<TransactionCustomer> transactionTests;

  public HistoryTransaction() {
    transactionTests = new ArrayList<TransactionCustomer>();
  }

  public boolean isCustomerExisted(Customer customerCheck) {
    for (TransactionCustomer transactionTest : transactionTests) {
      if (transactionTest.getCustomer().getCustomerId().equals(customerCheck.getCustomerId())) {
        return true;
      }
    }
    return false;
  }

  public TransactionCustomer addTransactionTest(Customer customer) {
    if (!isCustomerExisted(customer)) {
      TransactionCustomer newTransactionTest = new TransactionCustomer(customer);
      transactionTests.add(newTransactionTest);
      return newTransactionTest;
    }
    return null;
  }

  public TransactionCustomer getTransactionTestByCustoer(Customer customer) {
    for (TransactionCustomer transactionTest : transactionTests) {
      if (transactionTest.getCustomer().getCustomerId().equals(customer.getCustomerId())) {
        return transactionTest;
      }
    }
    return addTransactionTest(customer);
  }

  public void displayInformation() {
    System.out.println("Lich su giao dich".toUpperCase());
    System.out.println(Utils.getDivider());
    for (TransactionCustomer transactionTest : transactionTests) {
      transactionTest.displayInformation();
    }
    System.out.println(Utils.getDivider());
  }
}
