package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLPosition;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private QLDepartment qd=new QLDepartment();
    private QLPosition qp=new QLPosition();
    private QLAccount qa=new QLAccount();
    private Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
Main obj=new Main();
obj.menu();
    }
    public void menu(){
while (true) {
    System.out.println("==============================MENU==============================");
    System.out.println("1.hiển thị toàn bộ account theo dạng bảng");
    System.out.println("2.hiển thị toàn bộ department theo dạng bảng");
    System.out.println("3.hiển thị toàn bộ position theo dạng bảng");
    System.out.println("4.thoát.");
    System.out.println("====Mời bạn chọn chức năng====");
    String lucChon = sc.nextLine();
    switch (lucChon) {
        case "1":
            qa.hienthi();
            break;
        case "2":
            qd.hienthi();
            break;
        case "3":
            qp.hienthi();
            break;
        case "4":
            System.exit(0);
        default:
            System.out.println("Nhập sai nhập lại");
    }
}
    }
}