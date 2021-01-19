import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class P {
    int x, y, dis, drill;
    public P (int x, int y, int dis, int drill) {
        this.x = x; this.y = y; this.dis = dis;
        this.drill = drill;
    }
}

public class P2206 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int M, N;
    static char[][] map;
    static int[][] visit;

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static int bfs() {
        int x = M-1, y = N-1;

        Queue<P> que = new LinkedList<>();
        que.offer(new P(0,0,1,0));
        visit[0][0] = 0;

        while (!que.isEmpty()) {
            P p = que.poll();

            if (p.x == x && p.y == y)
                return p.dis;

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || N <= ny || M <= nx)
                    continue;
                
                if (visit[ny][nx] <= p.drill)
                    continue;
                
                if (map[ny][nx] == '0') {
                    visit[ny][nx] = p.drill;
                    que.offer(new P(nx,ny,p.dis+1,p.drill));
                }
                else if (p.drill == 0) {
                    visit[ny][nx] = p.drill+1;
                    que.offer(new P(nx,ny,p.dis+1,p.drill+1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);
        map = new char[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++)
                visit[i][j] = 2;
        }

        System.out.println(bfs());
    }
}