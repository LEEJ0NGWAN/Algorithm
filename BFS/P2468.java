import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2468 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, maxHeight=0, maxCount=0;
    static int[][] map;
    static boolean[][] visit;

    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    static void bfs(int y, int x, int h) {

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{y,x});
        visit[y][x] = true;

        while (!que.isEmpty()) {
            int[] p = que.poll();

            for (int i=0; i<4; i++) {
                int ny = p[0]+dy[i];
                int nx = p[1]+dx[i];

                if (0<=nx && nx<N && 0<=ny && ny<N && map[ny][nx]>h && !visit[ny][nx]) {
                    visit[ny][nx] = true;
                    que.offer(new int[]{ny,nx});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (maxHeight < map[i][j])
                maxHeight = map[i][j];
            }
        }

        for (int h=maxHeight-1; h>=0; h--) {
            visit = new boolean[N][N];
            int count = 0;
            for (int i=0; i<N; i++)
            for (int j=0; j<N; j++)
            if (map[i][j]>h && !visit[i][j]) {
                bfs(i, j, h);
                count++;
            }

            if (maxCount<count) maxCount = count;
        }
        System.out.println(maxCount);
    }
    
}
