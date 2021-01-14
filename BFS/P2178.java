import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class P {
    int i, j, count;
    public P (int i, int j, int count) {
        this.i = i; this.j = j;
        this.count = count;
    }
}

public class P2178 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] di = { 0, 1, 0, -1 };
    static int[] dj = { 1, 0, -1, 0 };

    static int N, M;
    static char[][] map;

    static int bfs() {

        Queue<P> que = new LinkedList<>();
        que.offer(new P(0, 0, 1));
        map[0][0] = '0';

        int[] dest = { N-1, M-1 };

        while (!que.isEmpty()) {
            P p = que.poll();

            if (p.i == dest[0] && p.j == dest[1])
                return p.count;

            for (int k = 0; k < 4; k++) {
                int i_ = p.i + di[k];
                int j_ = p.j + dj[k];

                if (i_ < 0 || N <= i_)
                    continue;
                if (j_ < 0 || M <= j_)
                    continue;
                
                if (map[i_][j_] == '1') {
                    map[i_][j_] = '0';
                    que.offer(new P(i_, j_, p.count+1));
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

        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();
        
        System.out.println(bfs());
    }
}
