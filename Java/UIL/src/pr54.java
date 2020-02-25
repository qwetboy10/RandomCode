import java.io.*;
import java.util.*;

public class pr54
{
    public static void main(String[] args) throws Exception
    {
        new pr54().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("pr54.dat"));
        int i = file.nextInt(); file.nextLine();
        while(i-->0)
        {
            String[] s = file.nextLine().split("[ -/]+");
            int y = Integer.parseInt(s[2]);
            if(y < 100) y += 200;
            System.out.printf("%04d%02d%02d%n",y,Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        }
    }
}
