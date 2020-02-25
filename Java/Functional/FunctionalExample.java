import java.io.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class FunctionalExample
{
    public static void main(String[] args) throws Exception
    {
        System.out.println(
            Stream.of(1,2,2,3,3,3,3,5)
            .collect(
                collectingAndThen(
                    groupingBy(
                        x->x,
                        counting()),
                    x -> x.entrySet()
                    .stream()
                    .max(
                        (a,b) -> 
                        Long.compare(a.getValue(), b.getValue()))))
            .get().getKey());

        System.out.println(
            "abdawdjla".chars()
            .mapToObj(x -> {
                char c = (char)(x+3);
                if(c > 'z') c -= 26;
                return String.valueOf(c);
            })
            .collect(joining()));
            
        System.out.println(
            String.join(", ", 
                Stream.iterate(3, x->x<10, x->x+1)
                    .map(Object::toString)
                    .collect(toList())));
                
        System.out.println("awndkadk\n12233\nabc"
            .lines()
            .map(x->x.substring(1,x.length()-1))
            .collect(toMap(x->x,x->x.length())));

        Scanner file = new Scanner("aijd\nlaj dw\ndoa i jd  iawjd\naw dj");
        System.out.println(file.tokens()
            .min((x,y)->Integer.compare(x.length(),y.length()))
            .get());

        Iterator<String> i = Arrays.asList(new String[] {"A","B","C"}).iterator();
        i.forEachRemaining(x -> {
            System.out.print(x);
        });
        System.out.println();

        Map<Integer,Integer> a = Stream.iterate(0,x->x<12,x->x+2).collect(toMap(x->x,x->3+x*5));
        System.out.println(a);
        Stream.iterate(0, x->x<12, x->x+1).forEach(x->a.compute(x, (k,v) -> v == null ? x : x-v));
        System.out.println(a);

        Map<Integer,Integer> b = Stream.of(1,3,5,7,9).collect(toMap(x->x,x->x+5));
        Stream.iterate(0, x->x<=10, x->x+1).forEach(x->b.merge(x, x, Integer::sum));
        System.out.println(b);

        System.out.println(Stream.of(23,52,35,24,23,74).collect(reducing((x,y) -> x^y)).get());

        System.out.println(Stream.of(1,2,3,4,5,6,7,8,9,10).collect(partitioningBy(x->x<5)).get(false));

        System.out.println(IntStream.range(1,5).summaryStatistics().getAverage());
        System.out.println(IntStream.range(1,5).average().getAsDouble());

        Character[][] mat = "abc\ndef\nghi".lines().map(x->x.chars().mapToObj(y->(char) y).toArray(Character[]::new)).toArray(Character[][]::new);
        //solve a maze or something
        Arrays.stream(mat).flatMap(x -> Stream.concat(Arrays.stream(x),Stream.of("\n"))).forEach(System.out::print);
    }
}
