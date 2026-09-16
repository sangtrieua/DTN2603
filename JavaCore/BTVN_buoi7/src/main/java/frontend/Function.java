package frontend;

import backend.controller.AccountController;
import backend.controller.DepartmentController;
import backend.controller.PostionController;
import entity.Account;
import entity.Department;
import entity.Postion;

import java.util.List;
import java.util.Scanner;

public class Function {
    private Scanner sc = new Scanner(System.in);
    private AccountController accountController = new AccountController();
    private DepartmentController departmentController = new DepartmentController();
    private PostionController postionController = new PostionController();

    public boolean checkLength(String text,int min, int max) {

            if (text.length() < min || text.length() > max) {
                System.err.printf("Tổng kí tự phải > %d và <%d\n", min, max);
                return false;


        }
        return true;
    }
    public void them(){
        String userName;
        while(true){
            System.out.println("Nhập userName");
            userName=sc.nextLine();
            if(!this.checkLength(userName,6,100))
                continue;
            if(accountController.checkTonTaiUserNameThem(userName.trim()))
            {
                System.err.println("userName này đã tồn tại");
                continue;
            }
            break;
        }
        String email;
        while(true){
            System.out.println("Nhập email");
            email=sc.nextLine();
            if(!this.checkLength(email,6,100))
                continue;
            if(!email.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                System.err.println("Nhập sai định dạng mail");
                continue;
            }
            if(accountController.checkTonTaiEmail(email.trim()))
            {
                System.err.println("mail này đã tồn tại");
                continue;
            }
            break;
        }

        String fullName;
        while(true){
            System.out.println("Nhập fullName");
            fullName=sc.nextLine();
            if(!this.checkLength(fullName,6,100))
                continue;
            break;
        }
        Integer departmentId;
        while (true) {
            System.out.println("Nhập departmentId");
            this.showDepartment(departmentController.getDepartments());
            if(sc.hasNextInt()) {
                departmentId = sc.nextInt();
                sc.nextLine();
                    if (departmentController.kiemTraTonTaiDepartmentId(departmentId)) {
                        break;
                    }
                    else {
                        System.err.println("departmentId này chưa tồn tại hãy nhập lại!!");
                    }

            }
            else  {
                System.err.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        Integer positionId;
        while (true) {
            System.out.println("Nhập positionId");
            this.showPostion(postionController.getPostions());
            if(sc.hasNextInt()) {
                positionId = sc.nextInt();
                sc.nextLine();

                    if (postionController.kiemTraTonTaiPostionId(positionId)) {
                        break;
                    }
                    else {
                        System.err.println("positionId này chưa tồn tại hãy nhập lại!!");
                    }

            }
            else  {
                System.err.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }

        String gender;
        System.out.println("Nhập gender:Nhập: 1:Nam      2:Nữ        khác:Chưa xác định");
        String choosenGender=sc.nextLine();
        switch(choosenGender) {
            case "1":gender="nam";
                break;
            case "2": gender="nữ";
                break;
            default: gender="chưa xác định";

        }
        if(accountController.themAccount(email,userName,fullName,departmentId,positionId,gender))
            System.out.println("thêm Thành công");
        else
            System.err.println("thêm Thất bại");
    }
    public void sua(){
        Integer accountId;
        while (true) {
            System.out.println("Nhập accountId");
            if(sc.hasNextInt()) {
                accountId = sc.nextInt();
                sc.nextLine();
                boolean checkId= accountController.kiemTraTonTaiAccountId(accountId);
                    if (checkId) {
                        break;
                    }
                    else {
                        System.err.println("account_id này không tồn tại hãy nhập lại!!");
                    }

            }
            else  {
                System.err.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        String userName;
        while(true){
            System.out.println("Nhập userName");
            userName=sc.nextLine();
            if(!this.checkLength(userName,6,100))
                continue;
            if(accountController.checkTonTaiUserNameSua(accountId,userName.trim()))
            {
                System.err.println("userName này đã tồn tại");
                continue;
            }
            break;
        }
        if(accountController.suaUsernameTheoId(accountId,userName))
            System.out.println("sửa thành công");
        else System.err.println("sửa thất bại");
    }
    public void xoa(){
        Integer accountId;
        while (true) {
            System.out.println("Nhập accountId");
            if(sc.hasNextInt()) {
                accountId = sc.nextInt();
                sc.nextLine();
                boolean checkId= accountController.kiemTraTonTaiAccountId(accountId);
                if (checkId) {
                    break;
                }
                else {
                    System.err.println("account_id này chưa tồn tại hãy nhập lại!!");
                }
            }
            else  {
                System.err.println("hãy nhập 1 số nguyên");
                sc.nextLine();
            }
        }
        if(accountController.xoaAccountTheoId(accountId))
            System.out.println("xóa thành công");
        else System.err.println("xóa thất bại");
    }
    public void hienthi(){
        System.out.println("================HIỂN THỊ ACCOUNT================");
        List<Account> accounts= accountController.getAccountS();
        this.showAccount(accounts);
    }

    private void showAccount(List<Account> accounts) {
        System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");
        System.out.printf("|%-10s|%-35s|%-15s|%-20s|%-10s|%-10s|%-20s|%-10s|\n","Accout ID","Email","userName","fullName","departmentId","positionId","createDate","gender");
        System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");

        for (Account account : accounts) {
            account.hienThiTheoDong();
        }
        System.out.println("+==========+===================================+===============+====================+==========+==========+====================+==========+");

    }
    private void showPostion(List<Postion> postions) {
        System.out.println("DANH SÁCH POSTION");
        System.out.println("+===============+==============================+");
        System.out.printf("|%-15s|%-30s|\n", "POS ID", "POS NAME");
        System.out.println("+===============+==============================+");
        for (Postion postion : postions) {
            postion.hienThiTheoDong();
        }
        System.out.println("+===============+==============================+");
    }
    private void showDepartment(List<Department> departments) {
        System.out.println("DANH SÁCH DEPARTMENT");
        System.out.println("+===============+==============================+==========+");
        System.out.printf("|%-15s|%-30s|%-10s|\n","depID","Dep Name","Quantity Account");
        System.out.println("+===============+==============================+==========+");
        for (Department department : departments) {
            department.hienThiTheoDong();
        }
        System.out.println("+===============+==============================+==========+");

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
                default:System.err.println("Nhập sai nhập lại"); continue;
            }
        }
    }
}
