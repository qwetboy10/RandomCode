import java.util.*;
import java.io.*;
public class Hiking
{
    char[][] mat;
    int[][] sad;
    int er;
    int ec;
    public static void main(String[] args) throws Exception{
        new Hiking().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("hiking.dat"));
        while(file.hasNext())
        {
            String[] dat = file.nextLine().split("\\{\\(|\\)\\}|\\)\\,\\(|\\,");
            int sr = Integer.parseInt(dat[2]);
            int sc = Integer.parseInt(dat[1]);
            er = Integer.parseInt(dat[4]);
            ec = Integer.parseInt(dat[3]);
            mat = new char[5][];
            sad = new int[5][5];
            Arrays.stream(sad).forEach( x -> Arrays.fill(x, Integer.MAX_VALUE));
            for(int i=0;i<5;i++)
                mat[i] = file.nextLine().toCharArray();
            recur(sr,sc,0);
            System.out.printf("Your time to beat is %d minutes.%n", sad[er][ec]);
        }
    }
    void recur(int r,int c,int s)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && s < sad[r][c])
        {
            sad[r][c] = s;
            switch(mat[r][c])
            {
                case 'T': s += 3; break;
                case 'W': s += 8; break;
                case 'O': s += 12; break;
                case 'S': s += 20; break;
            }
            recur(r+1,c,s);
            recur(r-1,c,s);
            recur(r,c+1,s);
            recur(r,c-1,s);
        }
    }
}