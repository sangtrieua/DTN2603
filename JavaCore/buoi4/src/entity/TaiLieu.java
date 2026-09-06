package entity;

public class TaiLieu {
    private int maTaiLieu;
    private String tenNXB;
    private int soBanPH;

    public TaiLieu(int maTaiLieu, int soBanPH, String tenNXB) {
        this.maTaiLieu = maTaiLieu;
        this.soBanPH = soBanPH;
        this.tenNXB = tenNXB;
    }


    public TaiLieu() {
    }

    public int getMaTaiLieu() {
        return maTaiLieu;
    }


    public void setMaTaiLieu(int maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public int getSoBanPH() {
        return soBanPH;
    }

    public void setSoBanPH(int soBanPH) {
        this.soBanPH = soBanPH;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }
    public void hienthi(){
        System.out.printf("|%-10s|%-10s|%-20s|%-20s|",this.getClass().getSimpleName(),this.getMaTaiLieu(),this.getSoBanPH(),this.getTenNXB());
    }
}
