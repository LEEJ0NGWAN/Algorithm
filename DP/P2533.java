import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class P2533 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer>[] adj;
    static int[][] dp;
    static int N;

    static void foo(int current, int parent) {
        dp[current][0] = 0;
        dp[current][1] = 1;

        for (int i=0, l=adj[current].size(); i<l; i++) {
            int next = adj[current].get(i);
            if (next!=parent) {
                foo(next, current);
                dp[current][0] += dp[next][1];
                dp[current][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        adj = new LinkedList[N+1];
        dp = new int[N+1][2];

        for (int i=1; i<=N; i++)
        adj[i] = new LinkedList<>();

        for (int i=0; i<N-1; i++) {
            String[] tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);

            adj[a].add(b);
            adj[b].add(a);
        }
        foo(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    
}
