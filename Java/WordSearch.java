import java.io.*;
import java.util.*;

public class WordSearch {
    public static void main(String[] args) throws Exception {
        new WordSearch().run();
    }
    int[] dr = {0,1,1, 1, 0,-1,-1,-1};
    int[] dc = {1,1,0,-1,-1,-1, 0, 1};
    char[][] mat;
    public void run() throws Exception {
        Scanner file = new Scanner(new File("WordSearch.dat"));
        int n = file.nextInt();
        file.nextLine();
        mat = new char[n][n];
        for(int i=0;i<n;i++) mat[i] = file.nextLine().replaceAll(" ", "").toCharArray();
        int w = file.nextInt();
        while(w-->0)
        {
            String s = file.next();
            int ii = -1;
            int jj = -1;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    for(int a = 0;a<8;a++) if(find(i,j,s,"",a,n)) {ii = i;jj=j;};
                }
            }
            System.out.println(s + " " + (ii+1) + " " + (jj+1));
        }   
    }
    boolean find(int r,int c,String word,String cur,int d,int n)
    {
        
        if(word.equals(cur)) return true;
        if(r >= 0 && r < n && c >= 0 && c < n)
        {
            return find(r+dr[d],c+dc[d],word,cur + mat[r][c],d,n);
        }
        return false;
    }
}