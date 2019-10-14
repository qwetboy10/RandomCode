import java.io.*;
import java.util.*;
class gifting
{
    public static void main(String[] args) throws Exception
    {
        new gifting().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("gifting.dat"));
        int times = file.nextInt();
        while(times-->0)
        {
            int s = file.nextInt();
            int w = file.nextInt();
            int cnt = 0;
            int[] n = new int[s];
            for(int i=0;i<s;i++)
            {
                file.next();
                file.next();
                n[i] = file.nextInt();
            
            }
            Arrays.sort(n);
            for(int i=0;i<s;i++)
            {
                if(w - n[i] >= 0)
                {
                    cnt++;
                    w -= n[i];
                }
            }

            System.out.println(cnt==0?"WE WANT PRESENTS! WE WANT PRESENTS!" : cnt);
        }
    }
}