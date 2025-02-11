package SubClass;

import SuperClass.SanPham;

import java.io.Serializable;
import java.util.Scanner;

public class DienThoai extends SanPham  implements Serializable {
    public String sMaDT;
    public String sLoaimay;

    public DienThoai() {
    }

    public DienThoai(String sTenSanPham, String sHangsx, int iSLtrongkho, double dGiaSanPham, String sMaDT, String sLoaimay) {
        super(sTenSanPham, sHangsx, iSLtrongkho, dGiaSanPham);
        this.sMaDT = sMaDT;
        this.sLoaimay = sLoaimay;
    }

    public String getsMaDT() {
        return sMaDT;
    }

    public void setsMaDT(String sMaDT) {
        this.sMaDT = sMaDT;
    }

    public String getsLoaimay() {
        return sLoaimay;
    }

    public void setsLoaimay(String sLoaimay) {
        this.sLoaimay = sLoaimay;
    }

    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã điện thoại: "); this.sMaDT = scanner.nextLine();
        super.Nhap();
        System.out.print("Loại máy: "); this.sLoaimay = scanner.nextLine();
    }

    @Override
    public void Xuat() {
        System.out.printf("%-8s", this.sMaDT);
        super.Xuat();
        System.out.printf("%-10s%n", this.sLoaimay);
    }
}