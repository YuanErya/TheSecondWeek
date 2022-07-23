import java.util.ArrayList;
import java.util.Scanner;

public class Counter  {
//实现计算器的类

   private String getsz(){
       String st=new Scanner(System.in).nextLine();
       boolean PD=true;//用于标记当前式子是否符合标准
       try{
       for (int i = 0; i <st.length(); i++) {
           if(st.charAt(i)=='('||st.charAt(i)==')'||st.charAt(i)=='.'|| st.charAt(i)=='+'|| st.charAt(i)=='-'||st.charAt(i)=='*'||st.charAt(i)=='/'){
               //检测式子中的全部符号

           }else if(st.charAt(i)<=57&&st.charAt(i)>=48){
               //检测式子中的全部数字
           }else if(!((st.charAt(st.length()-1)<=57&&st.charAt(st.length()-1)>=48)||st.charAt(i)==')')){
               //检测式子最后一位是否符合标准
               PD=false;
               throw new IllegalArgumentException();
           }else{
               //式子中包含除了数字和相应的符号以为外的其他字符则抛出异常
               PD=false;
               throw new IllegalArgumentException();
           }
       }}catch(IllegalArgumentException e){
           System.out.println("请检查您所输入的表达式的正确性");
       }

       if(PD){
       return st;
       }else{
           return null;
       }
   }//获取用户输入的表达式,并检测输入的表达式的正确性





}
