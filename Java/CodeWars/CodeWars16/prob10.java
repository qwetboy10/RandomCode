import java.io.*;
import java.util.*;
public class prob10
{
    public static void main(String[] args) throws Exception
    {
        new prob10().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob10-1-in.txt"));
        while(true)
        {
            String s = file.nextLine();
            if(s.equals("=========")) break;
            boolean x = false;
            boolean o = false;
            for(int i=0;i<9;i+=3) if(s.substring(i,i+3).equals("XXX")) x = true; else if(s.substring(i,i+3).equals("OOO")) o = true;
            for(int i=0;i<3;i++)
            {
                String a = "";
                for(int j=0;j<9;j+=3) a += s.charAt(i+j);
                if(a.equals("XXX")) x = true;
                else if(a.equals("OOO")) o = true;
            }
            if(s.matches("X...X...X")) x = true;
            if(s.matches("..O.O.O..")) x = true;
            if(s.matches("O...O...O")) o = true;
            if(s.matches("..O.O.O..")) o = true;
            if(x) System.out.println("Player X won.");
            else if(o) System.out.println("Player O won.");
            else System.out.println("There was a tie.");
            for(int i=0;i<9;i+=3)
            {
                System.out.println(s.substring(i,i+3));
            }
            System.out.println();
        }
    }
}
