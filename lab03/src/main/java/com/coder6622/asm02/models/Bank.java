package com.coder6622.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {

  private final String id;
  private final List<Customer> customers;

  public String getId() {
    return id;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public Bank() {
    id = String.valueOf(UUID.randomUUID());
    customers = new ArrayList<Customer>();
  }

  public boolean addCustomer(Customer newCustomer) {
    if (isCustomerExisted(newCustomer)) {
      System.out.println("Khách hàng đã tồn tại!!!");
      return false;
    }
    customers.add(newCustomer);
    System.out.println("Thêm khách hàng thành công!!!");
    return true;
  }

  public boolean isCustomerExisted(Customer customerCheck) {
    for (Customer customer : customers) {
      if (customer.getCustomerId().equals(customerCheck.getCustomerId())) {
        return true;
      }
    }
    return false;
  }

  public boolean isCustomerExisted(String cccd) {
    for (Customer customer : customers) {
      if (customer.getCustomerId().equals(cccd)) {
        return true;
      }
    }
    return false;
  }

  public Customer getCustomerById(String cccd) {
    for (Customer customer : customers) {
      if (customer.getCustomerId().equals(cccd)) {
        return customer;
      }
    }
    return null;
  }

  public void displayInformation() {
    for (Customer customer : customers) {
      customer.displayInformation();
    }
  }

  public List<Customer> getCustomerByName(String name) {

    List<Customer> results = new ArrayList<Customer>();
    for (Customer customer : customers) {
      if (customer.getName().contains(name)) {
        results.add(customer);
      }
    }
    return results;
  }
}
