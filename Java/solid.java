import java.io.*;
import java.util.*;
class solid
{
    char[][] mat;
    int[][][] sad;
    public static void main(String[] args) throws Exception
    {
        new solid().run();
    }
    boolean[][] inv(int dir)
    {
        boolean[][] ret = new boolean[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]=='G')
                {
                    int dr = 0;
                    int dc = 0;
                    if(dir==0) dc = -1;
                    if(dir==1) dr = -1;
                    if(dir==2) dc = 1;
                    if(dir==3) dr = 1;
                    int r = i;
                    int c = j;
                    while(true)
                    {
                        try
                        {
                            ret[r][c] = true;
                            r += dr;
                            c += dc;
                        }
                        catch(Exception e)
                        {
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("solid.in"));
        int times = file.nextInt(); file.nextLine();
        for(int n=0;n<times;n++)
        {
            int r = file.nextInt();
            int c = file.nextInt(); file.nextLine();
            mat = new char[r][c];
            sad = new int[4][r][c];
            int sr = -1;
            int sc = -1;
            int er = -1;
            int ec = -1;
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<4;j++)Arrays.fill(sad[j][i], Integer.MAX_VALUE);
                mat[i] = file.nextLine().toCharArray();
                for(int j=0;j<c;j++)
                {
                    if(mat[i][j]=='M')
                    {
                        sr = i;
                        sc = j;
                    }
                    else if(mat[i][j]=='E')
                    {
                        er = i;
                        ec = j;
                    }
                }
            }
            recur(sr,sc,0,4);
            int min = Integer.MAX_VALUE;
            for(int i=0;i<4;i++) min = Math.min(min,sad[i][er][ec]);
            if(n==12)
            {
                System.out.println(Arrays.deepToString(mat));
            }
            System.out.println(min == Integer.MAX_VALUE ? "RESORT TO VIOLENCE" : "SNEAKY BEAKY");
        }
    }
    public void recur(int r,int c,int s,int w)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && s < sad[s%4][r][c])
        {
            if(mat[r][c]!='E' && inv(s%4)[r][c]) return;
            sad[s%4][r][c] = s++;
            if(w > 0) recur(r,c,s,w-1);
            recur(r+1,c,s,4);
            recur(r-1,c,s,4);
            recur(r,c-1,s,4);
            recur(r,c+1,s,4);
        }
    }
}