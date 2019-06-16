import java.io.*;
import java.util.*;
public class prob02
{
    public static void main(String[] args) throws Exception
    {
        new prob02().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob02-1-in.txt"));
        int n = file.nextInt();
        while(n != 0)
        {
            System.out.printf("%s gallons per week will last %d weeks%n",n+"",10000/n);
            n = file.nextInt();
        }
    }
}
