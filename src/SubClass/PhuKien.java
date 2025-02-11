package SubClass;

import SuperClass.SanPham;

import java.io.Serializable;
import java.util.Scanner;

public class PhuKien extends SanPham implements Serializable {
    public String sMaPK;

    public PhuKien() {
    }

    public PhuKien(String sTenSanPham, String sHangsx, int iSLtrongkho, double dGiaSanPham, String sMaPK) {
        super(sTenSanPham, sHangsx, iSLtrongkho, dGiaSanPham);;
        this.sMaPK = sMaPK;
    }

    public String getsMaPK() {
        return sMaPK;
    }

    public void setsMaPK(String sMaPK) {
        this.sMaPK = sMaPK;
    }

    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã phụ kiện: "); this.sMaPK = scanner.nextLine();
        super.Nhap();
    }

    @Override
    public void Xuat() {
        System.out.printf("%-8s", this.sMaPK);
        super.Xuat();
        System.out.printf("%n");
    }
}