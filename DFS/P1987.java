import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1987 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C, maxCount=0;
    static int[][] map, bit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static void dfs(int i, int j, int d, int b) {
        if (bit[i][j]==b) return;
        bit[i][j] = b;
        maxCount = Math.max(maxCount, d);
        for (int k=0; k<4; k++) {
            int ny = i+dy[k];
            int nx = j+dx[k];

            if (ny<0 || nx<0 || R<=ny || C<=nx || (b&1<<map[ny][nx])!=0)
            continue;
            
            dfs(ny, nx, d+1, b|1<<map[ny][nx]);
        }
    }
    
    public static void main(String[] args) throws Exception {

        String[] tokens = br.readLine().split(" ");
        R = Integer.parseInt(tokens[0]);
        C = Integer.parseInt(tokens[1]);
        map = new int[R][C];
        bit = new int[R][C];
        for (int i=0; i<R; i++) {
            char[] raw = br.readLine().toCharArray();
            for (int j=0; j<C; j++)
            map[i][j] = raw[j]-65;
        }

        dfs(0, 0, 1, 1<<map[0][0]);
        
        System.out.println(maxCount);
    }
}
