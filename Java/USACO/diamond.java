import java.io.*;
import java.util.*;
import java.math.*;
class diamond
{
    public static void main(String[] args) throws Exception
    {
        new diamond().run();
    }
    public void run() throws Exception
    {
        Reader file = new Reader("diamond.in");
        PrintWriter out = new PrintWriter(new File("diamond.out"));
        int n = file.nextInt();
        int k = file.nextInt();
        int[] r = new int[n];
        boolean[] used = new boolean[n];
        for(int i=0;i<n;i++) r[i] = file.nextInt();
        Arrays.sort(r);
        int sum = -1;
        int p1 = 0;
        int p2 = 0;
        int a1 = -1;
        int a2 = -1;
        while(p2 < n)
        {
            if(r[p2] - r[p1] <= k)
            {
                if(p2 - p1 > sum)
                {
                    sum = p2-p1;
                    a1 = p1;
                    a2 = p2;
                    System.out.println(p1 + " - " + p2);
                }
                p2++;
            }
            else p1++;
        }
        System.out.println(Arrays.toString(r));
        for(int i=a1;i<=a2;i++) r[i] = -1;
        Arrays.sort(r);
        int f = -1;
        for(int i=0;i<n;i++) if(r[i] == -1) f = i;
        int pp1 = f+1;
        int pp2 = f+1;
        int m2 = -1;
        System.out.println(Arrays.toString(r) + " " + f);
        while(pp2 < n)
        {
            if(r[pp2] - r[pp1] <= k)
            {
                if(pp2 - pp1 > m2)
                {
                    m2 = pp2-pp1;
                    System.out.println(pp1 + " - " + pp2);
                }
                pp2++;
            }
            else pp1++;
        }
        System.out.println(sum + " " + m2);
        System.out.println(sum + m2 + 2);
        out.println(sum+m2+2);
        out.close();
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