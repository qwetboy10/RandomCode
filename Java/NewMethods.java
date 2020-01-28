import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NewMethods {
    public static void main(String[] args) throws Exception
    {
        new NewMethods().run();
    }
    public void run() throws Exception
    {
        //immutable factory methods
        Set<Integer> ints = Set.of(1,2,3);
        List<String> strings = List.of("a","b","c");
        Map<Integer, Integer> m = Map.of(1,2);
        System.out.println(Map.of() instanceof Map);
        //immutable copy methods
        System.out.println(List.copyOf(List.of(1,2,3)));
        Set.copyOf(ints);
        Map.copyOf(m);
        //runtime error if you try to add
        Stream.of(1,2,3).collect(Collectors.toUnmodifiableList());
        Optional.of(1).orElseThrow();
        //Optional.ofNullable(null).orElseThrow();
        //throws runtime error if nullable is null
        //stream methods
        Stream<Integer> s = Stream.iterate(1, i -> i < 10, i -> i+1);
        System.out.println(s.dropWhile(x -> x < 5).collect(Collectors.toList()));
        s = Stream.iterate(1, i -> i < 10, i -> i+1);
        System.out.println(s.takeWhile(x -> x < 5).collect(Collectors.toList()));
        //if null return empty stream, else return singleton stream of element
        System.out.println(Stream.ofNullable(null));
        //var
        var b = 3;
        var list = new ArrayList<Integer>();
        var list2 = foo();
        var var = 3;
        //var n;
        //var n2 = null;
        //var array = {1,2,3};
        var array = new int[] {1,2,3};
        String lines = "line1\nline2\nline3";
        lines.lines().forEach(System.out::println);
        List<Integer> a = List.of(1,2,3);
        System.out.println(Arrays.toString(a.toArray(x -> new Integer[x])));
        //toArray takes an int that is the size of the array that should be formed
        System.out.println("a".indent(4));
        System.out.println("abc".transform(x -> x + "1").toString());
        Stream<Integer> t = Stream.of(1,2,3);
        t.collect(Collectors.teeing(Collectors.summingInt(x -> (Integer) x),Collectors.counting(), (Integer sum, Integer count) -> sum / count));
    }
    Object foo()
    {
        return new ArrayList<>();
    }
    interface a
    {
        default int foo()
        {
            return 1;
        }
        private static int ba()
        {
            return 2;
        }
    }

}
