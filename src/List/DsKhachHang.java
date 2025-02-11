package List;

import SubClass.KhachHang;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DsKhachHang {
    ArrayList<KhachHang> lst = new ArrayList<>();

    public void NhapDS(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Số lượng khách hàng: ");
        int iSlkh = scanner.nextInt();
        for (int i = 0; i < iSlkh; i++) {
            System.out.println("======== Khách hàng " + ++i +" =========");
            KhachHang khachHang = new KhachHang();
            khachHang.Nhap();
            lst.add(khachHang);
        }
    }

    public void XuatDS(){
        System.out.println("Danh sách khách hàng");
        System.out.println("==================Danh sách khách hàng==============");
        System.out.printf("%-10s%-10s%-5s%-15s%-15s%n", "Mã KH","Họ tên", "GT", "SĐT", "Email");

        for (KhachHang khachHang : lst){
            khachHang.Xuat();
        }
    }

    public void Timkiem(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã KH cần tìm: ");
        String sMatk = scanner.nextLine();
        boolean bTimthay = true;
        for (KhachHang khachHang : lst){
            if (sMatk.equals(khachHang.getsMaKH())) {
                khachHang.Xuat();
                bTimthay = false;
            }
        }
        if (bTimthay) System.out.println("Không tìm thấy khách hàng!!");
    }

     public void Xoa(){
        Scanner scanner = new Scanner(System.in);
         System.out.print("Mã KH muốn xóa: ");
         String sMakh_xoa = scanner.nextLine();
         ArrayList<KhachHang> temp = new ArrayList<>();
         boolean bTimthay = true;
         for (KhachHang khachHang : lst){
             if(khachHang.sMaKH.equals(sMakh_xoa)){
                 temp.add(khachHang);
                 bTimthay = false;
             }
         }
         if (bTimthay) System.out.println("Không tìm thấy khách hàng!!");
         else {
             lst.removeAll(temp);
             System.out.println("Xóa khách hàng thành công!");
         }
     }

     public void CapNhat(){
        Scanner scanner = new Scanner(System.in);
        KhachHang khachHang = new KhachHang();
         System.out.print("Mã khách hàng cập nhật: "); khachHang.sMaKH = scanner.nextLine();
         int Luachon;
         boolean bTimthay = true;
         for (KhachHang khachHang1 : lst){
             if(khachHang.sMaKH.equals(khachHang1.getsMaKH())){
                 do{
                     System.out.println("1. Cập nhật tên khách hàng");
                     System.out.println("2. Cập nhật SĐT");
                     System.out.println("4. Cập nhật giới tính");
                     System.out.println("5. Cập nhật email");
                     System.out.println("0. Thoat");
                     System.out.print("lua chon : ");
                     Luachon = Integer.parseInt(scanner.nextLine());
                     switch (Luachon){

                         case 1:
                             System.out.print("Tên: "); khachHang.sHoten = scanner.nextLine();
                             khachHang1.setsHoten(khachHang.sHoten);
                             break;
                         case 2:
                             System.out.print("SĐT: "); khachHang.sSDT = scanner.nextLine();
                             khachHang1.setsSDT(khachHang.sSDT);
                             break;
                         case 3:
                             System.out.print("Giới tính: "); khachHang.bGioitinh = scanner.nextLine().equals("Nam");
                             khachHang1.setbGioitinh(khachHang.bGioitinh);
                             break;
                         case 4:
                             System.out.println("Email: "); khachHang.sEmail = scanner.nextLine();
                             khachHang1.setsEmail(khachHang.sEmail);
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
         if (bTimthay) System.out.println("Không tìm thấy khách hàng!");
     }
    public void LuuFile(){
        try (FileOutputStream fos = new FileOutputStream("dsKH.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(lst);
            System.out.println("Lưu danh sách khách hàng thành công!");
        } catch (IOException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    public void DocFile() {
        try (FileInputStream fis = new FileInputStream("dsKH.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            lst = (ArrayList<KhachHang>) ois.readObject();
            System.out.println("Đọc danh sách khách hàng thành công!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
     public void menu(){
         Scanner scanner = new Scanner(System.in);
         int choice;
         do {
             System.out.println("========= MENU =========");
             System.out.println("1. Nhập danh sách khách hàng");
             System.out.println("2. Xuất danh sách khách hàng");
             System.out.println("3. Tìm kiếm khách hàng");
             System.out.println("4. Xóa khách hàng");
             System.out.println("5. Cập nhật thông tin khách hàng");
             System.out.println("6. Lưu file khách hàng");
             System.out.println("7. Đoc file khách hàng");
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
