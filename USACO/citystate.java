import java.io.*;
import java.util.*;
import java.math.*;
class citystate
{
    public static void main(String[] args) throws Exception
    {
        new citystate().run();
    }
    public void run() throws Exception
    {
        Reader file = new Reader("citystate.out");
        PrintWriter out = new PrintWriter(new File("citystate.in"));
        HashMap<String,String> c2s = new HashMap<>();
        HashMap<String,LinkedList<String>> s2c = new HashMap<>();
        HashSet<String> dups = new HashSet<String>();
        int n = file.nextInt();
        String[] cities = new String[n];
        String[] states = new String[n];
        int c = 0;
        while(file.hasNext())
        {
            cities[c] = file.next();
            states[c++] = file.next();
            if(s2c.get(states[c-1])==null) s2c.put(states[c-1],new LinkedList<String>());
            s2c.get(states[c-1]).add(cities[c-1]);
        }
        System.out.println(c2s);
        int ca = 0;
        for(int i=0;i<n;i++)
        {
            LinkedList<String> a = s2c.get(states[i]);
            if(a == null) continue;
            for(String s : a)
            {
                String k = s.substring(0,2);
                LinkedList<String> b = s2c.get(k);
                if(b == null) continue;
                for(String s2 : b)
                {
                    if(s2.substring(0,2).equals(states[i]))
                    {
                        System.out.println(i + " " +s + " " + s2);
                        ca++;
                    }
                }
            }
        }
        System.out.println(ca);
        out.println(ca);
    }
    static class Reader {
		private int BUFFER_SIZE = 1 << 16;
		private char nullChar = (char) 0;
		private byte[] buf = new byte[BUFFER_SIZE];
		private int bufferPointer = 0, bytesRead = 0;
		private char c = nullChar;
		private double num = 1;
		private BufferedInputStream in;
		private char delimeter = ' ';

		public Reader() {
			in = new BufferedInputStream(System.in, BUFFER_SIZE);
		}

		public Reader(String s) throws FileNotFoundException {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)),
						BUFFER_SIZE);
			} catch (FileNotFoundException e) {
				throw new FileNotFoundException();
			}

		}

		public char nextChar() {
			while (bufferPointer == bytesRead) {
				try {
					bytesRead = in.read(buf);
				} catch (Exception e) {
					return nullChar;
				}
				if (bytesRead == -1)
					return nullChar;
				bufferPointer = 0;
			}
			try {
				return (char) buf[bufferPointer++];
			} catch (ArrayIndexOutOfBoundsException e) {
				throw new InputMismatchException();
			}

		}

		public int nextInt() {
			return (int) nextLong();
		}

		public long nextLong() {
			num = 1;
			boolean neg = false;
			if (c == nullChar)
				c = nextChar();
			for (; (c < '0' || c > '9'); c = nextChar()) {
				if (c == '-')
					neg = true;
			}
			long res = 0;
			for (; c >= '0' && c <= '9'; c = nextChar()) {
				res = (res << 3) + (res << 1) + c - '0';
				num *= 10;
			}
			return neg ? -res : res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c != '.' ? cur : cur + nextLong() / num;
		}

		public BigInteger nextBigInteger() {
			if (c == nullChar)
				c = nextChar();
			if (!Character.isDigit(c) && c != '-') {
				throw new InputMismatchException();
			}
			StringBuilder strNum = new StringBuilder();
			while (Character.isDigit(c) || c == '-') {
				strNum.append(c);
				c = nextChar();
			}
			return new BigInteger(strNum.toString());
		}

		public BigDecimal nextBigDecimal() {
			if (c == nullChar)
				c = nextChar();
			if (!Character.isDigit(c) && c != '-' && c != '.') {
				throw new InputMismatchException();
			}
			StringBuilder strNum = new StringBuilder();
			while (Character.isDigit(c) || c == '-' || c == '.') {
				strNum.append(c);
				c = nextChar();
			}
			return new BigDecimal(strNum.toString());
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while (c < 32 || c == delimeter)
				c = nextChar();
			while (c >= 32 && c != delimeter) {
				res.append(c);
				c = nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while (c < 32)
				c = nextChar();
			while (c != '\n' && c >= 32) {
				res.append(c);
				c = nextChar();
			}
			return res.toString().replaceAll("\r", "");
		}

		public char delimeter() {
			return delimeter;
		}

		public void useDelimeter(char c) {
			delimeter = c;
		}

		public boolean hasNext() {
			if (c >= 32 && c != delimeter)
				return true;
			while (true) {
				c = nextChar();
				if (c == nullChar)
					return false;
				else if (c > 32)
					return true;
			}
		}

	}
}