import java.io.*;
import java.util.*;
import java.math.*;
class convention2
{
    class cow implements Comparable<cow>
    {
        int start;
        int d;
        int s;
        int des;
        cow(int a,int b,int c)
        {
            start = a;
            des = a;
            d = b;
            s = c;
        }
        public int compareTo(cow o)
        {
            return start - o.start;
        }
        public String toString()
        {
            return start + "-" + (start+d);
        }
        boolean conflict(cow o)
        {
            if(o.start <= start+d) return true;
            return false;
        }
        int dif()
        {
            return start - des;
        }
    }
    public static void main(String[] args) throws Exception
    {
        new convention2().run();
    }
    public void run() throws Exception
    {
        Reader file = new Reader("convention2.in");
        PrintWriter out = new PrintWriter(new File("convention2.out"));
        int n = file.nextInt();
        cow[] cows = new cow[n];
        for(int i=0;i<n;i++) cows[i] = (new cow(file.nextInt(),file.nextInt(),i));
        Arrays.sort(cows);
        System.out.println(Arrays.toString(cows));
        for(int i=0;i<cows.length;i++)
        {
            LinkedList<cow> conflicts = new LinkedList<>();
            for(int j=i+1;j<cows.length;j++)
            {
                if(cows[i].conflict(cows[j])) conflicts.addLast(cows[j]);
                else break;
            }
            Collections.sort(conflicts, 
            new Comparator<cow>() { public int compare(cow a,cow b) {return a.s - b.s;}
            });
            Iterator<cow> it = conflicts.iterator();
            for(int j=i+1;j<i+1+conflicts.size();j++)
            {
                cows[j] = it.next();
                cows[j].start = cows[j-1].start+cows[j-1].d;
            }
            System.out.println(Arrays.toString(cows));
        }
        int max = -1;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,cows[i].dif());
            System.out.println(cows[i].dif());
		}
		System.out.println();
        System.out.println(max);
        out.println(max);
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