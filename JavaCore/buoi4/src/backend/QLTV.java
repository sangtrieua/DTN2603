package backend;

import entity.Bao;
import entity.Sach;
import entity.TaiLieu;
import entity.TapChi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class QLTV implements IQLTV {
    private List<TaiLieu>  taiLieus=new ArrayList<>() ;
    private Scanner sc=new Scanner(System.in);



    public QLTV() throws ParseException {
        TaiLieu sach=new Sach(20,234,"Nguyễn Văn Sách","No Name",233);
        TaiLieu bao=new Bao(21,332,"Nguyễn Văn Báo",new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2026"));
        TaiLieu tapChi=new TapChi(22,123,"Nguyễn Tạp Chí",234,2);
        taiLieus.add(sach);
        taiLieus.add(bao);
        taiLieus.add(tapChi);
    }
    private boolean kiemTraMaTaiLieu(int maTaiLieu){
        for(TaiLieu t:taiLieus){
            if(t.getMaTaiLieu()==maTaiLieu){
                return true;
            }
        }
        return false;
    }
    @Override
    public void themMoiTaiLieu() {
        int maTaiLieu;
        int soBanPH;
        String tenNXB;
        while (true) {
            System.out.println("Nhập Mã Tài liệu: ");
            if (sc.hasNextInt()) {
                maTaiLieu = sc.nextInt();
                sc.nextLine();
                if (kiemTraMaTaiLieu(maTaiLieu)) {
                    System.out.println("Mã Tài liệu này đã tồn tại trong ds!!!! : ");
                    continue;
                }
                break;
            }
            else {
                System.out.println("Nhập sai định dạng ");
                sc.nextLine();
            }
        }
        while (true) {
            System.out.println("Nhập số bản phát hành: ");
            if (sc.hasNextInt()) {
                soBanPH = sc.nextInt();
                sc.nextLine();
                if(soBanPH<0){
                    System.out.println("Hãy nhập số nguyên dương!!!!");
                    continue;
                }
                break;
            } else {
                System.out.println("Nhập sai định dạng ");
                sc.nextLine();
            }
        }
            System.out.println("Nhập tên NXB: ");
            tenNXB = sc.nextLine();
            while (true) {
                System.out.println("Nhập Loại tài liệu :    1:Sách      2:Báo       3:Tạp chí ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        String tenTG;
                        int soTrang;
                        System.out.println("Bạn đang thêm loại SÁCH!!!");
                        System.out.println("Nhập tên Tác giả: ");
                        tenTG = sc.nextLine();
                        while (true) {
                            System.out.println("Nhập số Trang: ");
                            if (sc.hasNextInt()) {
                                soTrang = sc.nextInt();
                                sc.nextLine();
                                if (soTrang < 0) {
                                    System.out.println("Hãy nhập số nguyên dương!!!!");
                                    continue;
                                }
                                break;
                            } else {
                                System.out.println("Nhập sai định dạng ");
                                sc.nextLine();
                            }
                        }
                        TaiLieu sach =new Sach(maTaiLieu,soBanPH,tenNXB,tenTG,soTrang);
                        taiLieus.add(sach);
                        return;
                    case "2":
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
                        sdf.setLenient(false);

                        Date ngayPhatHanh = null;

                        System.out.println("Bạn đang thêm loại BÁO!!!");

                        while (true) {
                            System.out.print("Nhập ngày phát hành (dd/MM/yy): ");
                            String input = sc.nextLine();

                            try {
                                ngayPhatHanh = sdf.parse(input);
                                break; // Nhập đúng thì thoát vòng lặp
                            } catch (ParseException e) {
                                System.out.println("Ngày không hợp lệ! Vui lòng nhập đúng dạng dd/MM/yy.");
                            }
                        }

                        TaiLieu bao = new Bao(maTaiLieu, soBanPH, tenNXB, ngayPhatHanh);
                        taiLieus.add(bao);
                        return;
                    case "3":
                        int soPH;
                        int thangPH;
                        while (true) {
                            System.out.println("Nhập số Phát hành: ");
                            if (sc.hasNextInt()) {
                                soPH = sc.nextInt();
                                sc.nextLine();
                                if (soPH < 0) {
                                    System.out.println("Hãy nhập số nguyên dương!!!!");
                                    continue;
                                }
                                break;
                            } else {
                                System.out.println("Nhập sai định dạng ");
                                sc.nextLine();
                            }
                        }
                        while (true) {
                            System.out.println("Nhập tháng Phát hành: ");
                            if (sc.hasNextInt()) {
                                thangPH = sc.nextInt();
                                sc.nextLine();
                                if (thangPH <1 || thangPH>12) {
                                    System.out.println("Hãy tháng 1 -->12 !!!!");
                                    continue;
                                }
                                break;
                            } else {
                                System.out.println("Nhập sai định dạng ");
                                sc.nextLine();
                            }
                        }
                        TaiLieu tapChi=new TapChi(soPH,thangPH,tenNXB,soPH,thangPH);
                        taiLieus.add(tapChi);
                        return;
                    default:
                        System.out.println("Chỉ nhập 1 2 3 !!!!!!!!!");
                        break;
                }
            }

    }


    @Override
    public void xoaTaiLieuTheoMa() {
        while (true) {
            System.out.println("Nhâp mã tài liệu:");
            int maTaiLieu;
            if (sc.hasNextInt()) {
                maTaiLieu = sc.nextInt();
                sc.nextLine();
                System.out.println((taiLieus.removeIf(taiLieu -> taiLieu.getMaTaiLieu() == maTaiLieu)) ? "xóa thành công" : "Xóa Không Thành công!!!");
                break;
            } else {System.out.println("Nhập sai hãy nhập 1 số nguyên");sc.nextLine();}
        }
    }


    public static void main(String[] args) throws ParseException {
        QLTV qltv=new QLTV();
        qltv.hienThiThongTin();
//        qltv.TimKiemTheoLoai();
//        qltv.xoaTaiLieuTheoMa();
        qltv.themMoiTaiLieu();
        qltv.hienThiThongTin();
    }
    @Override
    public void hienThiThongTin() {
        System.out.println("+==========+==========+====================+====================+==============================+====================+");
        System.out.printf("|%-10s|%-10s|%-20s|%-20s|%-30s|%-20s|\n","Loại","Mã","Số bản phát hành","Tên NXB",""," ");
        for (TaiLieu taiLieu : taiLieus) {
           taiLieu.hienthi();
        }
        System.out.println("+==========+==========+====================+====================+==============================+====================+");
    }

    @Override
    public void TimKiemTheoLoai() {
        while (true) {
        System.out.println("Nhập loại tài liệu tìm: 1: Sách      2: Báo        3: Tap Chi");
        String luaChon=sc.nextLine();
        switch (luaChon) {
            case "1":
                System.out.println("Danh sách SÁCH: ");
                System.out.println("+==========+==========+====================+====================+==============================+====================+");
                System.out.printf("|%-10s|%-10s|%-20s|%-20s|%-30s|%-20s|\n","Loại","Mã","Số bản phát hành","Tên NXB",""," ");
                for (TaiLieu taiLieu : taiLieus) {
                if (taiLieu.getClass().equals(Sach.class)) {

                    taiLieu.hienthi();
                    System.out.println("+==========+==========+====================+====================+==============================+====================+");
                }

                return;
            }
            case "2":
                System.out.println("Danh sách BÁO: ");
                System.out.println("+==========+==========+====================+====================+==============================+====================+");
                System.out.printf("|%-10s|%-10s|%-20s|%-20s|%-30s|%-20s|\n","Loại","Mã","Số bản phát hành","Tên NXB",""," ");
                for (TaiLieu taiLieu : taiLieus) {
                    if (taiLieu.getClass().equals(Bao.class)) {

                        taiLieu.hienthi();
                        System.out.println("+==========+==========+====================+====================+==============================+====================+");
                    }
                }
                return;
            case "3":
                System.out.println("Danh sách TẠP CHÍ: ");
                System.out.println("+==========+==========+====================+====================+==============================+====================+");
                System.out.printf("|%-10s|%-10s|%-20s|%-20s|%-30s|%-20s|\n","Loại","Mã","Số bản phát hành","Tên NXB",""," ");
                for (TaiLieu taiLieu : taiLieus) {

                    if (taiLieu.getClass().equals(TapChi.class)) {

                        taiLieu.hienthi();
                        System.out.println("+==========+==========+====================+====================+==============================+====================+");
                    }
                }
                return;
            default:
                System.out.println("chọn sai chọn lại!!!!");
                break;
        }}
    }
}
