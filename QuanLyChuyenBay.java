package main;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class QuanLyChuyenBay implements IQuanLyChuyenBay {
    private ArrayList<ChuyenBay> danhSachChuyenBay = new ArrayList<>();

    public void hienThiDanhSachChuyenBay() {
        for (ChuyenBay cb : danhSachChuyenBay) {
            System.out.println(cb);
        }
    }

    public void themChuyenBay(ChuyenBay cb) {
        danhSachChuyenBay.add(cb);
    }

    public void xoaChuyenBay(String maChuyenBay) {
        danhSachChuyenBay.removeIf(cb -> cb.getMaChuyenBay().equals(maChuyenBay));
    }
    public ChuyenBay timChuyenBay(String maChuyenBay) {
    for (ChuyenBay cb : danhSachChuyenBay) {
        if (cb.getMaChuyenBay().equals(maChuyenBay)) {
            System.out.println(cb);
            return cb;
        }
    }
    System.out.println("Khong tim thay chuyen bay " + maChuyenBay);
    return null;
}

    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            // Định dạng thời gian khi đọc
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            while ((line = br.readLine()) != null) {
                // Giả sử định dạng file là: mã chuyến bay, tên hãng, điểm đi, điểm đến, giờ đi, giờ đến, số ghế, giá vé
                String[] data = line.split(",");

                // Đọc thời gian với định dạng custom
                LocalDateTime thoiGianKhoiHanh = LocalDateTime.parse(data[4], formatter);
                LocalDateTime thoiGianDen = LocalDateTime.parse(data[5], formatter);

                // Tạo ChuyenBay từ file và thêm vào danh sách
                ChuyenBay chuyenBay = new ChuyenBay(data[0], data[1], data[2], data[3], thoiGianKhoiHanh, thoiGianDen,
                        Integer.parseInt(data[6]), Double.parseDouble(data[7]));
                danhSachChuyenBay.add(chuyenBay);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            for (ChuyenBay chuyenBay : danhSachChuyenBay) {
                // Ghi thông tin chuyến bay vào file với định dạng mong muốn
                bw.write(chuyenBay.getMaChuyenBay() + "," + chuyenBay.getTenHangBay() + ","
                        + chuyenBay.getNoiDi() + "," + chuyenBay.getNoiDen() + ","
                        + chuyenBay.getThoiGianKhoiHanh().format(formatter) + ","
                        + chuyenBay.getThoiGianDen().format(formatter) + ","
                        + chuyenBay.getTongSoGhe() + "," + chuyenBay.getGiaVe());
                bw.newLine(); // Thêm dòng mới
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
