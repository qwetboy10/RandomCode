import java.io.*;
import java.util.*;

class prob07
{
    public static void main(String[] args) throws Exception { new prob07().run(); }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob07-1-in.txt"));
        double p = file.nextDouble();
        while(p != 0)
        {
            System.out.println(Math.pow(p,2.0/3));
            p = file.nextDouble();
        }
    }
}
