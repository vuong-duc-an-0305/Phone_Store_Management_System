package THI_MORONG;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class dsTHI_MORONG {
    ArrayList<THI_MORONG > lst = new ArrayList<>();

    public void NhapDS(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("So luong: " ); int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            THI_MORONG thiMorong = new THI_MORONG();
            thiMorong.Nhap();
            lst.add(thiMorong);
        }
    }

    public void XuatDS(){
        for (THI_MORONG thiMorong : lst){
            thiMorong.Xuat();
        }
    }
    public void Inds_haiduong(){
        for (THI_MORONG thiMorong: lst){
            if(thiMorong.getsDiachi().equals("hai duong")){
                thiMorong.Xuat();
            }
        }
    }

    public void Sapxep_CMCD(){
        lst.sort(new Comparator<>() {
            @Override
            public int compare(THI_MORONG thiMorong, THI_MORONG t1) {
                return thiMorong.getsCMND().compareTo(t1.getsCMND());
            }
        });
    }


}
