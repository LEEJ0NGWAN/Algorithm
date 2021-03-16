import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class P11559 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map = new char[12][];
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static boolean bfs(int i, int j) {
        int count = 0;
        char c = map[i][j];
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j});
        visit[i][j]=true;
        while (!que.isEmpty()) {
            int[] p = que.poll();
            count++;

            for (int k=0; k<4; k++) {
                int ny = p[0]+dy[k];
                int nx = p[1]+dx[k];

                if (0<=nx && nx<6 && 0<=ny && ny<12 && !visit[ny][nx] && c==map[ny][nx]) {
                    visit[ny][nx] = true;
                    que.offer(new int[]{ny,nx});
                }
            }
        }

        if (count>=4) {
            que.offer(new int[]{i,j});
            while (!que.isEmpty()) {
                int[] p = que.poll();
                map[p[0]][p[1]]='.';
                for (int k=0; k<4; k++) {
                    int ny = p[0]+dy[k];
                    int nx = p[1]+dx[k];

                    if (0<=nx && nx<6 && 0<=ny && ny<12 && visit[ny][nx] && c==map[ny][nx])
                    que.offer(new int[]{ny,nx});
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {

        for (int i=0; i<12; i++)
        map[i] = br.readLine().toCharArray();

        int count = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            visit = new boolean[12][6];
            for (int j=0; j<6; j++) {
                for (int i=11; i>0; i--)
                if (map[i][j]=='.')
                for (int k=i-1; k>=0; k--)
                if (map[k][j]!='.') {
                    map[i][j] = map[k][j];
                    map[k][j] = '.';
                    break;
                }
            }
            for (int i=0; i<12; i++) {
                for (int j=0; j<6; j++) {
                    if (map[i][j]=='.' || visit[i][j]) continue;
                    boolean res = bfs(i, j);
                    if (!flag && res)
                    flag = res;
                }
            }
            if (flag)
            count++;
        }
        System.out.println(count);
    }
}
