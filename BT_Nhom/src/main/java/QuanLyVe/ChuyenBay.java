
package QuanLyVe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChuyenBay {
    private String maChuyenBay; 
    private String diemKhoiHanh; 
    private String diemDen;  
    private double giaVe; 
    private int tongSoGhe; 
    private int soGheTrong; 
    private LocalDateTime thoiGianKhoiHanh;
    private LocalDateTime thoiGianDen;

    public ChuyenBay(String maChuyenBay, String diemKhoiHanh, String diemDen, double giaVe, int tongSoGhe, LocalDateTime thoiGianKhoiHanh, LocalDateTime thoiGianDen) {
        this.maChuyenBay = maChuyenBay;
        this.diemKhoiHanh = diemKhoiHanh;
        this.diemDen = diemDen;
        this.giaVe = giaVe;
        this.tongSoGhe = tongSoGhe;
        this.soGheTrong = tongSoGhe;
        this.thoiGianKhoiHanh = thoiGianKhoiHanh;
        this.thoiGianDen = thoiGianDen;
    }
    
    public String getMaChuyenBay() {
        return maChuyenBay;
    }

    public void setMaChuyenBay(String maChuyenBay) {
        this.maChuyenBay = maChuyenBay;
    }

    public String getDiemKhoiHanh() {
        return diemKhoiHanh;
    }

    public void setDiemKhoiHanh(String diemKhoiHanh) {
        this.diemKhoiHanh = diemKhoiHanh;
    }

    public String getDiemDen() {
        return diemDen;
    }

    public void setDiemDen(String diemDen) {
        this.diemDen = diemDen;
    }


    public double getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(double giaVe) {
        this.giaVe = giaVe;
    }

    public int getTongSoGhe() {
        return tongSoGhe;
    }

    public void setTongSoGhe(int tongSoGhe) {
        this.tongSoGhe = tongSoGhe;
    }

    public int getSoGheTrong() {
        return soGheTrong;
    }

    public void setSoGheTrong(int soGheTrong) {
        this.soGheTrong = soGheTrong;
    }

    @Override
      public String toString() {
          DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
          return "ChuyenBay : " +
                  "Ma Chuyen Bay = " + maChuyenBay  +
                  ", Diem Khoi Hanh = " + diemKhoiHanh +
                  ", Diem Den = " + diemDen +
                  ", Gio Khoi Hanh = " + thoiGianKhoiHanh.format(timeFormatter) +
                  ", Gio Den = " + thoiGianDen.format(timeFormatter) +
                  ", Gia Ve = " + giaVe +
                  ", So Ghe = " + tongSoGhe +
                  ", So ghe trong = " + soGheTrong ;
      }
}

