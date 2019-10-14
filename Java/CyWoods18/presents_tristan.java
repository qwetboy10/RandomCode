import java.io.*;
import java.util.*;
class presents
{
    public static void main(String[] args) throws Exception
    {
        new presents().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("presents.dat"));
        int times = file.nextInt();
        while(times-->0)
        {
            long l = file.nextLong();

            String s = file.next();
            if(l==4)
            {
                System.out.println("coal");
                continue;
            }
            double d = l/4.0;
            //System.out.println(d);
            if(d%1.0<.0001)
            {
                System.out.println(Math.round(d-1) + " x " + Math.round(d+1) + " " + s + " = " + (Math.round(d-1) * Math.round(d+1)) + " " + s + " squared");
            }
            else
            {
                System.out.println(Math.round(Math.floor(d)) + " x " + Math.round(Math.ceil(d))  + " " + s + " = " + (Math.round(Math.floor(d)) * Math.round(Math.ceil(d))) + " " + s + " squared");
            }
        }
    }
}