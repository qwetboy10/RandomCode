import java.io.*;
import java.util.*;
public class vc2
{
	String[][] events;
	int[][][] mem;
	int proc;
    public static void main(String[]  args) throws Exception
    {
        new vc2().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("vc2.dat".toLowerCase()));
		int times = Integer.parseInt(file.nextLine());
		while(times-->0)
		{
			proc = Integer.parseInt(file.nextLine());
			events = new String[proc][];
			mem = new int[proc][][];
			for(int i=0;i<proc;i++)
			{
				events[i] = file.nextLine().split("\\s+");
				mem[i] = new int[events[i].length][];
			}
			int q = Integer.parseInt(file.nextLine());
			for(int t=0;t<10;t++)
			{
				//try
				//{
					//System.out.println("Time " + t);
					//for(int p=0;p<proc;p++)
					//{
					//	System.out.println(Arrays.toString(solve(p,t)));
					//}
				//}
				//catch(Exception e)
				//{
				//	System.out.println(e);
				//}
			}
			while(q-->0)
			{
				System.out.println(Arrays.toString(solve(file.nextInt(),file.nextInt()-1)).replaceAll(" ",""));
				file.nextLine();
			}
		}
    }
	int[] solve(int pid, int time)
	{
		if(time==-1) return new int[proc];
		if(mem[pid][time] != null) return mem[pid][time];
		if(events[pid][time].startsWith("S"))
		{
			int[] prev = solve(pid,time-1).clone();
			prev[pid]++;
			mem[pid][time] = prev;
			return prev;
		}
		else if(events[pid][time].startsWith("R"))
		{
			int[] prev = solve(pid,time-1).clone();
			int[] source = null;
			for(int p=0;p<proc;p++)
			{
				for(int t=0;t<events[p].length;t++)
				{
					if(events[p][t].substring(1).equals(events[pid][time].substring(1)) && events[p][t].startsWith("S"))
					{
						source = solve(p,t);
					}
				}
			}
			int[] n = new int[proc];
			for(int i=0;i<proc;i++) n[i] = Math.max(prev[i],source[i]);
			n[pid]++;
			mem[pid][time] = n.clone();
			return n;
		}
		return null;
	}
}
