import java.io.*;
import java.util.*;
class lies
{
    public static void main(String[] args) throws Exception
    {
        new lies().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("lies.in"));
        int times = file.nextInt(); file.nextLine();
        while(times-->0)
        {
            String[] dat = {file.nextLine(),file.nextLine(),file.nextLine()};
            TreeSet<String> vars = new TreeSet<String>();
            for(int i=0;i<3;i++)
            {
                String[] t = dat[i].split(" ");
                for(int j=1;j<t.length-1;j++)
                {
                    if(t[j].equals("IS"))
                    {
                        if(t[j+1].equals("NOT"))
                        {
                            vars.add(t[j-1] + " " + t[j] + " " + t[j+2]);
                        }
                        else
                        {
                            vars.add(t[j-1] + " " + t[j] + " " + t[j+1]);
                        }
                    }
                }
            }
            TreeMap<String,Integer> map = new TreeMap<String,Integer>();
            int nn = 0;
            for(String s : vars) map.put(s,nn++);
            boolean[] perm = new boolean[vars.size()];
            int bitmap = 0;
            boolean[] solution = null;
            boolean[] vares = null;
            int numSolutions = 0;
            while(bitmap < Math.pow(2,vars.size()))
            {
                int c = 0;
                int n = bitmap;
                while(n > 0)
                {
                    perm[perm.length-c-1] = (n & 1) == 1;
                    c++;
                    n /= 2;
                }
                String[] cp = dat.clone();
                for(String s : vars)
                {
                    for(int i=0;i<3;i++)
                    {
                        cp[i] = cp[i].replaceAll(s, "" + perm[map.get(s)]);
                        cp[i] = cp[i].replaceAll(s.substring(0,s.indexOf(" IS ")+3) + " NOT" + s.substring(s.lastIndexOf(" ")), "" + !perm[map.get(s)]);
                    }
                }
                //System.out.println(Arrays.deepToString(cp));
                bitmap++;
                boolean[] isTrue = new boolean[3];
                for(int i=0;i<3;i++)
                {
                    String[] tt = cp[i].split(" ");
                    switch(tt[1])
                    {
                        case "AND" : isTrue[i] = tt[0].equals("true") && tt[2].equals("true"); break; 
                        case "OR" : isTrue[i] = tt[0].equals("true") || tt[2].equals("true"); break;
                        case "XOR" : isTrue[i] = tt[0].equals("true") ^ tt[2].equals("true"); break;
                    }
                }
                int cnt = 0;
                for(boolean b : isTrue) if(b) cnt++;
                if(cnt == 2)
                {
                   solution = isTrue.clone();
                   vares = perm.clone();
                   numSolutions++;
                }
                
            }
            if(numSolutions==1)
            {
                int nnn = 0;
                for(int i=0;i<3;i++)
                {
                    System.out.println(dat[i] + " IS " + (solution[i] ? "TRUE" : "A LIE"));
                }
                for(String s : vars)
                {
                    System.out.println(s + " IS " + (vares[nnn++] ? "TRUE" : "FALSE"));
                }
                System.out.println();
            }  
        }
    }
}
