import java.util.*;
import java.math.*;

public class written
{
    public static void main(String[] args) throws Exception
    {
        new written().run();
    }
    public void run() throws Exception
    {
        //1
        ArrayList<Integer> k = new ArrayList<Integer>();
        for(int i=0;i<8;i++) k.add(i);
        ListIterator<Integer> li = k.listIterator();
        for(int i=0;i<9;i++)
        {
            if(i%3<2) li.next();
            else li.previous();
        }
        li.remove();
        System.out.println(k);
        //[0,1,2,4,5,6,7]

        //2
        ArrayList<Integer> n = new ArrayList<Integer>();
        for(int i=0;i<8;i++) n.add(i);
        ListIterator<Integer> l = n.listIterator();
        for(int i=0;i<8;i++)
        {
            if(new BigInteger(""+i).isProbablePrime(100)) n.set(i,-1);
        }
        System.out.println(l.next());
        //0

        //3
        while(l.hasPrevious()) l.previous();
        for(int i=0;i<9;i++)
        {
            if(i%5==2&&i>3) n.remove(0);
        }
        //System.out.println(l.next());
        //ConcurrentModificationError
        
        //4
        //Iterator, or ListIterator (choose most restrictive)
        //next()
        //remove()
        //previous()
        //add()
        //hasNext()
        //hasPrevious
        //set()
        //
        //1
        //1
        //2
        //2
        //1
        //2
        //2

        //5
        //ArrayList, LinkedList, Queue, Stack
        //1,2,3,4
        //Which throw errors?
        //add(object) - 1,2,3,4
        //add(int,object) - 1,2,4, error
        //get() - 
        //get(int) - 1,2,4, error
        //remove() - 2,3,error
        //remove(int) - 1,2,4,error
        //remove(object) - 1,2,4,
        //set(int, object) - 1,2,4, error
        //set(object) - 
        //peek() - 2,3,4 (error only on stack)
        //poll() - 2,3
        //pop() - 2,4
        //push(object) - 2,4
        //offer(object) - 2,3
        
        //6
        double[] in = new double[] {-1.0/0.0, 0.0/0.0, 1/0.0, Double.NaN};
        System.out.println(countNaN(in));
        //0

        //7
        int[] cat = new int[6];
        int errors = 0;
        double[] vals = new double[] {Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN,-1,0,1};
        for(int i=0;i<vals.length;i++)
        {
            for(int j=0;j<vals.length;j++)
            {
                try
                {
                    double d = Math.pow(vals[i],vals[j]);
                    if(d==Double.NEGATIVE_INFINITY) cat[0]++;
                    if(d==Double.POSITIVE_INFINITY) cat[1]++;
                    if(d==Double.NaN) cat[2]++;
                    if(d < 0) cat[3]++;
                    if(d == 0) cat[4]++;
                    if(d > 0) cat[5]++;
                }
                catch(Exception e)
                {
                    errors++;
                }
            }
        }
        System.out.println(Arrays.toString(cat));
        System.out.println(errors);
        //[1,5,0,3,6,13]
        //0

        //8
        System.out.println(Math.sin(90));
        System.out.println(Math.atan(1));

        Object[] classes = new Object[] {new TreeSet(), new HashSet(), new TreeMap(), new HashMap(), new ArrayList(), new LinkedList(), new Stack()};
        int[] cnts = new int[5];
        for(int i=0;i<7;i++)
        {
            if(classes[i] instanceof List) cnts[0]++;
            if(classes[i] instanceof Collection) cnts[1]++;
            if(classes[i] instanceof AbstractCollection) cnts[2]++;
            if(classes[i] instanceof Iterable) cnts[3]++;
            if(classes[i] instanceof AbstractSet) cnts[4]++;
        }
        System.out.println(Arrays.toString(cnts));
        //[3,5,5,5,2]

        //9
        Object[] why = new Object[] {new Byte((byte)0), new Short((short)0), new Integer(0), new Long(0), new Float(0), new Double(0), new Character('0')};
        int[] ke = new int[7];
        for(int i=0;i<7;i++)
        {
            for(int j=0;j<7;j++)
            {
                Object o = true ? why[i] : why[j];
                if(o instanceof Byte) ke[0]++;
                if(o instanceof Short) ke[1]++;
                if(o instanceof Integer) ke[2]++;
                if(o instanceof Long) ke[3]++;
                if(o instanceof Float) ke[4]++;
                if(o instanceof Double) ke[5]++;
                if(o instanceof Character) ke[6]++;
            }
        }
        System.out.println(Arrays.toString(ke));
        //[7,7,7,7,7,7,7]

    }
    int countNaN(double[] d)
    {
        int c=0;
        for(int i=0;i<d.length;i++) if(d[i]==Double.NaN) c++;
        return c;
    }
}
