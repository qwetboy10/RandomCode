import java.io.*;
import java.util.*;
class test
{
    public static void main(String[] args) throws Exception
    {
        new test().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("test.dat"));
        for(int i=0;i<3;i++) System.out.println(file.nextLine());
    }
}
