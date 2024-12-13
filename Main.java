package main;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        QuanLyChuyenBay quanLyChuyenBay = new QuanLyChuyenBay();
        QuanLyVe quanLyVe = new QuanLyVe();
        ChuyenBay cb1 = new ChuyenBay("CB001", "Vietnam Airlines", "Hanoi", "HCMC", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 150, 2000000);
        ChuyenBay cb2 = new ChuyenBay("CB002", "VietJet", "HCMC", "Phu Quoc", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), 180, 1500000);
        ChuyenBay cb3 = new ChuyenBay("CB003", "Bamboo Airways", "Da Nang", "Nha Trang", LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(4), 200, 2500000);
        ChuyenBay cb4 = new ChuyenBay("CB004", "Vietravel Airlines", "Hanoi", "Can Tho", LocalDateTime.now().plusHours(5), LocalDateTime.now().plusHours(7), 160, 2200000);

        quanLyChuyenBay.themChuyenBay(cb1);
        quanLyChuyenBay.themChuyenBay(cb2);
        quanLyChuyenBay.themChuyenBay(cb3);
        quanLyChuyenBay.themChuyenBay(cb4);

    
        
        
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Hien thi danh sach chuyen bay");
            System.out.println("2. Hien thi danh sach ve da dat");
            System.out.println("3. Tim kiem chuyen bay");
            System.out.println("4. Dat ve");
            System.out.println("5. Huy ve");
            System.out.println("6. Thoat");
            System.out.print("Chon mot lua chon: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Đọc dòng mới sau khi nhập số

            switch (choice) {
                case 1:
                    quanLyChuyenBay.hienThiDanhSachChuyenBay();
                    break;
                case 2:
                    if (quanLyVe.getDanhSachVe().isEmpty()) {
                        System.out.println("Chua co ve da dat.");
                    } else {
                        System.out.println("Danh sach ve da dat: ");
                        quanLyVe.hienThiDanhSachVe();
                    }
                    break;
                case 3:
                    System.out.print("Nhap ma chuyen bay can tim: ");
                    String maChuyenBay = scanner.nextLine();
                    quanLyChuyenBay.timChuyenBay(maChuyenBay);
                    break;
                case 4:
                        System.out.print("Nhap ten khach hang: ");
                        String hoTen = scanner.nextLine();
                        System.out.print("Nhap so dien thoai: ");
                        String SDT = scanner.nextLine();
                        System.out.print("Nhap ma chuyen bay de dat ve: ");
                        maChuyenBay = scanner.nextLine();

                        ChuyenBay chuyenBayDatVe = quanLyChuyenBay.timChuyenBay(maChuyenBay);

                        if (chuyenBayDatVe != null) {
                            System.out.print("Chon loai ve (1. Thuong, 2. Vip): ");
                            int loaiVe = scanner.nextInt();
                            scanner.nextLine(); // Loại bỏ ký tự xuống dòng

                            Ve veDat = null;
                            if (loaiVe == 1) {
                                veDat = new VeThuong(hoTen, SDT, chuyenBayDatVe);
                            } else if (loaiVe == 2) {
                                System.out.print("Nhap dich vu them cho ve Vip: ");
                                String dichVuThem = scanner.nextLine();
                                veDat = new VeVip(hoTen, SDT, chuyenBayDatVe, dichVuThem);
                            } else {
                                System.out.println("Loai ve khong hop le. Quay lai menu chinh.");
                                break;
                            }

                            System.out.println("Ban co muon xac nhan dat ve?");
                            System.out.println("1. Xac nhan dat ve");
                            System.out.println("2. Huy dat ve");
                            System.out.print("Chon mot lua chon: ");
                            int xacNhan = scanner.nextInt();
                            scanner.nextLine(); // Loại bỏ ký tự xuống dòng

                            if (xacNhan == 1) {
                                // Sinh mã vé tự động
                                String maVe = "V" + String.format("%04d", quanLyVe.getDanhSachVe().size() + 1);
                                veDat.setMaVe(maVe); // Gán mã vé cho vé

                                quanLyVe.themVe(veDat); // Thêm vé vào danh sách vé đã đặt
                                System.out.println("Dat ve thanh cong!");
                                System.out.println("Thong tin ve da dat:");
                                System.out.println(veDat); // Hiển thị thông tin vé
                            } else if (xacNhan == 2) {
                                System.out.println("Dat ve da bi huy. Quay lai menu chinh.");
                            } else {
                                System.out.println("Lua chon khong hop le. Quay lai menu chinh.");
                            }
                        } else {
                            System.out.println("Chuyen bay khong ton tai!");
                        }
                        break;        
                case 5:
                    System.out.print("Nhap ma ve can huy: ");
                    String maVeString = scanner.nextLine(); // Đọc mã vé dưới dạng chuỗi
                    boolean veHuyThanhCong = quanLyVe.xoaVe(maVeString); // Truyền vào chuỗi
                    if (veHuyThanhCong) {
                        System.out.println("Huy ve thanh cong!");
                    } else {
                        System.out.println("Ma ve khong ton tai.");
                    }
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long thu lai.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
