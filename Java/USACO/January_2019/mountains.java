import java.io.*;
import java.util.*;

import java.math.*;
class mountains
{
    public static void main(String[] args) throws Exception
    {
        new mountains().run();
    }
    public void run() throws Exception
    {
		
        Reader file = new Reader("mountains.in");
        PrintWriter out = new PrintWriter(new File("mountains.out"));
        int n = file.nextInt();
        Pair[] p = new Pair[n];
        for(int i=0;i<n;i++)
        {
            p[i] = new Pair(file.nextLong(),file.nextLong());
        }
        Arrays.sort(p);
        for(int i=0;i<p.length;i++)
        {
            Pair q = p[i];
            long min = q.x - q.y;
            long max = q.x + q.y;
            int i1 = Arrays.binarySearch(p, new Pair(min,0));
            int i2 = Arrays.binarySearch(p, new Pair(max,0));
			if(i1<0) i1 = -1 * (i1+1);
			w6hwrv%%vhnd
            if(i2<0) i2 = -1 * (i2+1);
            if(i2 >= p.length) i2--;
            for(int j=i1;j<=i2;j++) if(i != j && q.behind(p[j])) p[j].obscured = true;
        }
        int N = 0;
        for(int i=0;i<p.length;i++) if(!p[i].obscured) N++;
        out.println(N);
		out.close();
    }
    class Pair implements Comparable<Pair>
    {
        public String toString() { return x + " " + y;}
        long x;
        long y;
        long width;
        boolean obscured;
        Pair(long a,long b)
        {
            x = a;
            y = b;
            width = 2*y;
        }
        boolean behind(Pair o)
        {
            if(o.x >= (x-y) && o.x <= (x+y))
            {
                if(o.y <= y - Math.abs(o.x - x)) return true;
                return false;
            }
            return false;
        }
        public int compareTo(Pair o)
        {
            return (int) (x - o.x);
        }
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