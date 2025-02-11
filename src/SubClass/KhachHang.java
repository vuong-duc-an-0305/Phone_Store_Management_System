package SubClass;

import SuperClass.Nguoi;

import java.io.Serializable;
import java.util.Scanner;

public class KhachHang extends Nguoi implements Serializable {
    public String sMaKH;

    public KhachHang() {
    }

    public KhachHang(String sMaKH) {
        this.sMaKH = sMaKH;
    }

    public KhachHang(String sHoten, String sSDT, boolean bGioitinh, String sEmail, String sMaKH) {
        super(sHoten, sSDT, bGioitinh, sEmail);
        this.sMaKH = sMaKH;
    }

    public String getsMaKH() {
        return sMaKH;
    }

    public void setsMaKH(String sMaKH) {
        this.sMaKH = sMaKH;
    }

    @Override
    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã khách hàng: "); this.sMaKH = scanner.nextLine();
        super.Nhap();
    }

    @Override
    public void Xuat() {
        System.out.printf("%-10s", this.sMaKH);
        super.Xuat();
//        System.out.printf("%n");
    }
}