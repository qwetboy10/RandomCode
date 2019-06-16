import java.io.*;
import java.util.*;
public class prob08
{
    public static void main(String[] args) throws Exception
    {
        new prob08().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob08-1-in.txt"));
        int n = file.nextInt(); file.nextLine();
        while(n-->0)
        {
            String s = file.nextLine();
            for(int i=0;i<s.length();i++)
            {
                for(int j=0;j<s.length()-i-1;j++) System.out.print(" ");
                System.out.println(s.substring(s.length()-i-1));
            }
            for(int i=s.length()-1;i>=1;i--)
            {
                System.out.println(s.substring(s.length()-i));
            }
            System.out.println();
        }
    }
}
