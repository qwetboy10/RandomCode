import java.io.*;
import java.util.*;
class eightrivers2
{
    char[][] mat;
    int[][] sad;
    public static void main(String[] args) throws Exception
    {
        new eightrivers2().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("eightrivers2.dat"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            int r = file.nextInt(); int c = file.nextInt(); int t = file.nextInt(); file.nextLine();
            mat = new char[r][c];
            sad = new int[r][c];
            for(int i=0;i<r;i++)
            {
                mat[i] = file.nextLine().toCharArray();
                Arrays.fill(sad[i], Integer.MAX_VALUE);
            }
            int sr = -1;
            int sc = -1;
            for(int i=0;i<r;i++) for(int j=0;j<c;j++) if(mat[i][j]=='R') {sr = i;sc = j;}
            recur(sr,sc,0);
            boolean works = true;
            long sum = 0;
            int max = -1;
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    if(mat[i][j]=='T')
                    {
                        if(sad[i][j]==Integer.MAX_VALUE) works = false;
                        else
                        {
                            sum += sad[i][j];
                            max = Math.max(max,sad[i][j]);
                        }
                    }
                }
            }
            sum = sum*2 - max;
            System.out.println(works ? sum : "AA fights 8 Rivers");
        }
    }
    void recur(int r,int c,int s)
    {
        if(r>=0&&r<mat.length&&c>=0&&c<mat[r].length&&s<sad[r][c]&&mat[r][c]!='#')
        {
            sad[r][c] = s++;
            recur(r+1,c,s);
            recur(r-1,c,s);
            recur(r,c+1,s);
            recur(r,c-1,s);
        }
    }
}