import java.io.*;
import java.util.*;

import java.math.*;
class perimiter
{
    public static void main(String[] args) throws Exception
    {
        new perimiter().run();
    }
    public long blobsize(int r,int c)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat.length && !visited[r][c] && mat[r][c])
        {
            visited[r][c] = true;
            long perimiter = 0;
            if(c==0||!mat[r][c-1]) perimiter++;
            if(r==0||!mat[r-1][c]) perimiter++;
            if(c==mat.length-1||!mat[r][c+1]) perimiter++;
            if(r==mat.length-1||!mat[r+1][c]) perimiter++;
            return (perimiter*10000000) + 1 + blobsize(r+1, c) + blobsize(r-1, c) + blobsize(r, c+1) + blobsize(r, c-1);
        }
        return 0;
    }
    boolean[][] mat;
    boolean[][] visited;
    public void run() throws Exception
    {
		
        Reader file = new Reader("perimeter.in");
        PrintWriter out = new PrintWriter(new File("perimeter.out"));
        int n = file.nextInt();
        mat = new boolean[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            String s = file.nextLine();
            for(int j=0;j<s.length();j++) mat[i][j] = s.charAt(j)=='#';
        }
        long maxArea = -1;
        long minPerimiter = -1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]) continue;
                long kk = blobsize(i, j);
                long perim = kk / 10000000L;
                long area = kk % 10000000L;
                if(area > maxArea)
                {
                    maxArea = area;
                    minPerimiter = perim;
                }
                else if(area == maxArea)
                {
                    if(perim < minPerimiter)
                        minPerimiter = perim;
                }
            }
        }
        out.println(maxArea + " " + minPerimiter);
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