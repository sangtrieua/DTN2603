package entity;

public class TapChi extends TaiLieu{
    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(int maTaiLieu, int soBanPH, String tenNXB, int soPhatHanh, int thangPhatHanh) {
        super(maTaiLieu, soBanPH, tenNXB);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public TapChi() {
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        if (thangPhatHanh>=1 && thangPhatHanh<=12)
        this.thangPhatHanh = thangPhatHanh;
        else System.out.println("Tháng không hợp lệ!!!");
    }

    @Override
    public void hienthi() {
        super.hienthi();
        System.out.printf("%-30s|%-20s|\n","Số Phát hành: "+this.getSoPhatHanh(),"Tháng Phát hành: "+this.getThangPhatHanh());
    }
}
