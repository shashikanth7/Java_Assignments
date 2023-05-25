package sample;
interface FirstInterface {
  public void firstMethod(); 
}
interface SecondInterface {
  public void secondMethod(); 
}
class DemoClass implements FirstInterface, SecondInterface {
  public void firstMethod() {
    System.out.println("This is the implementation of the first method.");
  }
  public void secondMethod() {
    System.out.println("This is the implementation of the second method.");
  }
}

class Main {
  public static void main(String[] args) {
    DemoClass myObj = new DemoClass();
    myObj.firstMethod();
    myObj.secondMethod();
  }
}
