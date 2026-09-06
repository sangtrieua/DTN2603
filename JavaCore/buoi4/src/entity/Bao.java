package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bao extends TaiLieu {
    private Date ngayPhatHanh;

    public Bao(int maTaiLieu, int soBanPH, String tenNXB, Date ngayPhatHanh) {
        super(maTaiLieu, soBanPH, tenNXB);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao() {
    }

    public String getNgayPhatHanh() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.ngayPhatHanh);
    }

    public void setNgayPhatHanh(String ngayPhatHanh) throws ParseException {

        this.ngayPhatHanh = new SimpleDateFormat("dd/mm/yy").parse(ngayPhatHanh);
    }

    @Override
    public void hienthi() {
        super.hienthi();
        System.out.printf("%-30s|%-20s|\n","Ngày xuất bản: "+this.getNgayPhatHanh()," ");

    }
}
