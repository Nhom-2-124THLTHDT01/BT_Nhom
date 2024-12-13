

package QuanLyVe;

import java.time.LocalDate;

public class VeThuong extends DatVe {

    public VeThuong(String maDatVe, ChuyenBay chuyenBay, LocalDate ngayDat, boolean trangThaiThanhToan) {
        super(maDatVe, chuyenBay, ngayDat, trangThaiThanhToan);
    }

    @Override
    public double tinhGiaVe() {
        return chuyenBay.getGiaVe();
    }
    
    @Override
    public String toString() {
        return "VeThuong : " +
                "maDatVe='" + maDatVe + '\'' +
                ", chuyenBay=" + chuyenBay.getMaChuyenBay() +
                ", ngayDat=" + ngayDat +
                ", trangThaiThanhToan=" + (trangThaiThanhToan ? "Da thanh toan" : "Chua thanh toan") +
                ", giaVe=" + tinhGiaVe();
    }
}

