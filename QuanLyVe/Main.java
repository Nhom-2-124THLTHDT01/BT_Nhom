
package QuanLyVe;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyChuyenBay quanLyChuyenBay = new QuanLyChuyenBay();
        QuanLyDatVe quanLyDatVe = new QuanLyDatVe();
        Scanner scanner = new Scanner(System.in);
        quanLyChuyenBay.Docfile();


        int luaChon;
        do {
            System.out.println("\n--- Quan Ly Ve May Bay ---");
            System.out.println("1. Danh sach chuyen bay.");
            System.out.println("2. Tim kiem chuyen bay");
            System.out.println("3. Dat ve");
            System.out.println("4. Huy ve");
            System.out.println("5. Hien thi danh sach ve da dat");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1: 
                    System.out.println("Danh sach chuyen bay : ");
                    quanLyChuyenBay.hienThiDanhSachCB();
                    break;
                case 2:
                    System.out.print("Nhap diem khoi hanh: ");
                    String kh = scanner.nextLine();
                    System.out.print("Nhap diem den: ");
                    String den = scanner.nextLine();
                    if (quanLyChuyenBay.timKiemChuyenBay(kh, den).isEmpty()) {
                        System.out.println("Hien chua co chuyen bay.");
                    }
                    else
                        quanLyChuyenBay.timKiemChuyenBay(kh, den).forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Nhap ma chuyen bay: ");
                    String maCB = scanner.nextLine();
                    ChuyenBay cbDat = quanLyChuyenBay.layChuyenBayTheoMa(maCB);
                    if (cbDat == null) {
                        System.out.println("Khong tim thay chuyen bay.");
                        break;
                    }

                    System.out.println("Chon loai ve:");
                    System.out.println("1. Ve Thuong");
                    System.out.println("2. Ve VIP");
                    int loaiVe = scanner.nextInt();
                    scanner.nextLine();

                    DatVe datVe;
                    int dem = 1;
                    if (loaiVe == 1) {
                        datVe = new VeThuong("VT" + String.format("%04d", dem++), cbDat, LocalDate.now(), true);
                    } 
                    else if (loaiVe == 2) {
                        System.out.print("Nhap dich vu them: ");
                        String dichVuThem = scanner.nextLine();
                        datVe = new VeVip("VV" + (int) (Math.random() * 1000), cbDat,  LocalDate.now(), true, dichVuThem);
                    } 
                    else {
                        System.out.println("Lua chon khong hop le.");
                        break;
                    }
                    quanLyDatVe.themDatVe(datVe);
                    quanLyChuyenBay.capNhatSoGhe(maCB);
                    break;

                case 4:
                    System.out.print("Nhap ma dat ve muon huy: ");
                    String maDatVe = scanner.nextLine();
                    quanLyDatVe.huyDatVe(maDatVe);
                    break;

                case 5:
                    System.out.println("Danh sach ve da dat:");
                    quanLyDatVe.hienThiDanhSachDatVe();
                    break;

                case 0:
                    System.out.println("Thoat.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (luaChon != 0);

        scanner.close();
    }
}

