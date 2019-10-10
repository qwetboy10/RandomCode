import java.io.*;
import java.util.*;
import java.util.function.*;
public class lambda
{
    public static void main(String[]  args) throws Exception
    {
        new lambda().run();
    }
    public void run() throws Exception
    {
        ArrayList<Integer> nums = new ArrayList<Integer>()
        {
            {
                add(0);
                add(3);
                add(4);
            }
        };
        System.out.println("Number 1:");
        nums.forEach((Integer x) -> System.out.println(x));
        System.out.println("Number 2:");
        //nums.forEach((int x) -> System.out.println(x));
        System.out.println("Number 3:");
        nums.forEach( (x) -> System.out.println(x));
        System.out.println("Number 4:");
        nums.forEach( x -> System.out.println(x));
        System.out.println("Number 5:");
        nums.forEach(System.out::println);
        System.out.println("Number 6:");
        nums.forEach(x -> {
            if(x % 2 == 0)
                System.out.println(x);
            else
                System.out.println("no");
        });
        System.out.println("Number 7:");
        nums.replaceAll( x -> x+1);
        System.out.println(nums);
        System.out.println("Number 8:");
        nums.replaceAll( x -> { if(x % 2 == 0) return x; else return x+1; });
        System.out.println(nums);
        System.out.println("Number 9:");
        Function<Integer,Integer> add3 = x -> x+3;
        System.out.println(add3.apply(3));
        System.out.println("Number 10:");
        Function<Integer, String> odd_even = x -> x % 2 == 0 ? "Even" : "Odd";
        System.out.println(odd_even.apply(4));
        System.out.println("Number 11:");
        Function <Integer,String> x = add3.andThen(odd_even);
        System.out.println(x.apply(3));
        System.out.println("Number 12:");
        Function <String, Boolean> is_odd = s -> s.equals("Odd") ? true : false;
        Function <Integer, Boolean> f = is_odd.compose(odd_even);
        System.out.println(f.apply(4));
        System.out.println("Number 13:");
        Consumer<Integer> con = (Integer n) -> System.out.println(n+7);
        Consumer<Integer> print = System.out::println;
        con.accept(3);
        print.accept(5);
        //types of functions
        //consumers take input and output void - accept
        //functions take input and output 1 value - apply
        //predicates take input and output a boolean - test
        //supplier takes no input and outputs 1 value - get
        //Bi takes 2 inputs
        //Operators have inputs and outputs of the same type
    }
}
