import java.io.*;
import java.util.*;
class oomlaw
{
    public static void main(String[] args) throws Exception
    {
        new oomlaw().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("oomlaw.dat"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            long a = file.nextLong();
            long q = file.nextLong();
            long n = file.nextLong();
            int x = file.nextInt();
            long m = 0;
            for(int i=0;i<x;i++) m += file.nextLong();
            double top = (Math.exp(Math.log10(Math.PI))+212)*Math.abs(a) - Math.pow(n,Math.abs(a));
            double bot = m - (Math.pow(q, 2) * n) + Math.sin(Math.pow(212, 7.0/10.0));
            double out = top/bot;
            out = Math.cbrt(out);
            out = Math.pow(out,2);
            System.out.printf("%.3f%n",out);
        }
    }
}