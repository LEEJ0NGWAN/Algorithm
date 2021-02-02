import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Snail {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int[][] map;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            int d=0, x=0, y=0;
            for (int i=0, n=1, max=N*N; i<max; i++) {
                map[y][x] = n++;
                int nx = x+dx[d];
                int ny = y+dy[d];
                if (nx<0 || ny<0 || N<=nx || N<=ny || map[ny][nx] != 0) {
                    d = (d+1)%4;
                    nx = x+dx[d];
                    ny = y+dy[d];
                }
                x = nx;
                y = ny;
            }

            sb.append("#"+t+"\n");
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++)
                sb.append(map[i][j]+" ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
