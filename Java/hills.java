import java.io.*;
import java.util.*;
class hills
{
    public static void main(String[] args) throws Exception
    {
        new hills().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("hills.in"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            int r = file.nextInt();
            int c = file.nextInt();
            char[][] or = new char[r][c];
            ArrayList<String> mat = new ArrayList<>();
            for(int i=0;i<r;i++)
            {
                String s = file.nextInt();
                or[i] = s.toCharArray();
                mat.add(s);
            }
            while(!done(mat))
            {
                
            }
        }
    }
    boolean done(ArrayList<String> mat)
    {
        boolean d = true;
        for(String s : mat) if(s.contains("^")) d = false;
        return d;
    }
}