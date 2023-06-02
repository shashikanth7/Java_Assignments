package sample;

abstract class AbstractClass {
    public abstract void abstractMethod();
}

class OuterClass {
    static int staticVariable = 926;
    int instanceVariable = 724;

    public static void staticMethod() {
        System.out.println("The number is " + staticVariable);
    }

    class InnerClass extends AbstractClass {
        @Override
        public void abstractMethod() {
            System.out.println("The value of the instance variable is " + instanceVariable);
        }
    }
}

public class MyTask {
    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.staticMethod();
        
        OuterClass.InnerClass ic = oc.new InnerClass();
        ic.abstractMethod();
    }
}
