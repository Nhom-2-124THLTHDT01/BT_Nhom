package QuanLyVe;

import java.util.ArrayList;
import java.util.List;

public class QuanLyDatVe {
    private List<DatVe> danhSachDatVe;

    public QuanLyDatVe() {
        danhSachDatVe = new ArrayList<>();
    }

    public void themDatVe(DatVe datVe) {
        danhSachDatVe.add(datVe);
        
        System.out.println("Dat ve thanh cong. Ma dat ve: " + datVe.getMaDatVe());
    }

    public void hienThiDanhSachDatVe() {
        if (danhSachDatVe.isEmpty()) {
            System.out.println("Chua co ve nao duoc dat.");
        } else {
            for (DatVe ve : danhSachDatVe) {
                System.out.println(ve); 
            }
        }
    }

    public boolean huyDatVe(String maDatVe) {
        for (DatVe ve : danhSachDatVe) {
            if (ve.getMaDatVe().equals(maDatVe)) {
                danhSachDatVe.remove(ve);
                System.out.println("Huy dat ve thanh cong: " + maDatVe);
                return true;
            }
        }
        System.out.println("Khong tim thay ma dat ve: " + maDatVe);
        return false;
    }
}
