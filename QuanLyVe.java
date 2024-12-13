package main;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class QuanLyVe implements IQuanLyVe {
    private ArrayList<Ve> danhSachVe = new ArrayList<>();
    
    public void hienThiDanhSachVe() {
        for (Ve ve : danhSachVe) {
            System.out.println(ve);
        }
    }
    public ArrayList<Ve> getDanhSachVe() {
        return danhSachVe;
    }
    public void themVe(Ve ve) {
        danhSachVe.add(ve);
    }

    public boolean xoaVe(String maVe) {
        for (Ve ve : danhSachVe) {
            if (ve.getMaVe().equals(maVe)) {
                danhSachVe.remove(ve);
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy vé để xóa
    }

    @Override
    public void docFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Giả sử định dạng file là: mã vé, tên khách hàng, số điện thoại, mã chuyến bay, loại vé, dịch vụ thêm
                String[] data = line.split(",");
                ChuyenBay chuyenBay = new ChuyenBay(data[3], data[0], data[0], data[0], 
                    LocalDateTime.now(), LocalDateTime.now(), 100, 100000); // Giả sử đã có phương thức để tìm chuyến bay theo mã

                Ve ve;
                if (data[4].equals("Thuong")) {
                    ve = new VeThuong(data[1], data[2], chuyenBay);
                } else {
                    ve = new VeVip(data[1], data[2], chuyenBay, data[5]);
                }
                danhSachVe.add(ve);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ghiFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (Ve ve : danhSachVe) {
                // Ghi thông tin vé vào file (mã vé, tên khách, SDT, mã chuyến bay, loại vé, dịch vụ thêm)
                bw.write(ve.getMaVe() + "," + ve.getHoTen() + "," + ve.getSDT() + ","
                        + ve.getChuyenBay().getMaChuyenBay() + "," + ve.getClass().getSimpleName()
                        + (ve instanceof VeVip ? "," + ((VeVip) ve).getDichVuThem() : ""));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}