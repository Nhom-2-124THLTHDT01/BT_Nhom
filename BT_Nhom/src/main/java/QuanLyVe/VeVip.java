package QuanLyVe;

import java.time.LocalDate;

public class VeVip extends DatVe {
    private String dichVuThem;

    public VeVip(String maDatVe, ChuyenBay chuyenBay, LocalDate ngayDat, boolean trangThaiThanhToan, String dichVuThem) {
        super(maDatVe, chuyenBay, ngayDat, trangThaiThanhToan);
        this.dichVuThem = dichVuThem;
    }
    
    public String getDichVuThem() {
        return dichVuThem;
    }

    public void setDichVuThem(String dichVuThem) {
        this.dichVuThem = dichVuThem;
    }
    
    @Override
    public double tinhGiaVe() {
        return chuyenBay.getGiaVe() + 200000; 
    }

    @Override
    public String toString() {
        return "VeVip :" +
                "maDatVe='" + maDatVe + '\'' +
                ", chuyenBay=" + chuyenBay.getMaChuyenBay() +
                ", ngayDat=" + ngayDat +
                ", trangThaiThanhToan=" + (trangThaiThanhToan ? "Da thanh toan" : "Chua thanh toan") +
                ", giaVe=" + tinhGiaVe() +
                ", dichVuThem='" + dichVuThem + '\'';
    }

    
}

