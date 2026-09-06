package frontend;

import backend.IQLTV;
import backend.QLTV;

import java.text.ParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
Main m = new Main();
m.menu();
    }
    public Main() {}
    public void menu() throws ParseException {
        IQLTV iqltv=new QLTV();
        while (true) {
            System.out.println("====Mời bạn chọn chức năng====");
            System.out.println("1.Thêm mới tài liêu: Sách, tạp chí, báo.");
            System.out.println("2.Xoá tài liệu theo mã tHiện thị thông tin về tài liệu.");
            System.out.println("3.Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.");
            System.out.println("4.hiển thị ds");
            System.out.println("5.Thoát khỏi chương trình.");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    iqltv.themMoiTaiLieu();
                    break;
                case "2":
                    iqltv.xoaTaiLieuTheoMa();
                    break;
                case "3":
                    iqltv.TimKiemTheoLoai();
                    break;
                case "4":
                    iqltv.hienThiThongTin();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Nhập sai, nhập lại");
                break;
            }
        }
    }
}