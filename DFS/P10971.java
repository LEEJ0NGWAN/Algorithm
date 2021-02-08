import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, min=Integer.MAX_VALUE;
    static int[][] map;
    static boolean[] visit;

    static void dfs(int n, int cost, int count, int start) {
        if (count==N) {
            if (map[n][start] != 0)
            min = Math.min(min, cost+map[n][start]);
            return;
        }

        for (int i=0; i<N; i++) {
            if (visit[i] || map[n][i]==0) continue;
            
            visit[i] = true;
            dfs(i, cost+map[n][i], count+1, start);
            visit[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];
        
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++)
            map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++) {
            visit[i] = true;
            dfs(i,0,1,i);
            visit[i] = false;
        }
        System.out.println(min);
    }
}
