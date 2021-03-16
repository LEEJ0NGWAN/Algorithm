import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P12015 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, len, max;
    static int[] dp;

    static interface l {public int p();}
    static l l = ()->Integer.parseInt(st.nextToken());

    public static int binarySearch(int x, int l, int r) {
        if (l > r) return -1;

        int h = (l+r)/2;
        if (h > 0 && dp[h-1]<x && x<=dp[h]) return h;
        if (x<dp[h]) return binarySearch(x, l, h-1);
        if (dp[h]<x) return binarySearch(x, h+1, r);
        return -1;
    }

    public static void main(String[] args) throws Exception {
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i=0, x; i<n; i++) {
            x = l.p();
            if (dp[len]<x) {
                dp[++len] = x;
                max = Math.max(max, len);
            }
            else {
                int index = binarySearch(x, 0, len);
                if (index!=-1)
                dp[index] = x;
            }
        }
        System.out.println(len);
    }

}
