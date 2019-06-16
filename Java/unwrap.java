import java.io.*;
import java.util.*;

public class unwrap {
    public static void main(String[] args) throws Exception {
        new unwrap().run();
    }
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    public void run() throws Exception {
        Scanner file = new Scanner(new File("unwrap.dat"));
        int n = file.nextInt();
        int[][] mat = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) mat[i][j] = file.nextInt();
        ArrayList<Integer> out = new ArrayList<>();
        int r = 0;
        int c = 0;
        int d = 0;
        int nn = 0;
        while(nn++ < n*n)
        {
            //System.out.println(r + " " + c);
            out.add(mat[r][c]);
            mat[r][c] = -1;
            if(r + dr[d] < 0 || r + dr[d] >= mat.length || c + dc[d] < 0 || c + dc[d] >= mat.length ||  mat[r+dr[d]][c+dc[d]]==-1) d++;
            d %= 4;
            r += dr[d];
            c += dc[d];
        }
        for(int i=0;i<out.size();i++)
        {
            if(i != 0 && i%10==0) System.out.println();
            System.out.print(out.get(i) + " ");
           
        }
    }
}