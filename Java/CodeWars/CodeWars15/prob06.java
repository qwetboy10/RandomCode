import java.io.*;
import java.util.*;

class prob06
{
    public static void main(String[] args) throws Exception { new prob06().run(); }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob06-1-in.txt"));
        System.out.println((int) Math.ceil((file.nextInt()*file.nextInt()*file.nextInt())/27.0));
    }
}
