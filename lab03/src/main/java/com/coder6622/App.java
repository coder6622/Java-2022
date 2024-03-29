package com.coder6622;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.coder6622.asm02.models.Account;
import com.coder6622.asm02.models.Customer;
import com.coder6622.asm03.models.DigitalBank;
import com.coder6622.asm03.models.HistoryTransaction;
import com.coder6622.asm03.models.LoansAccount;
import com.coder6622.asm03.models.SavingAccount;
import com.coder6622.asm03.models.Transaction;
import com.coder6622.asm03.models.TransactionCustomer;
import com.coder6622.asm03.models.common.AccountType;
import com.coder6622.utils.Utils;

/**
 * Hello world!
 *
 */

public class App {

    private static final DigitalBank activeBank = new DigitalBank();

    private static final Scanner scanner = new Scanner(System.in);
    private static final Customer newCustomer = new Customer();
    private static final Customer newCustomer1 = new Customer();

    private static HistoryTransaction historyTransaction = new HistoryTransaction();

    private static boolean isRunApp = true;

    public static void main(String[] args) {
        initialCustomer();
        handleMenuMain();

    }

    // todo: handle events
    private static void displayMenu() {
        String seperate = "+-----------------------------+-----------------------------+-----------------------------|";
        String versionApp = "v3.0.0";
        String mssv = "2014469";
        System.out.println(seperate);
        System.out.println("|NGÂN HÀNG SỐ | " + mssv + versionApp);
        System.out.println(seperate);
        System.out.println("| 1. Thông tin khách hàng");
        System.out.println("| 2. Thêm tài khoản ATM");
        System.out.println("| 3. Thêm tài khoản tín dụng");
        System.out.println("| 4. Rút tiền");
        System.out.println("| 5. Lịch sử giao dịch");
        System.out.println("| 0. Thoát");
        System.out.println(seperate);
        System.out.print(">>Chức năng: ");
    }

    private static void handleMenuMain() {
        do {
            displayMenu();
            try {
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1: {
                        scanner.nextLine();
                        showCustomer();
                        break;
                    }
                    case 2: {
                        scanner.nextLine();
                        handleAddAccount(AccountType.saving);
                        break;
                    }
                    case 3: {
                        scanner.nextLine();
                        handleAddAccount(AccountType.loans);
                        break;
                    }
                    case 4: {
                        scanner.nextLine();
                        handleWithDrawCase();
                        break;
                    }
                    case 5: {
                        scanner.nextLine();
                        handleTransactionCase();
                        break;
                    }
                    case 0: {
                        isRunApp = false;
                        System.out.println("Thoát...");
                        break;
                    }
                }
            } catch (InputMismatchException a) {
                System.out.println("Nhập sai định dạng số, mời bạn thực hiện lại tiến trình...");
                return;
            }
        } while (isRunApp);
    }

    // todo: methods

    private static void initialCustomer() {
        // customer 1
        newCustomer.setCustomerId("068202000678");
        newCustomer.setName("Long 1");

        newCustomer.addAccount(new LoansAccount("123456", 400000));
        newCustomer.addAccount(new LoansAccount("234569", 900000));
        newCustomer.addAccount(new SavingAccount("234567", 400000));
        newCustomer.addAccount(new SavingAccount("234568", 400000000));

        // customer 2
        newCustomer1.setCustomerId("068202000673");
        newCustomer1.setName("Long");

        newCustomer1.addAccount(new LoansAccount("123456", 400000));
        newCustomer1.addAccount(new LoansAccount("234569", 900000));
        newCustomer1.addAccount(new SavingAccount("234567", 400000));
        newCustomer1.addAccount(new SavingAccount("234568", 400000000));

        activeBank.addCustomer(newCustomer1);
        activeBank.addCustomer(newCustomer);
    }

    private static void handleAddAccount(AccountType accountType) {

        int soLanNhapCccd = 0;
        int soLanNhapAccountNumber = 0;
        int soLanNhapBalance = 0;

        String cccd;
        String accountNumber;
        double balance;
        Account account;

        Customer customer;
        if (accountType == AccountType.loans) {
            account = new LoansAccount();
        } else {
            account = new SavingAccount();
        }

        // todo: nhập cccd
        do {
            if (soLanNhapCccd > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            if (soLanNhapCccd > 0) {
                System.out.print("Khách hàng không tồn tại, vui lòng nhập lại hoặc 'No' để thoát: ");
            } else {
                System.out.print("Nhập CCCD khách hàng: ");
            }
            cccd = scanner.nextLine();
            if (cccd.equals("No")) {
                return;
            }
            customer = activeBank.getCustomerById(cccd);
            soLanNhapCccd++;
        } while (customer == null);

        // todo: nhập số tài khoản
        do {
            if (soLanNhapAccountNumber > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            System.out.print("Nhập mã STK gồm 6 chữ số (Nhập 'No' để thoát): ");
            try {
                accountNumber = scanner.nextLine();
            } catch (InputMismatchException e) {
                return;
            }
            soLanNhapAccountNumber++;
        } while (!account.setAccountNumber(accountNumber) || !customer.addAccount(account));

        // todo: nhập số dư
        do {
            if (soLanNhapBalance > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            System.out.print("Nhập số dư (Nhập 'No' đễ thoát): ");
            balance = scanner.nextDouble();
            soLanNhapBalance++;
        } while (!account.setBalance(balance));

        return;
    }

    private static void handleWithDrawCase() {
        int soLanNhapCccd = 0;
        int soLanNhapAccountNumber = 0;
        int soLanNhapSoTienRut = 0;

        String cccd;
        String accountNumber;
        double soTienRut = -1.0;
        Account account;

        Customer customer;

        // todo: nhập cccd
        do {
            if (soLanNhapCccd > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            if (soLanNhapCccd > 0) {
                System.out.print("Khách hàng không tồn tại, vui lòng nhập lại hoặc 'No' để thoát: ");
            } else {
                System.out.print("Nhập CCCD khách hàng: ");
            }
            cccd = scanner.nextLine();
            if (cccd.equals("No")) {
                return;
            }
            customer = activeBank.getCustomerById(cccd);
            soLanNhapCccd++;
        } while (customer == null);

        // todo: nhập số tài khoản
        do {
            if (soLanNhapAccountNumber > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            System.out.print("Nhập mã STK gồm 6 chữ số (Nhập 'No' để thoát): ");
            accountNumber = scanner.nextLine();
            if (accountNumber.equals("No")) {
                return;
            }
            soLanNhapAccountNumber++;
            account = customer.getAccountByAccountNumber(accountNumber);
        } while (account == null);

        // todo: nhập số tiền cần rút
        do {
            if (soLanNhapSoTienRut > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            System.out.print("Nhập số tiền cần rút (Nhập 'No' đễ thoát): ");
            soTienRut = scanner.nextDouble();
            if (String.valueOf(soTienRut).equals("No")) {
                return;
            }
            soLanNhapSoTienRut++;
        } while (!account.withdraw(soTienRut));

        TransactionCustomer transactionCustomer = historyTransaction.getTransactionTestByCustoer(customer);

        transactionCustomer
                .addTransaction(new Transaction(account.getAccountNumber(), soTienRut, Utils.getDateTimeNow(), true));
        return;
    }

    private static void showCustomer() {
        for (Customer customer : activeBank.getCustomers()) {
            customer.displayInformation();
        }
    }

    private static void handleTransactionCase() {
        historyTransaction.displayInformation();
    }
}
