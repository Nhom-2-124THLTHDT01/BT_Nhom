package QuanLyVe;


import java.time.LocalDate;

public abstract class DatVe {
    protected String maDatVe; 
    protected ChuyenBay chuyenBay; 
    protected LocalDate ngayDat; 
    protected boolean trangThaiThanhToan;

    public DatVe(String maDatVe, ChuyenBay chuyenBay, LocalDate ngayDat, boolean trangThaiThanhToan) {
        this.maDatVe = maDatVe;
        this.chuyenBay = chuyenBay;
        this.ngayDat = ngayDat;
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public String getMaDatVe() {
        return maDatVe;
    }

    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    public LocalDate getNgayDat() {
        return ngayDat;
    }
    
    public abstract double tinhGiaVe();
    public abstract String toString();
}
