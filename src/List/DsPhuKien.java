package List;
import SubClass.PhuKien;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DsPhuKien {
    ArrayList<PhuKien> lst = new ArrayList<>();

    public void NhapDS(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phụ kiện: "); int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            PhuKien phuKien = new PhuKien();
            phuKien.Nhap();
            lst.add(phuKien);
        }
    }

    public void XuatDS(){
        System.out.println("Danh sách phụ kiện");
        System.out.printf("%-8s%-10s%-10s%-5s%-10s%n", "Mã PK","Tên","Hãng", "SL", "Giá SP");
        System.out.println("========================================");
        for (PhuKien phuKien : lst){
            phuKien.Xuat();
        }
    }

    public void TimKiem(){
        Scanner scanner = new Scanner(System.in);
        boolean Timthay = true;
        System.out.print("Mã phụ kiện cần tìm kiếm: "); String sMaTK = scanner.nextLine();
        for (PhuKien phuKien : lst ){
            if (phuKien.getsMaPK().equals(sMaTK)) {
                System.out.println("========================================");
                phuKien.Xuat();
                Timthay = false;
            }
        }
        if (Timthay) System.out.println("Không tìm thấy mã phụ kiện!!");
    }

    public void Xoa(){
        ArrayList<PhuKien> lst1 = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean Timthay = true;
        System.out.print("Mã phụ kiện cần xóa: "); String sMaXoa = scanner.nextLine();
        for (PhuKien phuKien : lst){
            if(sMaXoa.equals(phuKien.getsMaPK())){
                lst1.add(phuKien);
                Timthay = false;
            }
        }
        if (Timthay) System.out.println("Không tìm thấy mã phụ kiện!!");
        else {
            lst.removeAll(lst1);
            System.out.println("Xóa thành công");
        }
    }
    public void CapNhat(){
        Scanner scanner = new Scanner(System.in);
        PhuKien phuKien = new PhuKien();
        System.out.print("Mã phụ kiện cập nhật: "); phuKien.sMaPK = scanner.nextLine();
        int Luachon;
        boolean bTimthay = true;
        for (PhuKien phuKien1 : lst){
            if(phuKien.sMaPK.equals(phuKien1.getsMaPK())){
                do{
                    System.out.println("1. Cập nhật tên phụ kiện");
                    System.out.println("2. Cập nhật hãng");
                    System.out.println("3. Cập nhật số lượng trong kho");
                    System.out.println("4. Cập nhật giá sản phẩm");
                    System.out.println("0. Thoat");
                    System.out.print("lua chon : ");
                    Luachon = Integer.parseInt(scanner.nextLine());
                    switch (Luachon){

                        case 1:
                            System.out.print("Tên: "); phuKien.sTenSanPham = scanner.nextLine();
                            phuKien1.setsTenSanPham(phuKien.sTenSanPham);
                            break;
                        case 2:
                            System.out.print("Hãng: "); phuKien.sHangsx = scanner.nextLine();
                            phuKien1.setsHangsx(phuKien.sHangsx);
                            break;
                        case 3:
                            System.out.print("Số lượng trong kho: "); phuKien.iSLtrongkho = scanner.nextInt();
                            phuKien1.setiSLtrongkho(phuKien.iSLtrongkho);
                            break;
                        case 4:
                            System.out.print("Giá sản phẩm: "); phuKien.dGiaSanPham = scanner.nextDouble();
                            phuKien1.setdGiaSanPham(phuKien.dGiaSanPham);
                        case 0:
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ!");

                    }
                    bTimthay = false;
                }while (Luachon !=0);
            }
        }
        if (bTimthay) System.out.println("Không tìm thấy phụ kiện!");
    }
    public void LuuFile(){
        try (FileOutputStream fos = new FileOutputStream("dsPK.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lst);
            System.out.println("Lưu danh sách phụ kiện thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void DocFile() {
        try (FileInputStream fis = new FileInputStream("dsPK.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            lst = (ArrayList<PhuKien>) ois.readObject();
            System.out.println("Đọc danh sách phụ kiện thành công!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public void menu(){
        DsPhuKien dsPhuKien = new DsPhuKien();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== MENU =====");
            System.out.println("1. Nhập danh sách phụ kiện");
            System.out.println("2. Xuất danh sách phụ kiện");
            System.out.println("3. Tìm kiếm phụ kiện");
            System.out.println("4. Xóa phụ kiện");
            System.out.println("5. Cập nhật thông tin phụ kiện");
            System.out.println("6. Lưu danh sách phụ kiện vào file");
            System.out.println("7. Đọc danh sách phụ kiện từ file");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

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
