
package QuanLyVe;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class QuanLyChuyenBay {
    private List<ChuyenBay> danhSachChuyenBay;
    
    
    public QuanLyChuyenBay() {
        danhSachChuyenBay = new ArrayList<>();
    }

    public void Docfile() {
        try {
            Path path = Path.of("D:\\VSCODE\\Java\\BT_Nhom\\BT_Nhom\\src\\main\\java\\QuanLyVe\\DSChuyenBay.txt");
            List<String> dscb = Files.readAllLines(path);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
            for (String data_cb : dscb) {
                String[] data = data_cb.split(", ");
                String maChuyenBay = data[0];
                String diemDi = data[1];
                String diemDen = data[2];
                double giaVe = Double.parseDouble(data[3]);
                int soGhe = Integer.parseInt(data[4]);
                LocalDateTime gioDi = LocalDateTime.parse(data[5], formatter);
                LocalDateTime gioDen = LocalDateTime.parse(data[6], formatter); 

                ChuyenBay cb = new ChuyenBay(maChuyenBay, diemDi, diemDen, giaVe, soGhe, gioDi, gioDen);
                danhSachChuyenBay.add(cb);
            }
            System.out.println("Danh sach chuyen bay:");
            for (ChuyenBay cb : danhSachChuyenBay) {
                System.out.println(cb);
            }
        } 
        catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }
    }

    
    public void hienThiDanhSachCB(){
        if (danhSachChuyenBay.isEmpty()) {
            System.out.println("Hien chua co chuyen bay.");
        } else {
            for (ChuyenBay cb : danhSachChuyenBay) {
                System.out.println(cb); 
            }
        }
    }
    
    public void themChuyenBay(ChuyenBay chuyenBay) {
        danhSachChuyenBay.add(chuyenBay);
        System.out.println("Them chuyen bay thanh cong: " + chuyenBay.getMaChuyenBay());
    }

    private String chuyenChuoi(String input) {
        if (input == null) {
            return "";
        }
        return input.trim().replaceAll("\\s+", " ").toLowerCase();
    }
    
    public List<ChuyenBay> timKiemChuyenBay(String diemKhoiHanh, String diemDen) {
        List<ChuyenBay> ketQua = new ArrayList<>();
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (chuyenChuoi(cb.getDiemKhoiHanh()).equals(chuyenChuoi(diemKhoiHanh)) &&
                chuyenChuoi(cb.getDiemDen()).equals(chuyenChuoi(diemDen))) {
                ketQua.add(cb);
            }
        }
    return ketQua;
    }

    public ChuyenBay layChuyenBayTheoMa(String maChuyenBay) {
        for (ChuyenBay cb : danhSachChuyenBay) {
            if (cb.getMaChuyenBay().equals(maChuyenBay)) {
                return cb;
            }
        }
        
        return null;
    }

    public boolean capNhatSoGhe(String maChuyenBay) {
        ChuyenBay chuyenBay = layChuyenBayTheoMa(maChuyenBay);
        if (chuyenBay != null && chuyenBay.getSoGheTrong() >= 1) {
            chuyenBay.setSoGheTrong(chuyenBay.getSoGheTrong() - 1);
            return true;
        }
        return false;
    }
}

