
package main;

public abstract class Ve {
    private static int demMaVe = 0; // Dùng để tạo mã vé tự động
    private String maVe;
    private String hoTen;
    private String SDT;
    private ChuyenBay chuyenBay;

    public Ve(String hoTen, String SDT, ChuyenBay chuyenBay) {
        this.maVe = "V" + String.format("%04d", ++demMaVe);
        this.hoTen = hoTen;
        this.SDT = SDT;
        this.chuyenBay = chuyenBay;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }
    
    public String getMaVe() {
        return maVe;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getSDT() {
        return SDT;
    }
    
    public ChuyenBay getChuyenBay() {
        return chuyenBay;
    }

    @Override
    public String toString() {
        // Sử dụng maVe trực tiếp mà không cần định dạng lại
        return "Ma ve: " + maVe + ", Ho ten: " + hoTen + ", SDT: " + SDT + ", Chuyen bay: [" + chuyenBay + "]";
    }

    public abstract double tinhGiaVe();
}