import java.io.*;
import java.util.*;

import java.math.*;
class planting
{
    public static void main(String[] args) throws Exception
    {
        new planting().run();
    }
    void recur(int i)
    {
        if(grass[i] != 0) return;
        LinkedList<Integer> ret = n2(i);
        int small = 0;
        Iterator<Integer> a = ret.iterator();
        for(int j=1;j<=ret.size()&&small==0;j++)
        {
            if(a.next()!=j) small = j;
        }
        if(small==0) small = ret.size()+1;
        grass[i] = small;
        for(int j : k[i]) recur(j);
    }
    LinkedList<Integer> n2 (int i)
    {
        LinkedList<Integer> ret = new LinkedList<>();
        for(int j : k[i])
        {
            if(grass[j] != 0) ret.add(grass[j]);
            ret.addAll(n(j));
        }
        return ret;
    }
    LinkedList<Integer> n (int i)
    {
        LinkedList<Integer> ret = new LinkedList<>();
        for(int j : k[i])
        {
            if(grass[j] != 0) ret.add(grass[j]);
        }
        return ret;
    }
    int[] grass;
    LinkedList<Integer>[] k;
    public void run() throws Exception
    {
		
        Reader file = new Reader("planting.in");
        PrintWriter out = new PrintWriter(new File("planting.out"));
        int n = file.nextInt();
        grass = new int[n];
        k = new LinkedList[n];
        for(int i=0;i<n-1;i++)
        {
            int a = file.nextInt();
            int b = file.nextInt();
            if(k[a-1]==null) k[a-1] = new LinkedList();
            if(k[b-1]==null) k[b-1] = new LinkedList();
            k[a-1].addLast(b-1);
            k[b-1].addLast(a-1);
        }
        int max = 0;
        for(int i=0;i<k.length;i++) max = Math.max(max,k[i].size());
        out.println(max+1);
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