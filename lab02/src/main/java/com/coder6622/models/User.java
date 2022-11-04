package com.coder6622.models;

public class User {
  private String customerId;
  private String name;

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    if (checkCustomerIdValid(customerId)) {
      this.customerId = customerId;
      return;
    }
    System.out.println("Customer id khong hop le");
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

  private boolean checkCustomerIdValid(String strNum) {
    if (strNum == null) {
      return false;
    } else if (isNumberic(strNum) && strNum.length() == 6) {
      return true;
    }
    return false;

  }
}
