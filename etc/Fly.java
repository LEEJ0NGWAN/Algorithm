import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fly {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
    
                for (int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
            }
    
            int max = Integer.MIN_VALUE;
            for (int i=0, l=N-M; i<=l; i++) {
                for (int j=0; j<=l; j++) {
                    int tmp=0;
                    for (int y=0; y<M; y++)
                    for (int x=0; x<M; x++)
                    tmp += map[i+y][j+x];
                    max = (max<tmp)? tmp: max;
                }
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}
