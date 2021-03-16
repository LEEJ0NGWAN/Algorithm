import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1992 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static char[][] map;

    static String foo(int n, int i, int j) {
        if (n==1) return String.valueOf(map[0][0]);
        if (n==2) {
            int c = map[i][j]^map[i][j+1];
            int r = map[i][j]^map[i+1][j];
            int d = map[i][j]^map[i+1][j+1];
            if (c+r+d==0)
            return String.valueOf(map[i][j]);
            return "("+map[i][j]+map[i][j+1]+map[i+1][j]+map[i+1][j+1]+")";
        }

        String s1 = foo(n/2, i, j);
        String s2 = foo(n/2, i, j+n/2);
        String s3 = foo(n/2, i+n/2, j);
        String s4 = foo(n/2, i+n/2, j+n/2);

        if ((s1.equals("0")||s1.equals("1")) && 
        s1.equals(s2) && s2.equals(s3) && s3.equals(s4) && s4.equals(s1))
        return s1;
        return "("+s1+s2+s3+s4+")";
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i=0; i<N; i++)
        map[i] = br.readLine().toCharArray();

        bw.write(foo(N,0,0)); bw.newLine(); bw.flush();
        bw.close(); br.close();
    }
}