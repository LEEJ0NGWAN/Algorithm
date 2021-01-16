import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P {
    int x, y, z, day;
    public P(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}

public class P7569 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int M, N, H, T, t, days;
    static int[][][] map;

    static int[] dx = { 0, 0, 1, 0, -1, 0 };
    static int[] dy = { 0, 0, 0, 1, 0, -1 };
    static int[] dz = { 1, -1, 0, 0, 0, 0 };

    static boolean check(int a, int b) {
        return (a < 0 || b <= a);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());
        T = M*N*H;
        map = new int[H][N][M];

        Queue<P> que = new LinkedList<>();

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    map[z][y][x] = Integer.parseInt(stringTokenizer.nextToken());
                    if (map[z][y][x] == -1)
                        T--;
                    else if (map[z][y][x] == 1) {
                        t++;
                        que.offer(new P(x,y,z,0));
                    }
                }
            }
        }

        while (!que.isEmpty()) {
            P p = que.poll();

            days = (p.day > days)? p.day : days;

            for (int i = 0; i < 6; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                int z = p.z + dz[i];

                if (check(x, M))
                    continue;
                if (check(y, N))
                    continue;
                if (check(z, H))
                    continue;
                
                if (map[z][y][x] == 0) {
                    t++;
                    map[z][y][x] = 1;
                    que.offer(new P(x,y,z,p.day+1));
                }
            }
        }

        System.out.println((T == t)? days : -1);
    }
}
