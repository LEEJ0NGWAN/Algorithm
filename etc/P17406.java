import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17406 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K, ans=Integer.MAX_VALUE;
    static int[] arr;
    static int[][] map, copy, info;

    static void init() {
        for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
        copy[i][j] = map[i][j];
    }

    static void rotate(int[] pos) {

        int y = pos[0];
        int x = pos[1];
        int d = pos[2];

        int r = 1;
        while (r<=d) {
            int tmp = copy[y-r][x-r];
            for (int i=y-r; i<y+r; i++)
            copy[i][x-r] = copy[i+1][x-r];

            int tmp2 = copy[y-r][x+r];
            for (int j=x+r; j>x-r+1; j--)
            copy[y-r][j] = copy[y-r][j-1];
            copy[y-r][x-r+1] = tmp;

            tmp = copy[y+r][x+r];
            for (int i=y+r; i>y-r+1; i--)
            copy[i][x+r] = copy[i-1][x+r];
            copy[y-r+1][x+r] = tmp2;

            tmp2 = copy[y+r][x-r];
            for (int j=x-r; j<x+r-1; j++)
            copy[y+r][j] = copy[y+r][j+1];
            copy[y+r][x+r-1] = tmp;

            r++;
        }
    }

    static void dfs(int count, int visit) {

        if (count==K) {
            init();
            for (int i=0; i<K; i++)
            rotate(info[arr[i]]);

            for (int i=0; i<N; i++) {

                int res = 0;
                for (int j=0; j<M; j++)
                res += copy[i][j];

                if (ans > res)
                    ans = res;
            }
            return;
        }

        for (int i=0; i<K; i++) {
            if ((visit&1<<i)!=0) continue;

            arr[count] = i;
            dfs(count+1, visit|1<<i);
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        map = new int[N][M];
        copy = new int[N][M];
        info = new int[K][3];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
            map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken())-1;
            info[i][1] = Integer.parseInt(st.nextToken())-1;
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);
    }
}
