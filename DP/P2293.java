import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2293 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] coin, dp;

    public static void main(String[] args) throws Exception {
        
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);
        coin = new int[n];
        dp = new int[k+1];
        dp[0] = 1;

        for (int i=0; i<n; i++)
        coin[i] = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++)
        for (int j=1; j<=k; j++)
        if (coin[i]<=j) dp[j] += dp[j-coin[i]];

        System.out.println(dp[k]);
    }
}
