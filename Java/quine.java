public class quine
{
    public static void main(String[]  args) throws Exception
    {
		String s = "public class quine{public static void main(String[] args) throws Exception{String s=%c%s%1$c;System.out.printf(s,34,s);}}";
		System.out.printf(s,34,s);
    }
}
