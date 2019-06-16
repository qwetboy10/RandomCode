import java.io.*;
import java.util.*;
class wrapping
{
    public static void main(String[] args) throws Exception
    {
        new wrapping().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("wrapping.dat"));
        int n = file.nextInt(); file.nextLine();
        while(n-->0)
        {
            //33 87 173 346
            String s = file.next();
            String k = file.next();
            while(k.matches("[a-zA-Z]+"))
            {
                s += " " + k;
                k = file.next();
            }
            long cost = Long.parseLong(k)*100;
            long budget = file.nextLong()*100;
            long w = file.nextLong();
            long l = file.nextLong();
            long h = file.nextLong();
            double volume = l*w*h / (12*12*12);
            long sa = w*l*2+l*h*2+w*h*2;
            System.out.println(s + " " + cost);
            if(cost > budget) System.out.println("Can't afford " + s + " :(");
            else
            {
                budget -= cost;
                String box = null;
                String paper = null;
                if(108*volume < budget)
                {
                    box = "Cardboard Box";
                    budget -= 108*volume;
                    if(33*sa<budget)
                    {
                        paper = "Grocery Bag";
                        budget -= 33*sa;
                        if(346*sa<budget)
                        {
                            paper = "North Pole Wrapping Paper";
                            budget -= 346*sa;
                        }
                        else if(173*sa<budget)
                        {
                            paper = "Fancy Wrapping Paper";
                            budget -= 173*sa;
                        }
                        else if(87*sa<budget)
                        {
                            paper = "Budget Wrapping Paper";
                            budget -= 87*sa;
                        }
                        if(1500*volume<budget)
                        {
                            box = "Autographed Box";
                            budget -= 1500*volume;
                        }
                        else if(215*volume<budget)
                        {
                            box = "Fancy Cardboard Box";
                            budget -= 215*volume;
                        }
                        else if(108*volume<budget)
                        {
                            box = "Cardboard Box";
                            budget -= 108*volume;
                        }
                    }
                }
                System.out.println(s+": " + box + " and " + paper);
            }
            
        }
    }
}