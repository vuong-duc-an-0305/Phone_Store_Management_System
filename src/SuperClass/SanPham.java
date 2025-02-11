package SuperClass;

import java.io.Serializable;
import java.util.Scanner;

public class SanPham implements Serializable {
    public String sTenSanPham;
    public String sHangsx;
    public int iSLtrongkho;
    public double dGiaSanPham;

    public SanPham() {
    }

    public SanPham(String sTenSanPham, String sHangsx, int iSLtrongkho, double dGiaSanPham) {
        this.sTenSanPham = sTenSanPham;
        this.sHangsx = sHangsx;
        this.iSLtrongkho = iSLtrongkho;
        this.dGiaSanPham = dGiaSanPham;
    }

    public String getsTenSanPham() {
        return sTenSanPham;
    }

    public void setsTenSanPham(String sTenSanPham) {
        this.sTenSanPham = sTenSanPham;
    }

    public String getsHangsx() {
        return sHangsx;
    }

    public void setsHangsx(String sHangsx) {
        this.sHangsx = sHangsx;
    }

    public int getiSLtrongkho() {
        return iSLtrongkho;
    }

    public void setiSLtrongkho(int iSLtrongkho) {
        this.iSLtrongkho = iSLtrongkho;
    }

    public double getdGiaSanPham() {
        return dGiaSanPham;
    }

    public void setdGiaSanPham(double dGiaSanPham) {
        this.dGiaSanPham = dGiaSanPham;
    }

    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên sản phẩm: "); this.sTenSanPham = scanner.nextLine();
        System.out.print("Hãng sản xuất: "); this.sHangsx = scanner.nextLine();
        System.out.print("Số lượng trong kho: "); this.iSLtrongkho = scanner.nextInt();
        System.out.print("Giá sản phâm: "); this.dGiaSanPham = scanner.nextDouble();
    }

    public void Xuat(){
        System.out.printf("%-10s%-10s%-5d%-10.2f", this.sTenSanPham,this.sHangsx, this.iSLtrongkho, this.dGiaSanPham);
    }
}