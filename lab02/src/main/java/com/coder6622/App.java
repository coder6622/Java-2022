package com.coder6622;

import com.coder6622.models.Account;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        OutputMenuMain();

        Account account1 = new Account();
        account1.setAccountNumber("024569");
        account1.setBalance(10232323);
        System.out.println(account1);
    }

    private static void OutputMenuMain() {
        String seperate = "+-----------------------------+-----------------------------+-----------------------------|";
        String versionApp = "v2.0.0";
        String mssv = "2014469";
        System.out.println(seperate);
        System.out.println("|NGAN HANG SO | " + mssv + versionApp);
        System.out.println(seperate);
        System.out.println("| 1. Them khach hang");
        System.out.println("| 2. Them tai khoan cho khach hang");
        System.out.println("| 3. Hien thi danh sach khach hang");
        System.out.println("| 4. Tim theo ten khach hang");
        System.out.println("| 5. Tim theo CCCD");
        System.out.println("| 0. Thoat");
        System.out.println(seperate);
        System.out.print(">>Chuc nang: ");
    }
}
