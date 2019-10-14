import java.io.*;
import java.util.*;
class shroud
{
    public static void main(String[] args) throws Exception
    {
        new shroud().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("shroud.dat"));
        LinkedHashMap<String,Integer> map  = new LinkedHashMap<>();
        while(file.hasNext())
        {
            String a = file.next();
            if(map.get(a)==null) map.put(a, 0);
            map.put(a,map.get(a)+(file.next().equals("good")?1:-1));
        }
        for(String s : map.keySet())
        {
            System.out.println(s+" is " + (map.get(s)<=0?"naughty":"nice")+" "+Math.abs(map.get(s)));
        }
    }
}