import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2565 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dp = new int[502];
    static int[] arr = new int[501];

    public static void main(String[] args) throws Exception {
        
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<=500; dp[++i]=1) if (arr[i]!=0)
        for (int j=1; j<i; j++) if (arr[j]!=0 && arr[j]<arr[i])
        dp[i] = Math.max(dp[i], dp[j]+1);

        int max = 0;
        for (int i=1; i<=500; i++)
        if (max < dp[i]) max = dp[i];

        System.out.println(n-max);
    }
}
