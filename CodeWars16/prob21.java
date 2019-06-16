import java.io.*;
import java.util.*;
public class prob21
{
    double[] dij;
    Planet[] p;
    ArrayList<String> sol;
    class Planet
    {
        String name;
        String type;
        double mag;
        double x;
        double y;
        double z;
        Planet(String s)
        {
            String[] in = s.split("\\s+");
            name = in[0];
            type = in[1];
            mag = Double.parseDouble(in[2]);
            x = Double.parseDouble(in[3]);
            y = Double.parseDouble(in[4]);
            z = Double.parseDouble(in[5]);
        }
        double dis(Planet o)
        {
            return Math.sqrt(Math.pow(x-o.x,2)+Math.pow(y-o.y,2)+Math.pow(z-o.z,2));
        }
    }
    public static void main(String[] args) throws Exception
    {
        new prob21().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob21-1-in.txt"));
        int n = file.nextInt(); file.nextLine();
        p = new Planet[n];
        for(int i=0;i<n;i++) p[i] = new Planet(file.nextLine());
        int trips = file.nextInt(); file.nextLine();
        while(trips-->0)
        {
            String start = file.next();
            String end = file.next();
            int maxJ = file.nextInt(); file.nextLine();
            int a = -1;
            int b = -1;
            for(int i=0;i<n;i++)
            {
                if(p[i].name.equals(start)) a = i;
                else if(p[i].name.equals(end)) b = i;
            }
            dij = new double[n];
            Arrays.fill(dij,Double.MAX_VALUE);
            recur(a,b,maxJ,0.0,new ArrayList<String>());
            System.out.println("JOURNEY from " + p[a].name+" to "+p[b].name+", max jump: " + maxJ+ " LY");
            System.out.printf("STRAIGHT LINE DISTANCE: %.2f LY%n",p[a].dis(p[b]));
            System.out.println("number of jumps: " + sol.size());
            sol.stream().forEach(System.out::println);
            double sum = 0.0;
            for(int i=0;i<sol.size();i++)
            {
                String[] s = sol.get(i).split(" ");
                sum += Double.parseDouble(s[3]);
            }
            System.out.printf("Total Distance: %.2f LY%n%n",sum);
        }
    }
    public void recur(int index,int destination,int max,double s,ArrayList<String> jumps)
    {
        if(dij[index] < s) return;
        dij[index] = s;
        if(index==destination)
        {
            sol = jumps;
            return;
        }
        for(int i=0;i<p.length;i++)
        {
            if(i==index) continue;
            if(p[index].dis(p[i]) <= max)
            {
                ArrayList<String> j2 = (ArrayList<String>) jumps.clone();
                j2.add(p[index].name + " to " + p[i].name +"; " + String.format("%.2f",p[index].dis(p[i]))+" LY");
                recur(i,destination,max,s+p[index].dis(p[i]),j2);
            }
        }
    }
}
