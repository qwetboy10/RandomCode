import java.io.*;
import java.util.*;
class believers
{
    public static void main(String[] args) throws Exception
    {
        new believers().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("believers.dat"));
        int times = file.nextInt();
        while(times-->0)
        {
            int c = 0;
            int n = file.nextInt();
            while(n-->0)
            {
                file.next();
                int age = file.nextInt();
                boolean b = file.nextBoolean();
                if(b) c++;
                else if(age<=12) c--;
            }
            System.out.println("Sammy Score: " + c);
        }
    }
}