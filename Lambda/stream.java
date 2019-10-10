import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class stream
{
    public static void main(String[]  args) throws Exception
    {
        new stream().run();
    }
    public void run() throws Exception
    {
        //making streams
        ArrayList<Integer> a1 = new ArrayList<Integer>() {{add(1); add(2);}};
        Stream<Integer> s1 = a1.stream();
        Integer[] a2 = new Integer[2];
        a2[0] = 3; a2[1] = 4;
        Stream<Integer> s2 = Arrays.stream(a2);
        Stream<Integer> s3 = Stream.of(5,6);
        printStream(s1);
        printStream(s2);
        printStream(s3);
        System.out.println();

        
        Stream<Integer> q = Stream.generate( () -> 3);
        printStream(q.limit(5));
        System.out.println();

        Stream<Integer> qq = Stream.iterate(0, x -> x+1);
        printStream(qq.limit(5));
        System.out.println();

        //stream intermediate operations - return a stream - lazily evaluated
        Stream<Integer> a = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> b = Stream.of(2,4,6);
        printStream(Stream.concat(a,b));
        System.out.println();

        Stream<Integer> dups = Stream.of(2,2,1,1,2,2);
        printStream(dups.distinct());
        System.out.println();

        Stream<Integer> v = Stream.of(1,2,3,4,5,6,7,8,9,10);
        printStream(v.filter(x -> x%2==0));
        System.out.println();

        a = Stream.of(1,2,3,4,5,6,7);
        b = Stream.of(1,2,3);
        printStream(a.limit(4));
        printStream(b.limit(4));
        System.out.println();

        a = Stream.of(1,2,3,4,5,6,7);
        b = Stream.of(1,2,3);
        printStream(a.skip(4));
        printStream(b.skip(4));
        System.out.println();

        a = Stream.of(1,2,3,4);
        printStream(a.map(i -> i*2));
        System.out.println();

        a = Stream.of(4,2,1,3);
        printStream(a.sorted());
        System.out.println();

        a = Stream.of(1,2,3);
        printStream(a.flatMap(x -> Stream.generate( () -> x).limit(3)));
        System.out.println();

        //stream terminal operations - return a value - evaluates entire stream
        Stream<Integer> vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        Stream<Integer> evens = Stream.of(2,4,6);
        System.out.println(vals.allMatch( i -> i%2==0));
        System.out.println(evens.allMatch( i -> i%2==0));
        System.out.println();

        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        evens = Stream.of(2,4,6);
        System.out.println(vals.anyMatch( i -> i%2==0));
        System.out.println(evens.anyMatch( i -> i%2==0));
        System.out.println();

        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.count());
        System.out.println();
        
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.findAny());
        System.out.println();
        
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.findFirst());
        System.out.println();

        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        vals.forEach(System.out::println);
        System.out.println();

        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.max( (x,y) -> x - y));
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.max(Comparator.naturalOrder()));
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.min( (x,y) -> x - y));
        System.out.println();

        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.noneMatch(x -> x > 10));

        
        ArrayList<Integer> u = new ArrayList<Integer>();
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        vals = vals.peek(x -> u.add(x));
        vals.forEach( x -> u.add(x+1));
        System.out.println(u);
        System.out.println();

        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.reduce( (x,y) -> x+y));
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.reduce(10, (x,y) -> x+y));
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10);
        System.out.println(vals.reduce("", (s,x) -> s+x, (string1,string2) -> string1+","+string2));
        vals = Stream.of(1,2,3,4,5,6,7,8,9,10).parallel();
        System.out.println(vals.reduce("A", (s,x) -> s+x, (string1,string2) -> string1+","+string2));



        //collect


    }
    public static void printStream(Stream s)
    {
        System.out.println(s.reduce("", (a,b) -> a + "" +  b + " " ));
    }
}
