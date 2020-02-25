import java.io.*;
import java.util.*;

public class pr23
{
    public static void main(String[] args) throws Exception
    {
        new pr23().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("pr23.dat"));
        int i = file.nextInt(); file.nextLine();
        while(i-->0)
        {
            System.out.println(Arrays.stream(file.nextLine().split("")).filter(x -> x.matches("[aeiouAEIOU]")).count());
        }
    }
}