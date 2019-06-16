import java.io.*;
import java.util.*;
class p
{
    public static void main(String[] args) throws Exception
    {
        new p().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("data.txt"));
        ArrayList<String> lines = new ArrayList<String>();
        while(file.hasNext()) lines.add(file.nextLine());
        for(int i=0;i<lines.size();i+=4)
        {
            String s = lines.get(i);
            s = s.replaceAll(" \\(pg*\\.\\s+\\d+-*\\d*\\)", "");
            lines.set(i,s);
        }
        int[] ans = new int[100];
        Scanner f = new Scanner(new File("tt.txt"));
        int q = 1;
        
        while(f.hasNext())
        {
            int a1 = Integer.parseInt(f.next().replaceAll("\\.", ""))-1;
            int b1 = f.next().charAt(0)-65;
            ans[a1] = b1;
            System.out.println(q++ + " " + a1 + " " + b1);
        }
        for(int i=0;i<lines.size();i+=4)
        {
            System.out.println("Question");
            System.out.println("3");
            System.out.println(lines.get(i).replaceAll("\\d+\\.\\s", ""));
            for(int j=1;j<=3;j++) System.out.println(lines.get(i+j).replaceAll("\\w\\.\\s", ""));
            System.out.println(ans[i/4]);
        }
        
    }
}