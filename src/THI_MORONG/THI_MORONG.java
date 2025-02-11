package THI_MORONG;

import SubClass.KhachHang;

import java.util.Scanner;

public class THI_MORONG extends KhachHang {
    public String sDiachi;
    public String sCMND;

    public THI_MORONG() {
    }

    public THI_MORONG(String sMaKH, String sDiachi, String sCMND) {
        super(sMaKH);
        this.sDiachi = sDiachi;
        this.sCMND = sCMND;
    }

    public String getsDiachi() {
        return sDiachi;
    }

    public void setsDiachi(String sDiachi) {
        this.sDiachi = sDiachi;
    }

    public String getsCMND() {
        return sCMND;
    }

    public void setsCMND(String sCMND) {
        this.sCMND = sCMND;
    }

    @Override
    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        super.Nhap();
        System.out.print("Dia Chi: "); this.sDiachi = scanner.nextLine();
        System.out.print("CMND: "); this.sCMND = scanner.nextLine();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.printf("%-10s%-10s%n", this.sDiachi, this.sCMND);
    }
}
