import java.io.*;
import java.util.*;
class debug
{
    public static void main(String[] args) throws Exception
    {
        new debug().run();
    }
    public void run() throws Exception
    {
      A a = new A();
      A b = new B();
      B c = new B();
      System.out.println(a.go());
      System.out.println(b.go());
      System.out.println(c.go());

    }
    public final int foo() {
      return 3;
    }
}
class A
{
  int go()
  {
    return foo();
  }
  private int foo()
  {
    return 1;
  }
}
class B extends A
{
  
}