import java.io.*;
import java.util.*;
public class prob15
{
    class cube
    {
        char[] front;
        char[] left;
        char[] right;
        char[] back;
        char[] up;
        char[] down;
        cube()
        {
            String key = "gorbwy";
            front = new char[4];
            for(int i=0;i<4;i++) front[i] = key.charAt(0);
            left = new char[4];
            for(int i=0;i<4;i++) left[i] = key.charAt(1);
            right = new char[4];
            for(int i=0;i<4;i++) right[i] = key.charAt(2);
            back = new char[4];
            for(int i=0;i<4;i++) back[i] = key.charAt(3);
            up = new char[4];
            for(int i=0;i<4;i++) up[i] = key.charAt(4);
            down = new char[4];
            for(int i=0;i<4;i++) down[i] = key.charAt(5);
        }
        cube cl()
        {
            cube n = new cube();
            for(int i=0;i<4;i++)
            {
                n.front[i] = front[i];
                n.left[i] = left[i];
                n.right[i] = right[i];
                n.back[i] = back[i];
                n.up[i] = up[i];
                n.down[i] = down[i];
            }
            return n;
        }
        public String toString()
        {
            return (front[0] + " " + front[1] + "\n" + front[2] + " " + front[3]).toUpperCase();
        }
        cube change(String s)
        {
            cube q = this.cl();
            if(s.equals("U"))
            {
                q.up[0] = up[2];
                q.up[1] = up[0];
                q.up[2] = up[3];
                q.up[3] = up[1];
                q.left[0] = front[0];
                q.left[1] = front[1];
                q.front[0] = right[0];
                q.front[1] = right[1];
                q.right[0] = back[0];
                q.right[1] = back[1];
                q.back[0] = left[0];
                q.back[1] = left[1];
            }
            else if(s.equals("D"))
            {
                q.down[0] = down[2];
                q.down[1] = down[0];
                q.down[2] = down[3];
                q.down[3] = down[1];
                q.left[2] = back[2];
                q.left[3] = back[3];
                q.front[2] = left[2];
                q.front[3] = left[3];
                q.right[2] = front[2];
                q.right[3] = front[3];
                q.back[2] = right[2];
                q.back[3] = right[3];
            }
            else if(s.equals("L"))
            {
                q.left[0] = left[2];
                q.left[1] = left[0];
                q.left[2] = left[3];
                q.left[3] = left[1];
                q.up[0] = back[3];
                q.up[2] = back[1];
                q.front[0] = up[0];
                q.front[2] = up[2];
                q.down[0] = front[0];
                q.down[2] = front[2];
                q.back[1] = down[3];
                q.back[3] = down[1];
            }
            else if(s.equals("R"))
            {
                q.right[0] = right[2];
                q.right[1] = right[0];
                q.right[3] = right[1];
                q.right[2] = right[3];
                q.up[1] = front[1];
                q.up[3] = front[3];
                q.front[1] = down[1];
                q.front[3] = down[3];
                q.down[1] = back[2];
                q.down[3] = back[0];
                q.back[0] = up[3];
                q.back[2] = up[1];
            }
            else if(s.equals("F"))
            {
                q.front[0] = front[2];
                q.front[1] = front[0];
                q.front[3] = front[1];
                q.front[2] = front[3];
                q.right[0] = up[2];
                q.right[2] = up[3];
                q.down[0] = right[2];
                q.down[1] = right[0];
                q.left[1] = down[0];
                q.left[3] = down[1];
                q.up[2] = left[1];
                q.up[3] = left[3];
            }
            else if(s.equals("B"))
            {
                q.back[0] = back[2];
                q.back[1] = back[0];
                q.back[3] = back[1];
                q.back[2] = back[3];
                q.right[1] = up[0];
                q.right[3] = up[1];
                q.down[2] = right[3];
                q.down[3] = right[1];
                q.left[0] = down[2];
                q.left[2] = down[3];
                q.up[0] = right[2];
                q.up[1] = right[0];
            }
            return q;
        }
    }
    public static void main(String[] args) throws Exception
    {
        new prob15().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob15-1-in.txt"));
        cube q = new cube();
        System.out.println("Start");
        System.out.println(q);
        System.out.println();
        String com = file.next();
        while(!com.equals("."))
        {
            System.out.println(com);
            q = q.change(com);
            System.out.println(q);
            System.out.println();
            com = file.next();
        }
    }
}
