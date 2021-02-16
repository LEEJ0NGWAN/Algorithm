import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class P20420 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R, C, K;
    static int[][] map;
    static int[][][] dist;
    static Edge[][] edge;
    static Hashtable<Character, Integer> hash = new Hashtable<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class P {
        int i, j, l, r;
        public P (int i, int j, int l, int r) {
            this.i = i;
            this.j = j;
            this.l = l;
            this.r = r;
        }
    }

    static class Edge {
        ArrayList<P> e = new ArrayList<>();
    }

    static {
        hash.put('U',0);
        hash.put('R',1);
        hash.put('D',2);
        hash.put('L',3);
    }

    public static void main(String[] args) throws Exception {
        String[] tokens = br.readLine().split(" ");
        R = Integer.parseInt(tokens[0]);
        C = Integer.parseInt(tokens[1]);
        K = Integer.parseInt(tokens[2]);
        map = new int[R][C];
        dist = new int[R][C][K+1];
        edge = new Edge[R][C];

        for (int i=0; i<R; i++) {
            char[] raw = br.readLine().toCharArray();
            for (int j=0; j<C; j++) {
                map[i][j] = hash.get(raw[j]);
                edge[i][j] = new Edge();

                for (int k=0, ny, nx; k<4; k++) {
                    ny = i + dy[(map[i][j]-k+4)%4];
                    nx = j + dx[(map[i][j]-k+4)%4];
                    if (0<=ny && ny<R && 0<=nx && nx<C)
                    edge[i][j].e.add(new P(ny, nx, k, 0));
                    ny = i + dy[(map[i][j]+k)%4];
                    nx = j + dx[(map[i][j]+k)%4];
                    if (0<=ny && ny<R && 0<=nx && nx<C)
                    edge[i][j].e.add(new P(ny, nx, 0, k));
                }
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        boolean flag = false;
        PriorityQueue<P> pq = new PriorityQueue<>((x,y)->(x.l!=y.l)?x.l-y.l: x.r-y.r);
        pq.offer(new P(0, 0, 0, 0));
        dist[0][0][0]=0;

        while (!pq.isEmpty()) {
            P p = pq.poll();
            if (dist[p.i][p.j][p.l]!=p.r) continue;
            if (p.i==R-1 && p.j==C-1) {
                flag = true;
                break;
            }

            for (P e : edge[p.i][p.j].e) {
                if (p.r+e.r>K || p.l+e.l>K)
                continue;

                if (dist[e.i][e.j][p.l+e.l] > p.r+e.r) {
                    dist[e.i][e.j][p.l+e.l] = p.r+e.r;
                    pq.offer(new P(e.i, e.j, p.l+e.l, p.r+e.r));
                }
            }
            
        }

        bw.write((flag)? "Yes\n": "No\n"); bw.flush();
        bw.close(); br.close();
    }
}
