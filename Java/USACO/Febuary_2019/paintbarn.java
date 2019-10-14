import java.io.*;
import java.util.*;
import java.math.*;

class paintbarn
{
    public static void main(String[] args) throws Exception { new paintbarn().run(); }
    public void run() throws Exception
    {
        Reader file = new Reader(("paintbarn.in"));
        PrintWriter out = new PrintWriter(new File("paintbarn.out"));
        int [][] mat = new int[201][201];
        int n = file.nextInt();
        int k = file.nextInt();
        int bs = 0;
        while(n-->0)
        {
            int x1 = file.nextInt();
            int y1 = file.nextInt();
            int x2 = file.nextInt();
            int y2 = file.nextInt();
            for(int i = y1;i<=y2;i++)
            {
                for(int j=x1;j<=x2;j++)
                {
                    if(mat[i][j]==k) bs--;
                    mat[i][j]++;
                    if(mat[i][j]==k) bs++;
                }
            }
        }
        long [][] kpfs = new long[201][201];
        long [][] kmpfs = new long[201][201];
        for(int i=0;i<201;i++)
        {
            for(int j=0;j<201;j++)
                kpfs[i][j] = (i != 0 ? kpfs[i-1][j]:0) + (j != 0 ? kpfs[i][j-1]:0) + (i!=0&&j!=0? kpfs[i-1][j-1]:0) + (mat[i][j]==k ? 1:0);
        }
        for(int i=0;i<201;i++)
        {
            for(int j=0;j<201;j++)
                kmpfs[i][j] = (i != 0 ? kmpfs[i-1][j]:0) + (j != 0 ? kmpfs[i][j-1]:0) + (i!=0&&j!=0? kmpfs[i-1][j-1]:0) + (mat[i][j]==k-1 ? 1:0);
        }
        int br1 = -1;
        int br2 = -1;
        int bc1 = -1;
        int bc2 = -1;
        long best = Integer.MIN_VALUE;
        System.out.println(bs);
        System.out.println(Arrays.deepToString(kpfs));
        for(int r1=0;r1<201;r1++)
            for(int c1=0;c1<201;c1++)
                for(int r2=r1;r2<201;r2++)
                    for(int c2=c1;c2<201;c2++)
                    {
                        long sum = q(kmpfs,r1,c1,r2,c2) - q(kpfs,r1,c1,r2,c2);
                        if(sum > best)
                        {
                            best = sum;
                            br1 = r1;
                            bc1 = c1;
                            br2 = r2;
                            bc2 = c2;
                        }
                    }
        System.out.println(best);
        if(best>0) bs += best;
        best = Integer.MIN_VALUE;
        for(int r1=0;r1<201;r1++)
            for(int c1=0;c1<201;c1++)
                for(int r2=r1;r2<201;r2++)
                    for(int c2=c1;c2<201;c2++)
                    {
                        if(r2 < br1 || br2 < r1)
                        {

                        }
                        else if(c2 < bc1 || bc2 < c1)
                        {

                        }
                        else continue;
                        long sum = q(kmpfs,r1,c1,r2,c2) - q(kpfs,r1,c1,r2,c2);
                        if(sum > best)
                        {
                            best = sum;
                        }
                    }
        System.out.println(best);
        if(best>0) bs += best;
        out.println(best);
        out.flush();
    }
    long q(long[][] mat,int r1,int c1,int r2,int c2)
    {
        return mat[r2][c2] - mat[r1][c2] - mat[r2][c1] + mat[r1][c1];
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
