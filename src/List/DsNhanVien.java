package List;
import SubClass.NhanVien;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DsNhanVien {
    ArrayList<NhanVien> lst = new ArrayList<>();

    public void NhapDS(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số lượng nhân viên: ");
        int iSlnv = scanner.nextInt();
        for (int i = 0; i < iSlnv; i++) {
            System.out.println("======== Nhân viên " + i +" =========");
            NhanVien nhanVien = new NhanVien();
            nhanVien.Nhap();
            lst.add(nhanVien);
        }
    }

    public void XuatDS(){
        System.out.println("Danh sách nhân viên");
        System.out.println("=========================Danh sách nhân viên=======================");
        System.out.printf("%-10s%-10s%-5s%-15s%-15s%-5s%-10s%n", "Mã NV","Họ tên", "GT", "SĐT", "Email","HSL", "Lương");
        for (NhanVien nhanVien : lst){
            nhanVien.Xuat();
        }
    }

    public void Timkiem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã NV cần tìm: ");
        String sMatk = scanner.nextLine();
        boolean bTimthay = true;
        for (NhanVien nhanVien : lst){
            if (sMatk.equals(nhanVien.getsManv())) {
                nhanVien.Xuat();
                bTimthay = false;
            }
        }
        if (bTimthay) System.out.println("Không tìm thấy nhân viên!!");
    }

    public void Xoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã NV muốn xóa: ");
        String sManv_xoa = scanner.nextLine();
        ArrayList<NhanVien> temp = new ArrayList<>();
        boolean bTimthay = true;
        for (NhanVien nhanVien : lst){
            if(nhanVien.sManv.equals(sManv_xoa)){
                temp.add(nhanVien);
                bTimthay = false;
            }
        }
        if (bTimthay) System.out.println("Không tìm thấy nhân viên!!");
        else {
            lst.removeAll(temp);
            System.out.println("Xóa nhân viên thành công!");
        }
    }

    public void CapNhat(){
        Scanner scanner = new Scanner(System.in);
        NhanVien nhanVien = new NhanVien();
        System.out.print("Mã nhân viên cập nhật: "); nhanVien.sManv = scanner.nextLine();
        int Luachon;
        boolean bTimthay = true;
        for (NhanVien nhanVien1 : lst){
            if(nhanVien.sManv.equals(nhanVien1.getsManv())){
                do{
                    System.out.println("1. Cập nhật tên nhân viên");
                    System.out.println("2. Cập nhật SĐT");
                    System.out.println("4. Cập nhật giới tính");
                    System.out.println("5. Cập nhật email");
                    System.out.println("0. Thoat");
                    System.out.print("lua chon : ");
                    Luachon = Integer.parseInt(scanner.nextLine());
                    switch (Luachon){

                        case 1:
                            System.out.print("Tên: "); nhanVien.sHoten = scanner.nextLine();
                            nhanVien1.setsHoten(nhanVien.sHoten);
                            break;
                        case 2:
                            System.out.print("SĐT: "); nhanVien.sSDT = scanner.nextLine();
                            nhanVien1.setsSDT(nhanVien.sSDT);
                            break;
                        case 3:
                            System.out.print("Giới tính: "); nhanVien.bGioitinh = scanner.nextLine().equals("Nam");
                            nhanVien1.setbGioitinh(nhanVien.bGioitinh);
                        case 4:
                            System.out.println("Email: "); nhanVien.sEmail = scanner.nextLine();
                            nhanVien1.setsEmail(nhanVien.sEmail);
                        case 0:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");

                    }
                    bTimthay = false;
                }while (Luachon !=0);
            }
        }
        if (bTimthay) System.out.println("Không tìm thấy nhân viên!");
    }
    public void LuuFile(){
        try (FileOutputStream fos = new FileOutputStream("dsNV.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lst);
            System.out.println("Lưu danh sách nhân viên thành công!");
        } catch (IOException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void DocFile() {
        try (FileInputStream fis = new FileInputStream("dsNV.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            lst = (ArrayList<NhanVien>) ois.readObject();
            System.out.println("Đọc danh sách nhân viên thành công!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
    public void menu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("========= MENU =========");
            System.out.println("1. Nhập danh sách nhân viên");
            System.out.println("2. Xuất danh sách nhân viên");
            System.out.println("3. Tìm kiếm nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Lưu file nhân viên");
            System.out.println("7. Đoc file nhân viên");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    NhapDS();
                    break;
                case 2:
                    XuatDS();
                    break;
                case 3:
                    Timkiem();
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
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

}
