import java.io.*;
import java.util.*;
public class prob04
{
    public static void main(String[] args) throws Exception
    {
        new prob04().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob04-1-in.txt"));
        double a = file.nextDouble(); double b = file.nextDouble();
        while(a != 0 || b != 0)
        {
            System.out.printf("%.2f%n",a * Math.pow(10,b));
            a = file.nextDouble();
            b = file.nextDouble();
        }
    }
}
