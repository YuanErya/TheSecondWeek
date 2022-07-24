import java.util.ArrayList;
import java.util.Scanner;

public class Counter {
    //实现计算器的类
    private String st;
    StringBuffer sb = new StringBuffer();


    //获取用户输入的表达式,并检测输入的表达式的正确性，并返回操作符集合
    private ArrayList<Character> getsz() {
        System.out.println("请输入所需要计算的表达式");
        st = new Scanner(System.in).nextLine();
        ArrayList<Character> fh = new ArrayList<Character>();
        boolean PD = true;//用于标记当前式子是否符合标准
        try {
            for (int i = 0; i < st.length(); i++) {
                if (st.charAt(i) =='(' || st.charAt(i) == ')' || st.charAt(i) == '+' || st.charAt(i) == '-' || st.charAt(i) == '*' || st.charAt(i) == '/') {
                    //检测式子中的全部符号
                    fh.add(st.charAt(i));
                } else if (st.charAt(i) <= 57 && st.charAt(i) >= 48) {
                    //检测式子中的全部数字
                }else {
                    //式子中包含除了数字和相应的符号以为外的其他字符则抛出异常
                    PD = false;
                    throw new IllegalArgumentException();
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("请检查您所输入的表达式的正确性");
        }

        if (PD) {
            return fh;
        } else {
            return null;
        }
    }//获取用户输入的表达式,并检测输入的表达式的正确性


    //字符处理
    public void ys() {
        ArrayList<Integer> num = new ArrayList<Integer>();
        String temple;//用于储存临时字符
        ArrayList<Character> fh = getsz();//接收操作符的集合
        ArrayList<String> tfh = new ArrayList<String>();
        if (fh != null) {
            for (int i = 0; i < st.length(); i++) {
                temple = st.substring(i, i + 1);
                if (!pdd(i)) {

                    sb.append(temple);
                    if(i==st.length()-1||pdd(i+1)){
                        num.add(Integer.parseInt(sb.toString()));
                        sb.delete(0, sb.length());
                        if (!tfh.isEmpty() && (tfh.get(tfh.size() - 1) == "*" || tfh.get(tfh.size() - 1) == "/")) {
                            getNF(num, tfh);
                        }
                    }
                } else if (st.charAt(i) == '('||st.charAt(i) == '+' || st.charAt(i) == '-' || st.charAt(i) == '*' || st.charAt(i) == '/') {
                    tfh.add(temple);

                }else{
                    hkh(num,tfh);
                }
            }//已将所有数字转化为int存入集合

            while(true){
                if (num.size() == 1) {
                    System.out.println("计算出结果为：");
                    System.out.print(num);
                    break;
                } else {
                    getNF(num,tfh);
                }
            }
        }
    }


    //判断是否为符号位进行封装
    private boolean pdd(int i) {
        if (st.charAt(i) == ')'||st.charAt(i) == '('||st.charAt(i) == '+' || st.charAt(i) == '-' || st.charAt(i) == '*' || st.charAt(i) == '/') {
            return true;
        } else {
            return false;
        }
    }
    //判断是否为符号位


    //取数和符号运算
    private void getNF(ArrayList<Integer> num, ArrayList<String> fh) {
        int result = 0;
        int num1 = num.get(num.size() - 2);
        int num2 = num.get(num.size() - 1);
        switch (fh.get(fh.size() - 1)) {
            case "*":
                result = num1 * num2;
                break;

            case "/":
                result = num1 / num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case"-":
                result = num1 - num2;
                break;
        }
        num.remove(num.size() - 1);
        num.remove(num.size() - 1);
        num.add(result);
        fh.remove(fh.size() - 1);
    }


    //后括号的时候
    private void hkh(ArrayList<Integer> num, ArrayList<String> fh){
        while(true){
            if(fh.get(fh.size() - 1)=="("){
                fh.remove(fh.size() - 1);
                break;
            }else{
                getNF(num,fh);
            }
        }
    }
}
