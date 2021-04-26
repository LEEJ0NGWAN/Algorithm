import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, V;
    static boolean[][] adj;

    static interface l {public int p();}
    static interface r {public void l() throws Exception;}
    static l l = ()->Integer.parseInt(st.nextToken());
    static r r = ()->st = new StringTokenizer(br.readLine());

    static void dfs(int v, boolean[] visit) {
        visit[v] = true;
        sb.append(v).append(' ');

        for (int i=1; i<=N; i++)
        if (!visit[i]&&adj[v][i])
        dfs(i, visit);
    }

    static void bfs(int v, boolean[] visit) {
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(v);
        visit[v] = true;
        
        while (!que.isEmpty()) {
            int p = que.poll();
            sb.append(p).append(' ');
            for (int i=1; i<=N; i++)
            if (!visit[i]&&adj[p][i]) {
                visit[i] = true;
                que.offer(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        r.l();
        N = l.p(); M = l.p(); V = l.p();
        adj = new boolean[N+1][N+1];

        for (int i=1, x, y; i<=M; i++) {
            r.l(); x = l.p(); y = l.p();
            adj[x][y] = adj[y][x] = true;
        }

        dfs(V, new boolean[N+1]);
        sb.append('\n');
        bfs(V, new boolean[N+1]);
        System.out.println(sb);
    }
}
