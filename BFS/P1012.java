import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class P {
    int i, j;
    public P(int i, int j) {
        this.i = i;
        this.j = j;
    }
}

public class P1012 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, M, N, B;
    static boolean[][] map;

    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    static void bfs(int i, int j) {
        Queue<P> que = new LinkedList<>();
        que.offer(new P(i, j));
        map[i][j] = false;

        while (!que.isEmpty()) {
            P p = que.poll();

            for (int k = 0; k < 4; k++) {
                int i_ = p.i + di[k];
                int j_ = p.j + dj[k];

                if (i_ < 0 || N <= i_)
                    continue;
                if (j_ < 0 || M <= j_)
                    continue;
                
                if (map[i_][j_]) {
                    map[i_][j_] = false;
                    que.offer(new P(i_, j_));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        int[] countInfo = new int[T];

        for (int t = 0; t < T; t++) {
            String[] tokens = br.readLine().split(" ");
            M = Integer.parseInt(tokens[0]);
            N = Integer.parseInt(tokens[1]);
            B = Integer.parseInt(tokens[2]);

            map = new boolean[N][M];

            for (int i = 0; i < N; i++)
                for (int j = 0; j < M; j++)
                    map[i][j] = false;

            for (int b = 0; b < B; b++) {
                tokens = br.readLine().split(" ");
                map[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[0])] = true;
            }

            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            countInfo[t] = count;
        }

        for (int count : countInfo)
            System.out.println(count);
    }
}
