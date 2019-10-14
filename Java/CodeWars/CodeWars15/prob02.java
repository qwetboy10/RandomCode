import java.io.*;
import java.util.*;

class prob02
{
    public static void main(String[] args) throws Exception { new prob02().run(); }
    public static void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob02-1-in.txt"));
        while(file.hasNext())
        {
            System.out.println(file.nextLong()*file.nextLong());
        }
    }
}
