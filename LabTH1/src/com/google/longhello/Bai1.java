package com.google.longhello;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai1 {
	static Scanner scanner = new Scanner(System.in);
	static boolean exitToMenu = false;

	public Bai1() {
	}

	public static void main(String[] args) {
		HandleMenu();
	}

	public static void Menu() {
		String seperate = "+-----------------------------+-----------------------------+-----------------------------|";
		String versionApp = "v1.0.0";
		String mssv = "2014469";
		System.out.println(seperate);
		System.out.println("|NGAN HANG SO | " + mssv + versionApp);
		System.out.println(seperate);
		System.out.println("| 1. Nhap CCCD");
		System.out.println("| 0. Thoat");
		System.out.println(seperate);
		System.out.print(">>Chuc nang");
	}

	public static int Random() {
		int max = 1000;
		int min = 1;

		return (int) Math.floor(Math.random() * (max - min + 1) + min);

	}
	
	private static void handleCase1() {
		int codeRandom = Random();
		int codeInput;
		int soLanNhapCode = 0;
		System.out.println(codeRandom);
		do {
			if (soLanNhapCode > 0) {
				System.out.print("Ma sai, vui long nhap lai: ");
			} else {
				System.out.print("Nhap ma xac thuc: ");
			}
			codeInput = scanner.nextInt();
			soLanNhapCode++;

		} while (codeInput != codeRandom);

		if (checkCCCD()) {
			displayMenuCheckInfo();

		} else {
			System.out.println("Thoat...");
			exitToMenu = true;
			return;
		}
	}

	private static void displayMenuCheckInfo() {
		System.out.println("\t| 1. Kiem tra noi sinh");
		System.out.println("\t| 2. Kiem tra tuoi, gioi tinh");
		System.out.println("\t| 3. Kiem tra so ngau nhien");
		System.out.println("\t| 4. Thoat");
		System.out.print(">> Nhap chuc nang: ");
	}

	Map<String, String> doubleBraceMap = new HashMap<String, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		{
			put("001", "Hà Nội");
			put("002", "Hà Giang");
			put("004", "Cao Bằng");
			put("006", "Bắc Kạn");
			put("008", "Tuyên Quang");
			put("010", "Lào Cai");
			put("011", "Điện Biên");
			put("012", "Lai Châu");
			put("014", "Sơn La");
			put("015", "Yên Bái");
			put("017", "Hòa Bình");
			put("019", "Thái Nguyên");
			put("020", "Lạng Sơn");
			put("022", "Quảng Ninh");
			put("024", "Bắc Giang");
			put("025", "Phú Thọ");
			put("026", "Vĩnh Phúc");
			put("027", "Bắc Ninh");
			put("030", "Hải Dương");
			put("031", "Hải Phòng");
			put("033", "Hưng Yên");
			put("034", "Thái Bình");
			put("035", "Hà Nam");
			put("036", "Nam Định");
			put("037", "Ninh Bình");
			put("038", "Thanh Hóa");
			put("040", "Nghệ An");
			put("042", "Hà Tĩnh");
			put("044", "Quảng Bình");
			put("045", "Quảng Trị");
			put("046", "Thừa Thiên Huế");
			put("048", "Đà Nẵng");
			put("049", "Quảng Nam");
			put("051", "Quảng Ngãi");
			put("052", "Bình Định");
			put("054", "Phú Yên");
			put("056", "Khánh Hòa");
			put("058", "Ninh Thuận");
			put("060", "Bình Thuận");
			put("062", "Kon Tum");
			put("064", "Gia Lai");
			put("066", "Đắk Lắk");
			put("067", "Đắk Nông");
			put("068", "Lâm Đồng");
			put("070", "Bình Phước");
			put("072", "Tây Ninh");
			put("074", "Bình Dương");
			put("075", "Đồng Nai");
			put("077", "Bà Rịa - Vũng Tàu");
			put("079", "Hồ Chí Minh");
			put("080", "Long An");
			put("082", "Tiền Giang");
			put("083", "Bến Tre");
			put("084", "Trà Vinh");
			put("086", "Vĩnh Long");
			put("087", "Đồng Tháp");
			put("089", "An Giang");
			put("091", "Kiên Giang");
			put("092", "Cần Thơ");
			put("093", "Hậu Giang");
			put("094", "Sóc Trăng");
			put("095", "Bạc Liêu");
			put("096", "Cà Mau");
		}
	};

	private static void displayNoiSinh() {

	}

	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

	private static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		return pattern.matcher(strNum).matches();
	}

	private static boolean checkCCCD() {
		int length;
		String cccd;
		scanner.nextLine();
		int soLanNhapCode = 0;
		do {
			if (soLanNhapCode > 0) {
				System.out.print("CCCD khong hop le, vui long nhap lai hoac nhap \'No\' de thoat: ");
			} else {
				System.out.print("Nhap CCCD: ");
			}
			cccd = scanner.nextLine();
			length = cccd.length();
			System.out.println(length);
			System.out.println(cccd);
			soLanNhapCode++;
			if (cccd.equals("No")) {
				return false;
			}
		} while (length != 12 || !isNumeric(cccd));
		return true;
	}

	public static void HandleMenu() {
		do {
			Menu();
			try {
				int choose = scanner.nextInt();
				switch (choose) {
				case 1:
					handleCase1();
					break;
				case 0:
					exitToMenu = false;
					System.out.println("Thoat...");
					break;
				}
			} catch (InputMismatchException a) {
				System.out.println("Nhap sai dinh dang so, moi ban thuc hien lai tien trinh");
				return;
			}
		} while (exitToMenu);

	}
}
