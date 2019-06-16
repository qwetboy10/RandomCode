import java.util.*;
import static java.lang.Math.*;
import static java.lang.Double.*;

interface a
{
    abstract int foo();
}

class b
{
    static
    {
        System.out.println(1);
    }
    {
        System.out.println(2);
    }
    b()
    {
        System.out.println(3);
    }
}
public class test
{
    public static void main(String[] args) throws Exception
    {
        new test().run();
    }
    public void run() throws Exception
    {
        char c = '\177';
        System.out.println();
    }
}
