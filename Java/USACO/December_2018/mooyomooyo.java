import java.io.*;
import java.util.*;
import java.math.*;
class mooyomooyo
{
    public static void main(String[] args) throws Exception
    {
        new mooyomooyo().run();
    }
    char[][] mat;
    boolean[][] visited;
    void delete(int r,int c,int ch)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c]==ch)
        {
            mat[r][c]='0';
            delete(r+1,c,ch);
            delete(r-1,c,ch);
            delete(r,c+1,ch);
            delete(r,c-1,ch);
        }
    }
    int size(int r,int c,int ch)
    {
        if(r >= 0 && r < mat.length && c >= 0 && c < mat[r].length && mat[r][c]==ch && !visited[r][c])
        {
            visited[r][c] = true;
            return 1 + 
            size(r+1,c,ch) +
            size(r-1,c,ch) +
            size(r,c+1,ch) + 
            size(r,c-1,ch);
        }
        else return 0;
    }
    void shift()
    {
        LinkedList<Character>[] cols = new LinkedList[10];
        for(int i=0;i<10;i++) cols[i] = new LinkedList<Character>();
        for(int j=0;j<10;j++)
        {
            for(int i=0;i<mat.length;i++)
            {
                if(mat[i][j]!='0') cols[j].addLast(mat[i][j]);
            }
        }
        System.out.println(Arrays.toString(cols));
        for(int j=0;j<10;j++)
        {
            int ka = mat.length-cols[j].size();
            for(int i=0;i<mat.length;i++)
            {
                if(i<ka) mat[i][j] = '0';
                else mat[i][j] = cols[j].removeFirst();
                
            }
        }
    }
    boolean done()
    {
        for(int i=0;i<mat.length-1;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(mat[i][j]!='0'&&mat[i+1][j]=='0') return false;
            }
        }
        return true;
    }
    public void run() throws Exception
    {
        Reader file = new Reader("mooyomooyo.in");
        PrintWriter out = new PrintWriter(new File("mooyomooyo.out"));
        int n = file.nextInt();
        int k = file.nextInt();
        mat = new char[n][10];
        for(int i=0;i<n;i++) mat[i] = file.nextLine().toCharArray();
        visited = new boolean[n][10];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<10;j++)
            {
                if(!visited[i][j] && mat[i][j]!='0')
                {
                    int a = size(i,j,mat[i][j]);
                    if(a >= k) delete(i,j,mat[i][j]);
                }
            }
        }
        while(!done())
        {
            shift();
            visited = new boolean[n][10];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<10;j++)
                {
                    if(!visited[i][j] && mat[i][j]!='0')
                    {
                        int a = size(i,j,mat[i][j]);
                        if(a >= k) delete(i,j,mat[i][j]);
                    }
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            StringBuffer tmp = new StringBuffer();
            for(int j=0;j<10;j++) tmp.append(mat[i][j]);
            out.println(tmp.toString());
        }
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