import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16236 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, sharkSize = 2, eatCount, fishCount, ans;
    static boolean[][] visit;
    static int[][] map;
    static int[] shark;

    static int[] dx = {0, -1, 1, 0};
    static int[] dy = {-1, 0, 0, 1};

    static boolean nextEat() {
        if (fishCount==0) return false;
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{shark[0], shark[1], 0});
        visit = new boolean[N][N];
        visit[shark[0]][shark[1]] = true;

        ArrayList<int[]> target = new ArrayList<>();
        int targetDist = 1000;
        while (!que.isEmpty()) {
            int[] p = que.poll();

            if (targetDist<=p[2]) continue;

            for (int i=0; i<4; i++) {
                int ny = p[0] + dy[i];
                int nx = p[1] + dx[i];
                if (0<=ny && ny<N && 0<=nx && nx<N && !visit[ny][nx] && map[ny][nx]<=sharkSize) {
                    visit[ny][nx] = true;
                    if (0<map[ny][nx] && map[ny][nx]<sharkSize) {
                        if (targetDist==1000)
                        targetDist = p[2]+1;
                        target.add(new int[]{ny,nx});
                    }
                    else
                    que.offer(new int[]{ny, nx, p[2]+1});
                }
            }
        }

        if (targetDist!=1000) {

            int ny=20, nx=20;
            for (int[] fish: target)
            if (fish[0]<ny || (fish[0]==ny && fish[1]<nx)) {
                ny = fish[0];
                nx = fish[1];
            }
    
            map[shark[0]][shark[1]] = 0;
            map[ny][nx] = 9;
            shark[0] = ny;
            shark[1] = nx;
            fishCount--;
            if (++eatCount==sharkSize) {
                eatCount = 0;
                sharkSize++;
            }
            ans += targetDist;
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) shark = new int[]{i, j};
                if (0<map[i][j]&&map[i][j]<=6) fishCount++;
            }
        }

        while(nextEat());
        System.out.println(ans);
    }
}