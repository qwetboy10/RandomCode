import java.util.*;
import java.io.*;

class Clearing
{
    char[][] mat;
    int[][][] sad;
    boolean pos;
    public static void main(String[] args) throws Exception 
    { new Clearing().run();}
    
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("clearing.dat"));
        while(file.hasNext())
        {
            String[] dat = file.nextLine().split("[:x]");
            int bombs = Integer.parseInt(dat[0]);
            int c = Integer.parseInt(dat[1]);
            int r = Integer.parseInt(dat[2]);
            mat = new char[r][];
            for(int i=0;i<r;i++) mat[i] = file.nextLine().toCharArray();
            sad = new int[r][c][bombs+1];
            Arrays.stream(sad).forEach( x -> Arrays.stream(x).forEach(y -> Arrays.fill(y, Integer.MAX_VALUE)));
            int sr = -1;
            int sc = -1;
            for(int i=0;i<r;i++) for(int j=0;j<c;j++) if(mat[i][j] == 'S') {sr = i; sc = j;}
            pos = false;
            recur(sr,sc,bombs,0);
            System.out.println(pos ? "KEEP" : "DELETE");
        }
    }
    void recur(int r,int c,int b,int s)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && b >= 0 && s < sad[r][c][b] && !pos)
        {
            if(mat[r][c] == 'E') pos = true;
            if(b == 0 && mat[r][c] == 'R') return;
            else if(mat[r][c] == 'R') b--;
            sad[r][c][b] = s++;
            recur(r+1,c,b,s);
            recur(r-1,c,b,s);
            recur(r,c+1,b,s);
            recur(r,c-1,b,s);
        }
    }
}