package SubClass;

import SuperClass.Nguoi;

import java.io.Serializable;
import java.util.Scanner;

public class NhanVien extends Nguoi implements Serializable {

    public String sManv;
    public float fHsl;
    public   static final float fLcb = 1500;
    public double dLuong;

    public NhanVien() {
    }

    public NhanVien(String sHoten, String sSDT, boolean bGioitinh, String sEmail, String sManv, float fHsl, double dLuong) {
        super(sHoten, sSDT, bGioitinh, sEmail);
        this.sManv = sManv;
        this.fHsl = fHsl;
        this.dLuong = dLuong;
    }

    public String getsManv() {
        return sManv;
    }

    public void setsManv(String sManv) {
        this.sManv = sManv;
    }

    public float getfHsl() {
        return fHsl;
    }

    public void setfHsl(float fHsl) {
        this.fHsl = fHsl;
    }

    public double getdLuong() {
        return dLuong;
    }

    public void setdLuong(double dLuong) {
        this.dLuong = dLuong;
    }

    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mã nhân viên: "); this.sManv = scanner.nextLine();
        super.Nhap();
        System.out.print("Hệ số lương: "); this.fHsl = scanner.nextFloat();
        this.dLuong = this.fHsl *fLcb;
    }

    @Override
    public void Xuat() {
        System.out.printf("%-10s", this.sManv);
        super.Xuat();
        System.out.printf("%-5.2f%-10.2f%n", this.fHsl, this.dLuong);
    }
}