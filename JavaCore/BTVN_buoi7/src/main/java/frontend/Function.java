package frontend;

import backend.controller.QLNSController;
import entity.Account;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Function {
    private Scanner sc = new Scanner(System.in);
    private QLNSController controller = new QLNSController();
    public void them(){
        String email;
        String userName;
        String fullName;
        Integer departmentId;
        Integer positionId;
        String gender;
        System.out.println("Nhập email");
        email=sc.nextLine();
        System.out.println("Nhập userName");
        userName=sc.nextLine();
        System.out.println("Nhập fullName");
        fullName=sc.nextLine();
        while (true) {
            System.out.println("Nhập departmentId");
            if(sc.hasNextInt()) {
                departmentId = sc.nextInt();
                sc.nextLine();
                    if (controller.kiemTraTonTaiDepartmentId(departmentId)) {
                        break;
                    }
                    else {
                        System.out.println(" departmentId này chưa tồn tại hãy nhập lại!!");
                    }

            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        while (true) {
            System.out.println("Nhập positionId");
            if(sc.hasNextInt()) {
                positionId = sc.nextInt();
                sc.nextLine();

                    if (controller.kiemTraTonTaiPostionId(positionId)) {
                        break;
                    }
                    else {
                        System.out.println(" positionId này chưa tồn tại hãy nhập lại!!");
                    }

            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }

        System.out.println("Nhập gender:Nhập: 1:Nam      2:Nữ        khác:Chưa xác định");
        String choosenGender=sc.nextLine();
        switch(choosenGender) {
            case "1":gender="nam";
                break;
            case "2": gender="nữ";
                break;
            default: gender="chưa xác định";

        }
        if(controller.themAccount(email,userName,fullName,departmentId,positionId,gender))
            System.out.println("thêm Thành công");
        else
            System.out.println("thêm Thất bại");
    }
    public void sua(){
        Integer accountId;
        String userName;
        while (true) {
            System.out.println("Nhập accountId");
            if(sc.hasNextInt()) {
                accountId = sc.nextInt();
                sc.nextLine();
                boolean checkId=controller.kiemTraTonTaiAccountId(accountId);
                    if (checkId) {
                        break;
                    }
                    else {
                        System.out.println("account_id này chưa tồn tại hãy nhập lại!!");
                    }

            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        System.out.println("nhập username:");
        userName=sc.nextLine();
        if(controller.suaUsernameTheoId(accountId,userName))
            System.out.println("sửa thành công");
        else System.out.println("sửa thất bại");
    }
    public void xoa(){
        Integer accountId;
        while (true) {
            System.out.println("Nhập accountId");
            if(sc.hasNextInt()) {
                accountId = sc.nextInt();
                sc.nextLine();
                boolean checkId=controller.kiemTraTonTaiAccountId(accountId);
                if (checkId) {
                    break;
                }
                else {
                    System.out.println("account_id này chưa tồn tại hãy nhập lại!!");
                }

            }
            else  {
                System.out.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        if(controller.xoaAccountTheoId(accountId))
            System.out.println("xóa thành công");
        else System.out.println("xóa thất bại");
    }
    public void hienthi(){
        System.out.println("================HIỂN THỊ ACCOUNT================");
        List<Account> accounts= controller.getAccountS();
        this.show(accounts);
    }

    private void show(List<Account> accounts) {
        System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");
        System.out.printf("|%-10s|%-35s|%-15s|%-20s|%-10s|%-10s|%-20s|%-10s|\n","Accout ID","Email","userName","fullName","departmentId","positionId","createDate","gender");
        System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");

        for (Account account : accounts) {
            account.hienThiTheoDong();
        }
        System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");

    }

    public void menu() {
        while (true) {
            System.out.println("==============================MENU ACCOUNT==============================");
            System.out.println("1.Thêm account");
            System.out.println("2.sửa username theo accountId");
            System.out.println("3.xóa account theo accountId");
            System.out.println("4.hiển thị ds account");
            System.out.println("5.trở về menu chính");
            String chonPhu = sc.nextLine();
            switch (chonPhu) {
                case "1":
                    this.them();
                    continue;
                case "2":
                    this.sua();
                    continue;
                case "3":
                    this.xoa();
                    continue;
                case "4":
                    this.hienthi();
                    continue;
                case "5":
                    System.exit(0);
                default:System.out.println("Nhập sai nhập lại"); continue;
            }
        }
    }
}
