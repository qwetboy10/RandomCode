import java.io.*;
import java.util.*;
class e
{
    public static void main(String[] args) throws Exception
    {
        new e().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("e.dat"));
        file.nextLine();
        while(file.hasNext())
        {
            System.out.printf("%."+file.next()+"f%n",Math.E);
        }
    }
}