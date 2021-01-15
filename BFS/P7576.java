import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class P {
    int i, j, day;
    public P (int i, int j, int day) {
        this.i = i;
        this.j = j;
        this.day = day;
    }
}

public class P7576 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] di = { 0, 1, 0, -1 };
    static int[] dj = { 1, 0, -1, 0 };

    static int M, N, T, days = 0, t = 0;
    static byte[][] map;

    public static void main(String[] args) throws IOException{
        String[] tokens = br.readLine().split(" ");
        M = Integer.parseInt(tokens[0]);
        N = Integer.parseInt(tokens[1]);
        T = M * N;
        map = new byte[N][M];

        Queue<P> que = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Byte.parseByte(tokens[j]);
                if (map[i][j] == -1)
                    T--;
                else if (map[i][j] == 1) {
                    que.offer(new P(i,j,0));
                    t++;
                }
            }
        }

        while (!que.isEmpty()) {

            P p = que.poll();

            if (days < p.day)
                days = p.day;

            for (byte k = 0; k < 4; k++) {
                int i_ = p.i + di[k];
                int j_ = p.j + dj[k];

                if (i_ < 0 || N <= i_)
                    continue;
                if (j_ < 0 || M <= j_)
                    continue;
                
                if (map[i_][j_] == 0) {
                    t++;
                    map[i_][j_] = 1;
                    que.offer(new P(i_,j_,p.day+1));
                }
            }
        }

        if (T == t)
            System.out.println(days);
        else
            System.out.println(-1);
    }
    
}
