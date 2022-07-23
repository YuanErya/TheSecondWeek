import java.util.Scanner;

public class Counter  {
//实现计算器的类

   private String getsz(){

       String st=new Scanner(System.in).nextLine();
       boolean PD=false;
       try{
       for (int i = 0; i <st.length(); i++) {
           if(st.charAt(i)=='('||st.charAt(i)==')'||st.charAt(i)=='.'|| st.charAt(i)=='+'|| st.charAt(i)=='-'||st.charAt(i)=='*'||st.charAt(i)=='/'){
               //检测式子中的全部符号
           }else if(st.charAt(i)<=57&&st.charAt(i)>=48){
               //检测式子中的全部数字
           }else{
               throw new IllegalArgumentException();
           }
       }}catch(IllegalArgumentException e){
           System.out.println("请检查您所输入的表达式的正确性");
       }

       if(PD){
       return st;}else{
           System.out.println("表达式输入错误，请重新输入正确的表达式");
           return null;
       }
   }//获取用户输入的表达式,并检测输入的表达式的正确性





}
