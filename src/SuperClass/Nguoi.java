package SuperClass;

import java.io.Serializable;
import java.util.Scanner;

public class Nguoi implements Serializable {

    public String sHoten;
    public String  sSDT;
    public boolean bGioitinh;
    public String sEmail;

    public Nguoi() {
    }

    public Nguoi(String sHoten, String sSDT, boolean bGioitinh, String sEmail) {
        this.sHoten = sHoten;
        this.sSDT = sSDT;
        this.bGioitinh = bGioitinh;
        this.sEmail = sEmail;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsHoten() {
        return sHoten;
    }

    public void setsHoten(String sHoten) {
        this.sHoten = sHoten;
    }


    public String getsSDT() {
        return sSDT;
    }

    public void setsSDT(String sSDT) {
        this.sSDT = sSDT;
    }

    public boolean isbGioitinh() {
        return bGioitinh;
    }

    public void setbGioitinh(boolean bGioitinh) {
        this.bGioitinh = bGioitinh;
    }

    public void Nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Họ Tên: "); this.sHoten = scanner.nextLine();
        System.out.print("Giới tính(Nam | nu): "); this.bGioitinh = scanner.nextLine().equalsIgnoreCase("nam");
        System.out.print("SDT: "); this.sSDT = scanner.nextLine();
        System.out.print("Email: "); this.sEmail = scanner.nextLine();
    }
    public void Xuat(){
        String GT = this.bGioitinh ? "Nam" : "Nu";
        System.out.printf("%-10s%-5s%-15s%-15s", this.sHoten, GT, this.sSDT, this.sEmail);
    }
}