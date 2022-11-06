package com.coder6622.models;

import com.coder6622.utils.FunctionsCommon;

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

  public boolean setCustomerId(String customerId) {
    if (checkCustomerIdValid(customerId)) {
      this.customerId = customerId;
      return true;
    }
    return false;
  }

  private boolean checkCustomerIdValid(String strNum) {
    int lengthId = 12;
    if (strNum == null) {
      return false;
    } else if (FunctionsCommon.checkStringIsNumberic(strNum) && strNum.length() == lengthId) {
      return true;
    }
    return false;
  }
}
