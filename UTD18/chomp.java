import java.io.*;
import java.util.*;

public class chomp
{
    public static void main(String[] args) throws Exception
    {
        new chomp().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("H.txt"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            file.nextInt();
            int p = file.nextInt();
            int q = file.nextInt();
            int r = file.nextInt();
            if(p>2&&q>2&&r>2) System.out.println("W");
            else System.out.println("?");
        }
    }
}
