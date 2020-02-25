import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class collect
{
    public static void main(String[]  args) throws Exception
    {
        new collect().run();
    }
    public void run() throws Exception
    {
        System.out.println(Stream.of(1,2,3).collect(Collectors.averagingDouble(Integer::doubleValue)));
        System.out.println(Stream.of(1,2,3).collect(Collectors.averagingInt(Integer::intValue)));
        System.out.println(Stream.of(1,2,3,1,2,3).collect(Collectors.counting()));
        System.out.println(Stream.of(1,2,3,4,5,6).collect(Collectors.groupingBy( i -> i < 3)));
        System.out.println(Stream.of(1,2,3,4,5,6).collect(Collectors.groupingBy( i -> i % 2 == 0 ? "A" : i % 3 == 0 ? "B" : "C")));
        System.out.println(Stream.of(1,2,3).map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(Stream.of(1,2,3,4,5).collect(Collectors.partitioningBy(i -> i > 3)));
        System.out.println(Stream.of(1,2,3).collect(Collectors.toList()));
        System.out.println(Stream.of(1,2,3,4).collect(Collectors.toMap( k -> k, v -> v)));
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};


        Stream.of(mat).forEach(i->System.out.println(Arrays.stream(i).mapToObj(Integer::toString).collect(Collectors.joining(", "))));
        for(int i=0;i<mat.length;i++)for(int j=0;j<mat[i].length;j++)System.out.print(mat[i][j]+(j==mat[i].length-1?"\n":", "));

    }
}
