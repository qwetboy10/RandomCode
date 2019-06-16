import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class template {
	public static void main(String[] args) throws Exception {
		new template().run();
	}
	public void run() throws Exception {
		FastScanner f = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
                char[] c = f.next().toCharArray();
                char[] s = f.next().toCharArray();
                char[] t = f.next().toCharArray();
                int[] sk = get(s), tk = get(t);
                int[][][] dp = new int[c.length][s.length][t.length];
                out.flush();
	}
        public int[] get(char[] c) {
            int[] kmp = new int[c.length];
            int r = -1;
            for(int i = 1; i < c.length; i++) {
                int m = kmp[i-1];
                while(m != 0 && c[m] != c[i]) m = kmp[m-1];
                if(c[m] == c[i]) kmp[i] = m+1;
                else kmp[i] = 0;
            }
            return kmp;
        }
    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }
}
