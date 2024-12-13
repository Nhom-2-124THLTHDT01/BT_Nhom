
package main;

public class VeVip extends Ve {
    private String dichVuThem;

    public VeVip(String hoTen, String SDT, ChuyenBay chuyenBay, String dichVuThem) {
        super(hoTen, SDT, chuyenBay);
        this.dichVuThem = dichVuThem;
    }

    public String getDichVuThem() {
        return dichVuThem;
    }
    
    @Override
    public double tinhGiaVe() {
        return getChuyenBay().getGiaVe() * 1.2; // Phụ thu 20%
    }

    @Override
    public String toString() {
        return "VeVip{" + super.toString() + ", Dich vu them: " + dichVuThem + ", Gia ve: " + tinhGiaVe() + "}";
    }
}