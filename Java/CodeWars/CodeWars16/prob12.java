import java.io.*;
import java.util.*;
public class prob12
{
    int [] dr = {1,0,-1,0};
    int [] dc = {0,1,0,-1};
    public static void main(String[] args) throws Exception
    {
        new prob12().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob12-1-in.txt"));
        int r = file.nextInt(); int c = file.nextInt(); file.nextLine();
        char[][] mat = new char[r][];
        for(int i=0;i<r;i++) mat[i] = file.nextLine().toCharArray();
        boolean[][] v = new boolean[r][c];
        String buf = "";
        int i = 0;
        int j = 0;
        int d = 0;
        while(true)
        {
            buf += mat[i][j];
            v[i][j] = true;
            i += dr[d];
            j += dc[d];
            if(i >= r) {i--;j++;d++;}
            else if(j >= c) {j--;i--;d++;}
            else if(i == -1) {i++;j--;d++;}
            else if(j == -1) {j++;i++;d=0;}
            else if(v[i][j])
            {
                i -= dr[d];
                j -= dc[d];
                d++;
                d%=4;
                i += dr[d];
                j += dc[d];
                if(v[i][j]) break;
            }
        }
        System.out.println(new StringBuffer(buf.trim()).reverse().toString());
    }
}
