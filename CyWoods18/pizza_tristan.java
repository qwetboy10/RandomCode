import java.io.*;
import java.util.*;
class pizza
{
    public static void main(String[] args) throws Exception
    {
        new pizza().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("pizza.dat"));
        int times = file.nextInt(); file.nextLine();
        for(int asdf=1;asdf<=times;asdf++)
        {
            String s = file.nextLine();
            if(s.matches("\\D*\\(\\d{3}\\)\\D*\\d{3}\\D*[2-9]\\d{3}\\D*"))
            {
                if(s.matches("\\D*\\(281\\)\\D*237\\D*2800\\D*")) System.out.println("TEST " + asdf + ": GET GRINCHED");
                else System.out.println("TEST " + asdf+ ": ORDER AWAY");
            }
            else
            {
                System.out.println("TEST " + asdf + ": INVALID NUMBER");
            }
        }
    }
}