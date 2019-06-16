import java.io.*;
import java.util.*;
class written_test
{
    public static void main(String[] args) throws Exception
    {
        new written_test().run();
    }
    public void run() throws Exception
    {
        int q1 = 0;
        for(char c=0;c<128;c++) if(Character.isJavaIdentifierStart(c)) q1++;
        System.out.println("Question 1 - " + q1);
        int q2 = 0;
        for(char c=0;c<128;c++) if(Character.isJavaIdentifierPart(c)) System.out.println((int) c + " " + c);
        System.out.println("Question 2 - " + q2);
        System.out.println("Question 3 - " + 'a' + '\u0072' + '\153');
        System.out.print("Question 4 - ");
        String hello = "Hello", lo = "lo";
        System.out.print((hello == "Hello") + " ");
        System.out.print((Other.hello == hello) + " ");
        System.out.print((hello == ("Hel"+"lo")) + " ");
        System.out.print((hello == ("Hel"+lo)) + " ");
        System.out.println(hello == ("Hel"+lo).intern());
        System.out.println("Question 5 - " + (Integer) null);
        System.out.println("Question 6 - " + (null instanceof Integer));
        System.out.println("Question 7 - " + (((short) -1) & Integer.MAX_VALUE | (Short.MAX_VALUE * 2)));
        Object[] q8 = new Object[] {Integer.MAX_VALUE, Integer.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, Character.MAX_RADIX, Character.MIN_RADIX, Character.MAX_CODE_POINT, Character.MIN_CODE_POINT};
        //Arrays.sort(q8);
        System.out.println(Arrays.toString(q8));
        ArrayList<Val> q9 = new ArrayList<Val>();
        for(int i : new int[] {1,2,3,4,5}) q9.add(new Val(i));
        ArrayList<Val> q92 = (ArrayList<Val>) q9.clone();
        System.out.println("Question 9 - " + q92);
        System.out.println("Question 10 - ");
        ArrayList q10 = new ArrayList<>();
        for(int i : new int[] {1,2,3,4,5}) q10.add(i);
        System.out.println((ArrayList<Object>) q10);
        System.out.println((ArrayList<Integer>) q10);
        System.out.println((ArrayList<String>) q10);
        //System.out.println("Question 11 - " + (q10 instanceof ArrayList<Object>));
        System.out.printf("Question 12 - %c%S%B%g%o",'e',null,7,3.0,9);
        System.out.printf("%#x% d%a%(f",12,5,3.0,2.0);
        System.out.println();
        System.out.println("Question 13");
        //Match the boolean identity with its name
        //just pick like 5
        //https://www.uiltexas.org/files/academics/UILCS-BooleanIdentities.pdf
        System.out.print("Question 14 - ");
        List<Comp> q14 = new ArrayList<>();
        for(int i : new int[] {1,2,3,4,5}) q14.add(new Comp(i));
        Collections.sort(q14);
        System.out.println(q14);
        System.out.print("Question 15 - ");
        List q15 = new ArrayList<>();
        for(int i : new int[] {1,2,3,4,5}) q15.add(new Comp(i));
        Collections.sort(q15);
        System.out.println(q15);
        Object[] q16 = new Object[] {new Byte((byte)1), new Character('1'), new Double(1)};
        int c16 = 0;
        for(Object o : q16) if(o instanceof Number) c16++;
        System.out.println("Question 16 - " + c16);
        System.out.println("Question 17 - " + Long.bitCount(new Long(-1l).byteValue() - 1));
        //System.out.println("Question 18 - " + Byte.bitCount(new Long(-1l).byteValue() - 1));
        System.out.println("Question 19 - " + Integer.bitCount(new Long(-1l).byteValue() - 1));
        //System.out.println("Question 20 - " + Byte.compareUnsigned(0b10000000, 0b1111111));
        System.out.println("Question 20 - " + Integer.highestOneBit(Integer.MIN_VALUE));
        System.out.println("Question 21 - " + Long.numberOfLeadingZeros(0b0010));
        System.out.println("Question 22 - " + Math.addExact(Integer.MAX_VALUE/2, Integer.MAX_VALUE/2));
        System.out.println("Question 23 - " + Math.atan2(1,1));
        System.out.println("Question 24 - " + Math.expm1(0));
        System.out.println("Question 25 - " + (Math.nextAfter(1.0, 2.0) == Math.nextUp(1.0) ? 1 : Math.nextAfter(1.0, 2.0) == Math.nextDown(1.0) ? -1 : 0));
        System.out.println("Question 26 - " + Math.signum(212));
        System.out.printf("Question 27 - %.3f%n",Math.E);
        System.out.println("Question 28 - " + Math.floorMod(4, -3));
        System.out.println("Question 29");
        //try{throw new Throwable();}catch(Error e) {};
        System.out.print("Question 30 - ");
        try
        {
        //    throw null;
        }
        catch(NumberFormatException e)
        {
            System.out.print("yes ");
        }
        System.out.println("no");
        System.out.println("Question 31");
        //make this one a matching question
        //Class variable - Static variable within a class
        //Instance variable - Non static variable within a class
        //Array component - Unnamed variables that are created whenever a new array is created
        //Method parameter - Variable that represents an argument passed to a method
        //Constructor parameter - Variable that represents an argument passed to a constructor
        //Local variable - variable declared in a block
        ArrayList<Integer> q32 = new ArrayList<Integer>();
        for(int i=0;i<5;i++) q32.add(i);
        System.out.print("Question 32 - ");
        //System.out.println(foo(q32));
        System.out.println();
        //same graph for 33 and 34
        //find one on the internet or something
        System.out.println("Question 33");
        //definition of a circuit
        System.out.println("Question 34");
        //definition of a hamiltonian path
        char q35 = 0;
        System.out.println("Question 35 - " + (q35 = 100));
        System.out.println("Question 36 - " + (0xcafebabe - 0xcafebab0));
		System.out.println(0xcafe + 0x1 - 0xcaff);
		System.out.println(0xdecaf - 0xcaf);
		char q31 = Character.MIN_VALUE;
		System.out.println(q31 = 100);
		System.out.println(Long.parseUnsignedLong((Integer.toBinaryString(Integer.MIN_VALUE)+Integer.toBinaryString(Integer.MIN_VALUE)).substring(1),2));

    }
    //<T> T foo(List<T> l)
    //{
    //    return l.get(0) instanceof T ? l.get(0) : l.get(l.size()-1);
    //}
}
class Other { static String hello = "Hello"; }
class Val 
{
    int val;
    Val(int i) { val = i;}
    public Object clone() { return new Val(val+1); }
    public String toString() {return String.valueOf(val);}
}
class Comp implements Comparable<Comp>
{
    int val;
    Comp(int i) {val = i;}
    public String toString() {return Integer.toString(val);}
    public int compareTo(Comp o) {return val - o.val <= 0 ? 1 : -1;}
    public int compareTo(Object o) {return val - o.val <= 0 ? -1 : 1;}
    
}
