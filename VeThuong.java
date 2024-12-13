
package main;

public class VeThuong extends Ve {

    public VeThuong(String hoTen, String SDT, ChuyenBay chuyenBay) {
        super(hoTen, SDT, chuyenBay);
    }

    @Override
    public double tinhGiaVe() {
        return getChuyenBay().getGiaVe();
    }

    @Override
    public String toString() {
        return "VeThuong{" + super.toString() + ", Gia ve: " + tinhGiaVe() + "}";
    }
}
