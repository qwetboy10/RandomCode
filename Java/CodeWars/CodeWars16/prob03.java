import java.io.*;
import java.util.*;
public class prob03
{
    public static void main(String[] args) throws Exception
    {
        new prob03().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob03-1-in.txt"));
        int n = file.nextInt(); file.nextLine();
        for(int i=0;i<n;i++)
        {
            String s = file.nextLine();
            boolean l = false;
            for(int j=0;j<s.length()-1;j++) if(s.charAt(j)==s.charAt(j+1)) l = true;
            System.out.printf("%s %s%n",l ? "likes" : "hates",s);
        }

    }
}
