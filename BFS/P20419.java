import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Queue;

public class P20419 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R, C, K;
    static char[][] map;
    static boolean[][][] visit;
    static Hashtable<Character, Integer> hash = new Hashtable<>();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class P {
        int i, j, k;
        public P (int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
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
        map = new char[R][];
        visit = new boolean[R][C][4];
        for (int i=0; i<R; i++)
        map[i] = br.readLine().toCharArray();

        Queue<P> que = new ArrayDeque<>();
        que.offer(new P(0,0,0));
        visit[0][0][0] = true;
        boolean flag = false;
        while (!que.isEmpty()) {
            P p = que.poll();

            if (p.i==R-1 && p.j==C-1) {
                flag = true;
                break;
            }

            int nd = hash.get(map[p.i][p.j]);
            int nx = p.j+dx[nd];
            int ny = p.i+dy[nd];

            if (0<=nx && nx<C && 0<=ny && ny<R && !visit[ny][nx][p.k]) {
                visit[ny][nx][p.k] = true;
                que.offer(new P(ny, nx, p.k));
            }

            if (K==1) {
                if (p.k==0 || p.k==1) { 
                    int nk = (p.k==0)? 2: 3;
                    nd = (hash.get(map[p.i][p.j])+1)%4;
                    nx = p.j+dx[nd];
                    ny = p.i+dy[nd];

                    if (0<=nx && nx<C && 0<=ny && ny<R && !visit[ny][nx][nk]) {
                        visit[ny][nx][nk] = true;
                        que.offer(new P(ny, nx, nk));
                    }
                }

                if (p.k==0 || p.k==2) {
                    int nk = (p.k==0)? 1: 3;
                    nd = (hash.get(map[p.i][p.j])+3)%4;
                    nx = p.j+dx[nd];
                    ny = p.i+dy[nd];

                    if (0<=nx && nx<C && 0<=ny && ny<R && !visit[ny][nx][nk]) {
                        visit[ny][nx][nk] = true;
                        que.offer(new P(ny, nx, nk));
                    }
                }
            }
        }

        bw.write((flag)? "Yes\n": "No\n"); bw.flush();
        bw.close(); br.close();
    }
}
