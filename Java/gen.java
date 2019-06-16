import java.io.*;
import java.util.*;
class gen
{
    public static void main(String[] args) throws Exception
    {
        new gen().run();
    }
    public void run() throws Exception
    {
       for(int i=0;i<100;i++)
       {
            for(int j=0;j<3;j++)
            {
                String s1 = (char) ((int) (Math.random()*6)+97) +"";
                String s2 = (char) ((int) (Math.random()*6)+97) +"";
                String op = (int) (Math.random()*3) == 0 ? "AND" : (int) (Math.random()*3) ==2 ? "XOR" : "OR";
                String s3 = Math.random() < .5 ? "" : "NOT ";
                String s4 = Math.random() < .5 ? "" : "NOT ";
		System.out.println(s1 +" IS " + s3 + s1 + " " + op + " " + s2 + " IS " + s4 + s2);
	    }
       }
    }
}
