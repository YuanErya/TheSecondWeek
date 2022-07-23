import java.util.ArrayList;
import java.util.Scanner;

public class SFT_Nummer {
    //自然数的拆分问题
    int num, count = 0, sum = 0;
    ArrayList<Integer> Nlist = new ArrayList<>();

    public void sft() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入需要拆分的数字");
        num = s.nextInt();
        cf(num, 1);
    }


    private void cf(int now, int st) {
        if (now > 0) {
            for (int i = st; i < num; i++) {
                Nlist.add(i);
                cf(now - i, i);
                Nlist.remove(Nlist.size() - 1);
            }
        } else if (now == 0) {
            print();
        }
    }


    //用于打印list
    private void print() {
        for (int i = 0; i < Nlist.size(); i++) {
            System.out.print(Nlist.get(i));
            if (i != Nlist.size() - 1) {
                System.out.print("+");
            }
        }
        System.out.println("");
    }
}


