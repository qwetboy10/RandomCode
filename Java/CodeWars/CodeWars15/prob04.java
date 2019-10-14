import java.io.*;
import java.util.*;

class prob04
{
    public static void main(String[] args) throws Exception { new prob04().run(); }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob04-1-in.txt"));
        int n = file.nextInt();
        int k = file.nextInt();
        while(n != 0 || k != 0)
        {
            System.out.println(n*k);
            n = file.nextInt();
            k = file.nextInt();
        }
    }
}
