/*
   ooooo+
  ooooo++
 ooooo+++
ooooo++++
xxxxx++++
xxxxx+++
xxxxx++
xxxxx+
 */
import java.io.*;
import java.util.*;
public class Andy
{
    public static void main(String[]  args) throws Exception
    {
        new Andy().run();
    }
    public void run() throws Exception
    {
		Scanner file = new Scanner(new File("Andy.java"));
		file.nextLine();
		for(int i=0;i<8;i++)
		{
			System.out.println(file.nextLine());
		}
    }
}
