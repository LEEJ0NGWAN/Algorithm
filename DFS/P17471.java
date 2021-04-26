import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17471 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans=Integer.MAX_VALUE;
    static int[] arr;
    static boolean[][] adj;

    static boolean check(int start, int dest, int visit, int bit, boolean isLeft) {

        if (start==dest || adj[start][dest]) return true;

        for (int next=1; next<=N; next++) {
            if (!adj[start][next]) continue;
            if ((visit&1<<(next-1))!=0) continue;

            if (isLeft && (bit&1<<(next-1))!=0 && check(next, dest, visit|1<<(next-1), bit, isLeft))
            return true;

            if (!isLeft && (bit&1<<(next-1))==0 && check(next, dest, visit|1<<(next-1), bit, isLeft))
            return true;
        }

        return false;
    }

    static void dfs(int bit, int size, int count, int pivot) {

        if (size==count) {

            int lSum = 0, rSum = 0;
            for (int i=1; i<=N; i++) {
                boolean isLeft = true;
                if ((bit&1<<(i-1))==0) {
                    rSum += arr[i];
                    isLeft = false;
                }
                else lSum += arr[i];

                boolean flag = false;
                for (int j=1; j<=N; j++) {
                    if (isLeft && (bit&1<<(j-1))!=0 && !check(i, j, 1<<(i-1), bit, isLeft)) {
                        flag = true;
                        break;
                    }
                    if (!isLeft && (bit&1<<(j-1))==0 && !check(i, j, 1<<(i-1), bit, isLeft)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) return;
            }
            int diff = Math.abs(lSum-rSum);
            if (ans > diff)
                ans = diff;
            return;
        }

        for (int i=pivot+1; i<N; i++)
        dfs(bit|1<<i, size, count+1, i);
    }

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        adj = new boolean[N+1][N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++)
        arr[i] = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for (int j=0; j<l; j++) {
                int x = Integer.parseInt(st.nextToken());
                adj[i][x] = adj[x][i] = true;
            }
        }

        for (int leftSize=1; leftSize<N; leftSize++) {
            for (int i=0; i<N; i++) {
                dfs(1<<i, leftSize, 1, i);
            }
        }

        System.out.println(ans==Integer.MAX_VALUE? -1: ans);
    }
    
}
