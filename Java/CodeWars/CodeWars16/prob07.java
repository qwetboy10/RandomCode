import java.io.*;
import java.util.*;
public class prob07
{
    public static void main(String[] args) throws Exception
    {
        new prob07().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob07-1-in.txt"));
        int n = file.nextInt(); file.nextLine();
        while(n-->0)
        {
            ArrayList<String> a = new ArrayList<String>(Arrays.asList(file.next().split("")));
            ArrayList<String> b = new ArrayList<String>(Arrays.asList(file.next().split("")));
            ArrayList<String> c = new ArrayList<String>(Arrays.asList(file.next().split("")));
            a.retainAll(b);
            a.retainAll(c);
            Collections.sort(a);
            System.out.println(a.toString().replaceAll("[\\[,\\] ]",""));
        }
        System.out.println(3);
    }
}
