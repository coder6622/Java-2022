package com.coder6622;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.coder6622.models.Account;
import com.coder6622.models.Bank;
import com.coder6622.models.Customer;

/**
 * Hello world!
 *
 */
public class App {

    private static final Bank bank = new Bank();
    private static boolean isRunApp = true;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        outputMenuMain();
        handleMenuMain();
        // OutputMenuMain();
        // System.out.println();

        // Account account1 = new Account();
        // account1.setAccountNumber("024569");
        // account1.setBalance(10232323);
        // System.out.println(account1);

        // Account account2 = new Account();
        // account2.setAccountNumber("323233");
        // account2.setBalance(4545454);
        // System.out.println(account2);

        // Customer customer1 = new Customer();
        // customer1.setCustomerId("068202000673");
        // customer1.setName("Long");
        // customer1.addAccount(account1);
        // customer1.addAccount(account2);
        // customer1.displayInformation();
    }

    private static void outputMenuMain() {
        String seperate = "+-----------------------------+-----------------------------+-----------------------------|";
        String versionApp = "v2.0.0";
        String mssv = "2014469";
        System.out.println(seperate);
        System.out.println("|NGÂN HÀNG SỐ | " + mssv + versionApp);
        System.out.println(seperate);
        System.out.println("| 1. Thêm khách hàng");
        System.out.println("| 2. Thêm tài khoản cho khách hàng");
        System.out.println("| 3. Hiển thị danh sách khách hàng");
        System.out.println("| 4. Tim theo ten khach hang");
        System.out.println("| 5. Tìm theo CCCD");
        System.out.println("| 0. Thoát");
        System.out.println(seperate);
        System.out.print(">>Chức năng: ");
    }

    // todo: ----------------------------Methods------------------------

    private static void handleAddCustomerCase() {
        int soLanNhap = 0;
        String cccd;
        Customer customer = new Customer();
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        customer.setName(name);
        do {
            if (soLanNhap > 3) {
                System.out.println("Bạn đã nhập quá 3 lần");
                return;
            }
            if (soLanNhap > 0) {
                System.out
                        .print("Số CCCD không hợp lệ, vui lòng nhập lại (Nhập quá 3 lần hệ thống sẽ tự động thoát): ");
            } else {
                System.out.print("Nhập số CCCD: ");
            }
            cccd = scanner.nextLine();
            soLanNhap++;
        } while (!customer.setCustomerId(cccd));

        bank.addCustomer(customer);
        return;
    }

    private static void handelAddAccountForCustomerCase() {
        int soLanNhapCccd = 0;
        int soLanNhapAccountNumber = 0;
        int soLanNhapBalance = 0;

        String cccd;
        String accountNumber;
        double balance;

        Customer customer;
        Account account = new Account();

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
            customer = bank.getCustomer(cccd);
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

    private static void handleMenuMain() {
        do {
            outputMenuMain();
            try {
                int choose = scanner.nextInt();
                switch (choose) {

                    case 1: {
                        scanner.nextLine();
                        handleAddCustomerCase();
                        break;
                    }
                    case 2: {
                        scanner.nextLine();
                        handelAddAccountForCustomerCase();
                        break;
                    }
                    case 3: {
                        bank.displayInformation();
                        isRunApp = true;
                        break;
                    }
                    case 4: {
                        break;
                    }
                    case 5: {
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
}
