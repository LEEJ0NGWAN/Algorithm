import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9205 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T, N;

    public static void main(String[] args) throws Exception {
        
        T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            int[][] pos = new int[N+2][2];
            int[][] dist = new int[N+2][N+2];

            for (int i=0; i<N+2; i++) {
                String[] tokens = br.readLine().split(" ");
                pos[i][0] = Integer.parseInt(tokens[0]);
                pos[i][1] = Integer.parseInt(tokens[1]);
            }

            for (int i=0; i<N+2; i++)
            for (int j=0; j<N+2; j++) {
                if (i==j) continue;
                if (Math.abs(pos[i][0]-pos[j][0]) + Math.abs(pos[i][1]-pos[j][1])>1000)
                dist[i][j] = Integer.MAX_VALUE;
            }


            for (int k=0; k<N+2; k++)
            for (int i=0; i<N+2; i++)
            for (int j=0; j<N+2; j++) {
                if (i==j || i==k || j==k) continue;
                if (dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE)
                dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
            }
            sb.append(dist[0][N+1]==Integer.MAX_VALUE?"sad":"happy").append('\n');
        }
        System.out.print(sb);
    }
}
