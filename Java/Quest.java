import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Quest
{
    char[][] mat;
    int[][] sad;
    Stack<Pair> path;
    List<Pair> best;
    class Pair
    {
        int a;
        int b;
        Pair(int a,int b)
        {
            this.a = a;
            this.b = b;
        }
        public Pair clone()
        {
            return new Pair(a,b);
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Quest().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("quest.dat"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            int sr = -1;
            int sc = -1;
            mat = new char[10][];
            for(int i=0;i<10;i++)
            {
                mat[i] = file.nextLine().toCharArray();
                for(int j=0;j<10;j++)
                    if(mat[i][j] == 'A')
                    {
                        sr = i;
                        sc = j;
                    }
            }
            sad = new int[10][10];
            Arrays.stream(sad).forEach( x -> Arrays.fill(x, Integer.MAX_VALUE));
            path = new Stack<Pair>();
            recur(sr,sc,0);
            best.forEach( x -> mat[x.a][x.b] = (mat[x.a][x.b] == '.' ? 'O' : mat[x.a][x.b]));
            for(int i=0;i<10;i++)
            {
                for(int j=0;j<10;j++) System.out.print(mat[i][j]);
                System.out.println();
            }
            System.out.println();
            if(times != 0) file.nextLine();

        }
    }
    void recur(int r,int c,int s)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && s < sad[r][c] && mat[r][c] != '#' && mat[r][c] != 'K')
        {
            if(r != 0 && mat[r-1][c] == 'K') return;
            if(r != mat.length-1 && mat[r+1][c] == 'K') return;
            if(c != 0 && mat[r][c-1] == 'K') return;
            if(c != mat[r].length-1 && mat[r][c+1] == 'K') return;

            path.add(new Pair(r,c));
            if(mat[r][c] == 'H') best = path.stream().map( x -> x.clone()).collect(Collectors.toList());
            sad[r][c] = s++;
            recur(r+1,c,s);
            recur(r-1,c,s);
            recur(r,c+1,s);
            recur(r,c-1,s);
            path.pop();
        }
    }
}