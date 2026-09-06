package entity;

public class Sach extends TaiLieu {
    private String tenTacGia;
    private int soTrang;

    public Sach(int maTaiLieu, int soBanPH, String tenNXB, String tenTacGia, int soTrang) {
        super(maTaiLieu, soBanPH, tenNXB);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }



    public Sach() {
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    @Override
    public void hienthi() {
        super.hienthi();
        System.out.printf("%-30s|%-20s|\n","Tên tác gỉả: "+this.getTenTacGia(),"Số trang: "+this.getSoTrang());
    }
}
