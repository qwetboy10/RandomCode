import java.io.*;
import java.util.*;
import java.math.*;
class highcard
{
    public static void main(String[] args) throws Exception
    {
        new highcard().run();
    }
    public void run() throws Exception
    {
        Reader file = new Reader("highcard.in");
        int N = file.nextInt();
        boolean[] b = new boolean[2*N];
        for(int i=0;i<N;i++) b[file.nextInt()-1] = true;
        int[] el = new int[N];
        int[] be = new int[N];
        int n1 = 0;
        int n2 = 0;
        for(int i=0;i<2*N;i++)
        {
            if(b[i]) el[n1++] = i;
            else be[n2++] = i; 
        }

        System.out.println(Arrays.toString(el));
        System.out.println(Arrays.toString(be));
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
         while(p1 < N && p2 < N)
        {
            if(el[p1] < be[p2])
            {
                p1++;
                p2++;
                sum++;
            }
            else
            {
                p2++;
            }
        }
        PrintWriter out = new PrintWriter(new File("highcard.out"));
        out.println(sum);
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