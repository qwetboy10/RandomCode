import java.io.*;
import java.util.*;
public class prob14
{
    public static void main(String[] args) throws Exception
    {
        new prob14().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob14-1-in.txt"));
        int n = file.nextInt(); file.nextLine();
        while(n-->0)
        {
            String[] in = file.nextLine().split("\\.");
            String ou = "";
            for(String s : in)
            {
            char[] c = s.toCharArray();
            boolean[] b = new boolean[c.length];
            String out = "";            
            int i = 0;
            int q = c.length;
            a:
            while(q>0)
            {
                out += c[i];
                b[i] = true;
                int k = sv(c[i]);
                if(q <= 1)
                {
                    q--;
                    continue;
                }
                while(k > 0)
                {
                    if(!b[i]) k--;
                    if(k != 0)
                    {
                        i++;
                        i%=c.length;
                    }
                }
                q--;
            }
            ou += out + ".";
            }
            System.out.println(ou.trim());
        }
    }
    int sv(char c)
    {
        if(c==32) return 6;
        else return (c - 65) % 5 +1;
    }
}
