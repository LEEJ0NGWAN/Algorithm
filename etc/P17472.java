import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P17472 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, islandCount, index=1;
    static int[][] map, adj;
    static boolean[][] visit;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static void bfs(int i, int j) {
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[]{i,j});
        visit[i][j] = true;
        map[i][j] = index;

        while(!que.isEmpty()) {

            int[] p = que.poll();

            for (int d=0; d<4; d++) {
                int ny = p[0]+dy[d];
                int nx = p[1]+dx[d];

                if (0<=ny && ny<N && 0<=nx && nx<M && !visit[ny][nx] && map[ny][nx]==1) {
                    visit[ny][nx] = true;
                    map[ny][nx] = index;
                    que.offer(new int[]{ny,nx});
                }
            }
        }
        index++;
    }

    static void setEdge() {
        for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
        if (map[i][j]!=0) {
            int from = map[i][j]-1;
            for (int d=0; d<4; d++) {
                int dist = 0;
                int ny = i + dy[d];
                int nx = j + dx[d];

                while (0<=ny && ny<N && 0<=nx && nx<M && map[ny][nx]==0) {

                    dist++;
                    
                    ny += dy[d];
                    nx += dx[d];
                }

                if (dist>1 && 0<=ny && ny<N && 0<=nx && nx<M) {
                    int to = map[ny][nx]-1;
                    adj[from][to] = adj[to][from] = Integer.min(adj[from][to], dist);
                }
            }
        }
    }

    static void prim() {
        boolean[] check = new boolean[islandCount+1];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        check[0] = true;

        int sum = 0, pre = 0;
        while (pre != que.size()) {
            pre = que.size();
            int minDist=Integer.MAX_VALUE, next=0;
            for (int v: que) {
                for (int i=0; i<islandCount; i++) {
                    if (v==i || check[i]) continue;
                    
                    if (minDist > adj[v][i]) {
                        minDist = adj[v][i];
                        next = i;
                    }
                }
            }
            if (minDist!=Integer.MAX_VALUE) {
                check[next] = true;
                que.offer(next);
                sum += minDist;
            }
        }
        System.out.println(que.size()==islandCount?sum:-1);
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
            map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
        if (map[i][j]==1 && !visit[i][j]) {
            bfs(i, j);
            islandCount++;
        }

        adj = new int[islandCount][islandCount];
        for (int i=0; i<islandCount; i++)
        for (int j=0; j<islandCount; j++)
        if (i!=j)
        adj[i][j] = Integer.MAX_VALUE;

        setEdge();
        prim();
    }
}
