import java.io.*;
import java.util.*;
public class prob09
{
    public static void main(String[] args) throws Exception
    {
        new prob09().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob09-1-in.txt"));
        int l = file.nextInt(),w = file.nextInt(),d = file.nextInt();
        while(l != 0 || w != 0 || d != 0)
        {
            int painted = 2 * w * l + 2 * w * (d-2) + 2 * (l-2) * (d-2);
            int unpainted = w * l * d - painted; 
            System.out.printf("A %dx%dx%d block is ",l,w,d);
            if(painted == unpainted) System.out.println("PERFECT");
            else if(painted > unpainted) System.out.println("MORE than Perfect");
            else System.out.println("LESS than Perfect");
            l = file.nextInt();w = file.nextInt();d = file.nextInt();
        }
    }
}
