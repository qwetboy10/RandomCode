import java.io.*;
import java.util.*;

class prob05
{
    public static void main(String[] args) throws Exception { new prob05().run(); }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob05-1-in.txt"));
        int a = file.nextInt(); int b = file.nextInt(); int c = file.nextInt();
        System.out.printf("%1$d x (%2$d + %3$d) = %1$d x %2$d + %1$d x %3$d%n",a,b,c);
        System.out.printf("%1$d x %2$d = %3$d + %4$d%n",a,c+b,a*b,a*c);
        System.out.printf("%1$d = %1$d%n",a * b + a * c);
    }
}
