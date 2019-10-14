import java.io.*;
import java.util.*;
public class prob05
{
    public static void main(String[] args) throws Exception
    {
        new prob05().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob05-1-in.txt"));
        int n = file.nextInt(); file.nextLine();
        while(n-->0)
        {
            int k = file.nextInt();
            String s = file.nextLine().trim();
            int c = 0;
            for(int i=0;i<s.length();i++)
            {
                if(i%k!=0){ System.out.print(s.charAt(i));c++;}
            }
            System.out.println(" " + c);
        }
    }
}
