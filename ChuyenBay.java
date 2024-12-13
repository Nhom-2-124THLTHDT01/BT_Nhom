
package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChuyenBay {
    private String maChuyenBay;
    private String tenHangBay;
    private String noiDi;
    private String noiDen;
    private LocalDateTime thoiGianKhoiHanh;
    private LocalDateTime thoiGianDen;
    private int tongSoGhe;
    private int soGheTrong;
    private double giaVe;

    public ChuyenBay(String maChuyenBay, String tenHangBay, String noiDi, String noiDen, LocalDateTime thoiGianKhoiHanh, LocalDateTime thoiGianDen, int tongSoGhe, double giaVe) {
        this.maChuyenBay = maChuyenBay;
        this.tenHangBay = tenHangBay;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.thoiGianDen = thoiGianDen;
        this.tongSoGhe = tongSoGhe;
        this.giaVe = giaVe;
    }

    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public String getTenHangBay() {
        return tenHangBay;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public LocalDateTime getThoiGianDen() {
        return thoiGianDen;
    }

    public int getTongSoGhe() {
        return tongSoGhe;
    }

    public LocalDateTime getThoiGianKhoiHanh() {
        return thoiGianKhoiHanh;
    }
    
    public double getGiaVe() {
        return giaVe;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Ma: " + maChuyenBay + ", Hang: " + tenHangBay + ", Noi di: " + noiDi + ", Noi den: " + noiDen + ", Khoi hanh: " + thoiGianKhoiHanh.format(formatter) + ", Den noi: " + thoiGianDen.format(formatter) + ", Gia: " + giaVe;
    }
}
