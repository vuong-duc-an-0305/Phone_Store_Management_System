package List;

import SubClass.DienThoai;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DsDienThoai {
    ArrayList<DienThoai> lst = new ArrayList<>();

    public void NhapDS(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng điện thoại: "); int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            DienThoai dienThoai = new DienThoai();
            dienThoai.Nhap();
            lst.add(dienThoai);
        }
    }

    public void XuatDS(){
        System.out.println("Danh sách điện thoại");
        System.out.printf("%-8s%-10s%-10s%-5s%-10s%-10s%n", "Mã ĐT","Tên","Hãng", "SL", "Giá SP", "Loại máy");
        System.out.println("===================================================");
        for (DienThoai dienThoai : lst){
            dienThoai.Xuat();
        }
    }

    public void TimKiem(){
        Scanner scanner = new Scanner(System.in);
        boolean Timthay = true;
        System.out.print("Mã điện thoại cần tìm kiếm: "); String sMaTK = scanner.nextLine();
        for (DienThoai dienThoai : lst ){
            if (dienThoai.getsMaDT().equals(sMaTK)) {
                System.out.printf("%-8s%-10s%-10s%-5s%-10s%-10s%n", "Mã ĐT","Tên","Hãng", "SL", "Giá SP", "Loại máy");
                System.out.println("===================================================");
                dienThoai.Xuat();
                Timthay = false;
            }
        }
        if (Timthay) System.out.println("Không tìm thấy mã điện thoại!!");
    }

    public void Xoa(){
        ArrayList<DienThoai> lst1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean Timthay = true;
        System.out.print("Mã điện thoại cần xóa: "); String sMaXoa = scanner.nextLine();
        for (DienThoai dienThoai : lst){
            if(sMaXoa.equals(dienThoai.getsMaDT())){
                lst1.add(dienThoai);
                Timthay = false;
            }
        }
        if (Timthay) System.out.println("Không tìm thấy mã điện thoại!!");
        else {
            lst.removeAll(lst1);
            System.out.println("Xóa thành công");
        }
    }
    public void CapNhat(){
        Scanner scanner = new Scanner(System.in);
        DienThoai dienThoai = new DienThoai();
        System.out.print("Mã điện thoại cập nhật: "); dienThoai.sMaDT = scanner.nextLine();
        int Luachon;
        boolean bTimthay = true;
        for (DienThoai dienThoai1 : lst){
            if(dienThoai.sMaDT.equals(dienThoai1.getsMaDT())){
                do{
                    System.out.println("1. Cập nhật tên điện thoại");
                    System.out.println("2. Cập nhật hãng");
                    System.out.println("3. Cập nhật số lượng trong kho");
                    System.out.println("4. Cập nhật giá sản phẩm");
                    System.out.println("5. Cập nhật loại máy");
                    System.out.println("0. Thoat");
                    System.out.print("lua chon : ");
                    Luachon = Integer.parseInt(scanner.nextLine());
                    switch (Luachon){

                        case 1:
                            System.out.print("Tên: "); dienThoai.sTenSanPham = scanner.nextLine();
                            dienThoai1.setsTenSanPham(dienThoai.sTenSanPham);
                            break;
                        case 2:
                            System.out.print("Hãng: "); dienThoai.sHangsx = scanner.nextLine();
                            dienThoai1.setsHangsx(dienThoai.sHangsx);
                            break;
                        case 3:
                            System.out.print("Số lượng trong kho: "); dienThoai.iSLtrongkho = scanner.nextInt();
                            dienThoai1.setiSLtrongkho(dienThoai.iSLtrongkho);
                            break;
                        case 4:
                            System.out.print("Giá sản phẩm: "); dienThoai.dGiaSanPham = scanner.nextDouble();
                            dienThoai1.setdGiaSanPham(dienThoai.dGiaSanPham);
                        case 5:
                            System.out.print("Loại máy: "); dienThoai.sLoaimay = scanner.nextLine();
                            dienThoai1.setsLoaimay(dienThoai.sLoaimay);
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");

                    }
                    bTimthay = false;
                }while (Luachon !=0);
            }
        }
        if (bTimthay) System.out.println("Không tìm thấy điện thoại!");
    }
    public void LuuFile(){
        try (FileOutputStream fos = new FileOutputStream("dsDT.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lst);
            System.out.println("Lưu danh sách điện thoại thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void DocFile() {
        try (FileInputStream fis = new FileInputStream("dsDT.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            lst = (ArrayList<DienThoai>) ois.readObject();
            System.out.println("Đọc danh sách điện thoại thành công!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void menu(){
        DsDienThoai dsDienThoai = new DsDienThoai();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập danh sách điện thoại");
            System.out.println("2. Xuất danh sách điện thoại");
            System.out.println("3. Tìm kiếm điện thoại");
            System.out.println("4. Xóa điện thoại");
            System.out.println("5. Cập nhật thông tin điện thoại");
            System.out.println("6. Lưu danh sách điện thoại vào file");
            System.out.println("7. Đọc danh sách điện thoại từ file");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    NhapDS();
                    break;
                case 2:
                    XuatDS();
                    break;
                case 3:
                    TimKiem();
                    break;
                case 4:
                    Xoa();
                    break;
                case 5:
                    CapNhat();
                    break;
                case 6:
                    LuuFile();
                    break;
                case 7:
                    DocFile();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }


}
