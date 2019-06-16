import java.io.*;
import java.util.*;

class prob03
{
    public static void main(String[] args) throws Exception { new prob03().run(); }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob03-1-in.txt"));
        System.out.printf("Number %s is alive!%n",p(file.nextInt()));
    }
    String p(int i)
    {
        switch(i)
        {
            case 1 : return "one";
            case 2 : return "two";
            case 3 : return "three";
            case 4 : return "four";
            case 5 : return "five";
            case 6 : return "six";
            case 7 : return "seven";
            case 8 : return "eight";
            case 9 : return "nine";
            case 10 : return "ten";
        }
        return "0";
    }
}
