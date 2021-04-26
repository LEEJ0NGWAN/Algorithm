import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1767 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, maxCount, minLength;
    static ArrayList<int[]> list;
    static int[][] map;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static void dfs(int index, int count, int length) {
        if (index==list.size()) {
            if (maxCount<count) {
                maxCount=count;
                minLength=length;
            }
            else if (maxCount==count && length<minLength)
            minLength = length;
            return;
        }

        for (int d=0; d<4; d++) {

            int l = 0;
            int x = list.get(index)[1];
            int y = list.get(index)[0];
            int nx = x + dx[d];
            int ny = y + dy[d];

            while (0<=nx && 0<=ny && nx<N && ny<N) {
                if (map[ny][nx]==1) {
                    l=0;
                    break;
                }
                nx = nx+dx[d];
                ny = ny+dy[d];
                l++;
            }
            if (l!=0) {
                ny = y; nx = x;
                for (int i=0; i<l; i++) {
                    nx = nx+dx[d];
                    ny = ny+dy[d];
                    map[ny][nx]=1;
                }
                dfs(index+1, count+1, length+l);
                ny = y; nx = x;
                for (int i=0; i<l; i++) {
                    nx = nx+dx[d];
                    ny = ny+dy[d];
                    map[ny][nx]=0;
                }
            }
        }
        dfs(index+1, count, length);
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            list = new ArrayList<>();
            maxCount = 0;
            minLength = 144;
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (0<i && i<N-1 && 0<j && j<N-1 && map[i][j]==1)
                    list.add(new int[]{i,j});
                }
            }

            dfs(0, 0, 0);

            sb.append("#").append(t).append(" ").append(maxCount==0? 0:minLength).append("\n");
        }
        System.out.println(sb);
    }
}
