import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ladder {
    
    static java.io.BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[100][100];

    static class P {
        int i, j, d;
        P(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }
    }

    public static boolean bfs(int i, int j) {
        Queue<P> que = new LinkedList<>();
        que.offer(new P(i,j,0));

        while(!que.isEmpty()) {
            P p = que.poll();

            if (map[p.i][p.j] == 2)
            return true;

            int l = p.j-1;
            int r = p.j+1;
            int b = p.i+1;

            if (0<=l && map[p.i][l]==1 && p.d!=1)
            que.offer(new P(p.i,l,-1));
            else if (r<100 && map[p.i][r]==1 && p.d!=-1)
            que.offer(new P(p.i,r,1));
            else if (b<100 && map[b][p.j]!=0)
            que.offer(new P(b,p.j,0));
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=10; t++) {
            br.readLine();
            for (int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<100; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j=0; j<100; j++) {
                if (map[0][j] == 0) continue;

                if (bfs(0, j)) {
                    sb.append("#"+t+" "+j+"\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
