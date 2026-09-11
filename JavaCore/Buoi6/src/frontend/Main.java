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
    System.out.println("1.account ");
    System.out.println("2.department");
    System.out.println("3.positiot");
    System.out.println("4.thoát.");
    System.out.println("====Mời bạn chọn chức năng====");
    String lucChon = sc.nextLine();
    switch (lucChon) {
        case "1":while (true) {
            System.out.println("==============================MENU ACCOUNT==============================");
            System.out.println("1.Thêm account");
            System.out.println("2.sửa username theo accountId");
            System.out.println("3.xóa account theo accountId");
            System.out.println("4.hiển thị ds account");
            System.out.println("5.trở về menu chính");
            String chonPhu = sc.nextLine();
            switch (chonPhu) {
                case "1":
                    qa.themAccount();
                    continue;
                case "2":
                    qa.suaUsernameTheoId();
                    continue;
                case "3":
                    qa.xoaAccount();
                    continue;
                case "4":
                    qa.hienthi();
                    continue;
                case "5":
                    break;
                default:System.out.println("Nhập sai nhập lại"); continue;
            }
            break;
        }
            break;
        case "2":while (true) {
            System.out.println("==============================MENU DEPARTMENT==============================");
            System.out.println("1.Thêm department");
            System.out.println("2.sửa departmentname theo departmentid");
            System.out.println("3.xóa department theo departmentid");
            System.out.println("4.hiển thị ds department");
            System.out.println("5.trở về menu chính");
            String chonPhu = sc.nextLine();
            switch (chonPhu) {
                case "1":
                    qd.themDepartment();
                    continue;
                case "2":
                    qd.suaDepartmentNameTheoId();
                    continue;
                case "3":
                    qd.xoaDepartment();
                    continue;
                case "4":
                    qd.hienthi();
                    continue;
                case "5":
                    break;
                default:System.out.println("Nhập sai nhập lại"); continue;
            }
            break;
        }
            break;
        case "3":while (true) {
            System.out.println("==============================MENU POSITION===============================");
            System.out.println("1.Thêm position");
            System.out.println("2.sửa positionname theo positionId");
            System.out.println("3.xóa position theo positionId");
            System.out.println("4.hiển thị ds position");
            System.out.println("5.trở về menu chính");
            String chonPhu = sc.nextLine();
            switch (chonPhu) {
                case "1":
                    qp.themPosition();
                    continue;
                case "2":
                    qp.suaPositionNameTheoId();
                    continue;
                case "3":
                    qp.xoaPosition();
                    continue;
                case "4":
                    qp.hienthi();
                    continue;
                case "5":
                    break;
                default:System.out.println("Nhập sai nhập lại"); continue;
            }
            break;
        }
            break;
        case "4":
            System.exit(0);
        default:
            System.out.println("Nhập sai nhập lại");
    }
}
    }
}