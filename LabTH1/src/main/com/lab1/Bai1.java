package main.com.lab1;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai1 {
  private static Scanner scanner = new Scanner(System.in);
  private static boolean exitApp = false;
  private static String cccd;
  private static Pattern checkNumber = Pattern.compile("-?\\d+(\\.\\d+)?");
  private static Map<String, String> birthPlaces =
      new HashMap<String, String>() {
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

  public Bai1() {}

  public static void main(String[] args) {
    handleMenuMain();
  }

  private static void OutputMenuMain() {
    String seperate =
        "+-----------------------------+-----------------------------+-----------------------------|";
    String versionApp = "v1.0.0";
    String mssv = "2014469";
    System.out.println(seperate);
    System.out.println("|NGÂN HÀNG SỐ | " + mssv + versionApp);
    System.out.println(seperate);
    System.out.println("| 1. Nhập CCCD");
    System.out.println("| 0. Thoát");
    System.out.println(seperate);
    System.out.print(">>Chức năng: ");
  }

  private static void displayMenuCCCD() {
    System.out.println("\t| 1. Kiểm tra nơi sinh");
    System.out.println("\t| 2. Kiểm tra giới tính, tuổi");
    System.out.println("\t| 3. Kiểm tra số ngẫu nhiên");
    System.out.println("\t| 0. Thoát");
    System.out.print(">> Nhập chức năng: ");
  }

  // todo: ----------------------------Methods------------------------
  // private static int randomNumber() {
  //   int max = 1000;
  //   int min = 1;
  //   return (int) Math.floor(Math.random() * (max - min + 1) + min);
  // }

  private static String randomSixChar() {
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = upper.toLowerCase();
    String digits = "0123456789";
    String alphanum = upper + lower + digits;

    Random random = new Random();
    char[] buf = new char[6];
    char[] symbols = alphanum.toCharArray();

    for (int i = 0; i < buf.length; i++) {
      buf[i] = symbols[random.nextInt(symbols.length)];
    }

    return String.valueOf(buf);
  }

  private static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    return checkNumber.matcher(strNum).matches();
  }

  private static boolean isEven(int n) {
    return (n & 1) == 0;
  }

  private static int caculateCentury(int gender) {
    int temp = gender;
    int centuryPin = 20;
    if (!isEven(temp)) {
      temp--;
    }
    return temp / 2 + centuryPin;
  }

  private static String caculateYear(String namSinh, int century) {
    return Integer.toString(century - 1) + namSinh;
  }

  private static String checkGender(int gender) {
    if (isEven(gender)) {
      return "Nam";
    }
    return "Nữ";
  }

  private static String checkBirthPlace(String codeBirthPlace) {
    String result = birthPlaces.get(codeBirthPlace);
    if (result != null) {
      return result;
    }
    return "Không có giá trị";
  }

  // ----------------------------Events handle--------------------------------------
  private static boolean verifyCode() {
    String codeRandom = randomSixChar();
    System.out.println(codeRandom);
    String codeInput;
    int soLanNhapCode = 0;
    String message = "Nhập mã xác thực: ";
    do {
      if (soLanNhapCode != 0) {
        message = "Mã sai, vui lòng nhập lại: ";
      }
      System.out.print(message);
      codeInput = scanner.next();
      soLanNhapCode++;
      if (soLanNhapCode > 4) {
        System.out.println("Bạn đã nhập lại quá 3 lần");
        return false;
      }
    } while (!codeInput.equals(codeRandom));
    scanner.nextLine();
    return true;
  }

  private static boolean handleCCCDCase() {
    if (!verifyCode()) {
      return false;
    }
    if (inputCCCD()) {
      handleCCCDFunctions();
      return true;
    } else {
      System.out.println("Đang thoát ra menu chính....");
      return true;
    }
  }

  private static boolean inputCCCD() {
    int length;
    int soLanNhapCode = 0;
    do {
      if (soLanNhapCode > 0) {
        System.out.print("CCCD không hợp lệ, vui lòng nhập lại hoặc \'No\' để thoát: ");
      } else {
        System.out.print("Nhập CCCD: ");
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

  private static void handleCCCDFunctions() {
    boolean isExitCase = false;
    do {
      displayMenuCCCD();
      try {
        int choose;
        do {
          choose = scanner.nextInt();
        } while (choose < 0 && choose > 3);
        switch (choose) {
          case 1:
            {
              String codeBirthPlace = cccd.substring(0, 3).toString();
              System.out.println("Nơi sinh là: " + checkBirthPlace(codeBirthPlace));
              break;
            }
          case 2:
            {
              int keyGender = Integer.parseInt(cccd.substring(3, 4));
              String year = cccd.substring(4, 6);
              System.out.println("Giới tính là: " + checkGender(keyGender));
              System.out.println("Năm sinh là: " + caculateYear(year, caculateCentury(keyGender)));
              break;
            }
          case 3:
            {
              String result = cccd.substring(6, cccd.length());
              System.out.println("Số ngẫu nhiên: " + result);
              break;
            }
          case 0:
            {
              System.out.println("Dang thoat ra menu....");
              isExitCase = true;
              break;
            }
        }
      } catch (InputMismatchException a) {
        System.out.println("Nhap sai dinh dang so, moi ban thuc hien lai tien trinh");
        return;
      }
    } while (!isExitCase);
  }

  private static void handleMenuMain() {
    do {
      OutputMenuMain();
      try {
        int choose = scanner.nextInt();
        switch (choose) {
          case 1:
            exitApp = handleCCCDCase();
            break;
          case 0:
            exitApp = false;
            System.out.println("Thoát...");
            break;
        }
      } catch (InputMismatchException a) {
        System.out.println("Nhập sai định dạng số, mời bạn thực hiện lại tiến trình...");
        return;
      }
    } while (exitApp);
  }
}
