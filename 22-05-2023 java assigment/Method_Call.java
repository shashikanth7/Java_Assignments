import java.lang.*;
public class Method_Call{
    public static void main(String[] args) {
        MyClass1 v =new MyClass1();
         v.method1();
         v.method2();
    }
}

class MyClass1 {
    static  String g="iam method1";
    static String t="iam method2";
    static void method1() {
MyClass1 w2=new MyClass1();
        System.out.println(w2.g);
    }

    static void method2() {
MyClass1 w1=new MyClass1();
        System.out.println(w1.t);
    }
}

