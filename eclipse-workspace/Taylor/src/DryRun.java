import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class DryRun {
	public static void main(String[] args) throws Exception
	{
		new DryRun().run();
	}
	public void run() throws Exception
	{
		Scanner file = new Scanner(new File("DryRun.dat".toLowerCase()));
		int times = file.nextInt(); file.nextLine();
		for(int asdf=1;asdf<=times;asdf++)
		{
			System.out.printf("I like %s.%n", file.nextLine());
		}
	}
}
