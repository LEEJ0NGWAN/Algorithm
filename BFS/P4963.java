import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P {
    int i, j;
    public P (int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class P4963 {    

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int w, h;
    static char[][] map;

    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1};

    public static void bfs(int i, int j) {
        Queue<P> que = new LinkedList<>();
        que.offer(new P(i,j));
        map[i][j] = '0';

        while (!que.isEmpty()) {
            P p = que.poll();

            for (int k = 0; k < 8; k++) {
                int nx = p.j + dx[k];
                int ny = p.i + dy[k];

                if (nx<0 || ny<0 || w<=nx || h<=ny)
                    continue;
                
                if (map[ny][nx] == '1') {
                    map[ny][nx] = '0';
                    que.add(new P(ny,nx));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if ((w+h) == 0)
                break;
            
            map = new char[h][w];
            for (int i = 0; i < h; i++) {
                char[] tmp = br.readLine().toCharArray();
                for (int j = 0; j < w; j++)
                    map[i][j] = tmp[j*2];
            }

            int count = 0;
            for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (map[i][j] == '1') {
                    bfs(i,j);
                    count++;
                }
            
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
