package com.coder6622.asm03.models;

import com.coder6622.asm02.models.Customer;
import com.coder6622.asm03.models.common.IWithdraw;

public class DigitalCustomer extends Customer implements IWithdraw {

  @Override
  public boolean withdraw(double amount) {
    return false;
  }

  @Override
  public boolean isAccepted(double amount) {
    return false;
  }

}
