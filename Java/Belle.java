import java.io.*;
import java.util.*;
public class Belle
{
    public static void main(String[]  args) throws Exception
    {
        new Belle().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("Belle.dat".toLowerCase()));
		int times = file.nextInt();
		while(times-->0) System.out.println(Math.max(file.nextLong(),file.nextLong()));
    }
}
