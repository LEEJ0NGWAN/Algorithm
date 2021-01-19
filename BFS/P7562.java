import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P {
    int x, y, count;
    public P(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class P7562 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, I;
    static int sx, sy, ex, ey;
    static boolean[][] visit;

    static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2};

    static int bfs() {
        Queue<P> que = new LinkedList<>();

        que.offer(new P(sx,sy,0));
        visit[sy][sx] = true;

        while (!que.isEmpty()) {
            P p = que.poll();

            if (p.x == ex && p.y == ey)
                return p.count;
            
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx<0 || ny<0 || I<=nx || I<=ny)
                    continue;
                
                if (visit[ny][nx])
                    continue;
                
                que.offer(new P(nx, ny, p.count+1));
                visit[ny][nx] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        
        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            visit = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            arr[t] = bfs();
        }

        for (int count : arr)
            System.out.println(count);
    }
    
}
