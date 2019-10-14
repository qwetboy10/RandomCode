import java.io.*;
import java.util.*;
public class prob13
{
    public static void main(String[] args) throws Exception
    {
        new prob13().run();
    }
    public void run() throws Exception
    {
        Scanner file = new Scanner(new File("prob13-1-in.txt"));
        int n = file.nextInt();
        while(n-->0)
        {
            String name = file.next();
            String rahours = file.next();
            double raminutes = file.nextDouble();
            String ddegrees = file.next();
            double dminutes = file.nextDouble();
            String clas = file.next();
            double mag = file.nextDouble();
            double dis = file.nextDouble();
            double ra = Double.parseDouble(rahours) + (rahours.startsWith("-") ? -1 : 1) * (raminutes/60.0);
            double dec = Double.parseDouble(ddegrees) + (ddegrees.startsWith("-") ? -1 : 1) * (dminutes/60.0);
            ra *= 15;
            double r = dis;
            double theta = (90.0 - dec) * Math.PI / 180.0;
            double phi = ra * Math.PI / 180.0;
            double x = r * Math.sin(theta) * Math.cos(phi);
            double y = r * Math.sin(theta) * Math.sin(phi);
            double z = r * Math.cos(theta);
            System.out.printf("%s x=%.2f, y=%.2f, z=%.2f%n",name,x,y,z);
        }
    }
}
