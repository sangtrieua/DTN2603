import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class BTVN_Buoi3 {
    public static Scanner sc = new Scanner(System.in);
    public void exercise1Question1() {
        float salaryAccount1 = 5240.5f;
        float salaryAccount2 = 10970.055f;

        int salaryAccount1Int = (int) salaryAccount1;
        int salaryAccount2Int = (int) salaryAccount2;

        System.out.println(
                "Lương Account 1 sau khi ép kiểu: "
                        + salaryAccount1Int
        );

        System.out.println(
                "Lương Account 2 sau khi ép kiểu: "
                        + salaryAccount2Int
        );
    }
    public int exercise1Question2() {
        Random random = new Random();

        int randomNumber = random.nextInt(100000);

        System.out.printf(
                "Số ngẫu nhiên: %05d%n",
                randomNumber
        );
        return randomNumber;
    }
    public String exercise1Question3Cach1() {
        String formattedNumber =
                String.format("%05d", exercise1Question2());

        String lastTwoCharacters =
                formattedNumber.substring(
                        formattedNumber.length() - 2
                );

        System.out.println(
                "Hai số cuối: " + lastTwoCharacters
        );
        return lastTwoCharacters;
    }
    public int exercise1Question3Cach2() {
        int lastTwoDigits = exercise1Question2() % 100;

        System.out.printf(
                "Hai số cuối: %02d%n",
                lastTwoDigits
        );
        return lastTwoDigits;
    }
    public float exercise1Question4() {
        int a,b;
    while (true) {
        System.out.println("Nhập số nguyên a: ");
        if (!sc.hasNextInt()) {
            System.out.println("Nhập sai định dạng!!! ");
            sc.nextLine();
            continue;
        }
        a = sc.nextInt();
        sc.nextLine();
        break;
    }
    while (true) {System.out.println("Nhập số nguyên b: ");
        if (!sc.hasNextInt()) {
            System.out.println("Nhập sai định dạng!!! ");
            sc.nextLine();
            continue;
        }
        b = sc.nextInt();
        sc.nextLine();
        if(b==0) {
            System.out.println("Không thể chia cho 0");
            continue;
        }
        break;
    }

        return (float) a/b;
    }

    public void exercise2Question1(Account[] accounts,int soLuong) {
        for (int i = 0; i < soLuong; i++) {
            accounts[i] = new Account();
            accounts[i].accountId = i + 1;
            accounts[i].email = "Email " + (i + 1);
            accounts[i].username = "User name " + (i + 1);
            accounts[i].fullName = "Full name " + (i + 1);
            accounts[i].createDate = new Date();
        }

    }
    public void exercise3Question1() {
        Integer salary = 5000;
        float salaryFloat = salary.floatValue();

        System.out.printf("Lương: %.2f%n", salaryFloat);
    }

    public void exercise3Question2() {
        String numberString = "1234567";
        int number = Integer.parseInt(numberString);

        System.out.println("Số int: " + number);
    }

    public void exercise3Question3() {
        Integer numberInteger = Integer.valueOf("1234567");
        int numberInt = numberInteger.intValue();

        System.out.println("Số int: " + numberInt);
    }

}
