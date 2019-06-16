import java.io.*;
import java.util.*;
class palindrome
{
    public static void main(String[] args) throws Exception
    {
        new palindrome().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("palindrome.dat"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            String s = file.nextLine();
            char[][] out = new char[s.length()][s.length()];
            if(s.equals(new StringBuffer(s).reverse().toString()))
            {
                for(int i=0;i<s.length();i++) 
                Arrays.fill(out[i], ' ');
                for(int i=0;i<s.length();i++)
                {
                    out[i][0] = s.charAt(i);
                    out[0][i] = s.charAt(i);
                    out[i][s.length()-1] = s.charAt(i);
                    out[s.length()-1][i] = s.charAt(i);
                }
                for(int i=0;i<s.length();i++)
                {
                    System.out.println(Arrays.toString(out[i]).replaceAll("[\\[,\\]]",""));
                }
            }
            else System.out.println("\"NOT A PALINDROME!\"");
            if(times!=0) System.out.println();
        }
    }
}