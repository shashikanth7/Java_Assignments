package Shashi;
public class Method_Call{
    public static void main(String[] args) {
        MyClass1 v =new MyClass1();
         v.method1();
         v.method2();
    }
}
class MyClass1 {
    static  String g="java class day1 method ";
    static String t="java class day2 oops concepts ";
    
    
    static void method1() {
         MyClass1 w2=new MyClass1();
         System.out.println(w2.g);
    }

    static void method2() {
          MyClass1 w1=new MyClass1();
          System.out.println(w1.t);
    }
}