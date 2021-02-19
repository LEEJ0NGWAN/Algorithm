import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16166 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, target, ans=-1;
    static int[] line;
    static HashMap<Integer, Integer> hash = new HashMap<>();

    static void bfs(int[] start) {

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(start);
        int visit = 1<<start[0];
        while (!que.isEmpty()) {
            int[] p = que.poll();

            if (p[0]==target) {
                ans = (ans==-1)? p[1]: Math.min(ans, p[1]);
                continue;
            }

            for (int i=0; i<N; i++)
            if ((line[p[0]]&1<<i)!=0 && (visit&1<<i)==0) {
                visit |= 1<<i;
                que.offer(new int[]{i,p[1]+1});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        line = new int[N];

        Queue<int[]> q = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            for (int j=0; j<M; j++) {
                int x = Integer.parseInt(st.nextToken());
                if (x==0) q.offer(new int[]{i,0});
                if (!hash.containsKey(x))
                hash.put(x, 1<<i);
                else if ((hash.get(x)&1<<i)==0)
                hash.put(x, hash.get(x)|1<<i);
            }
        }

        target = Integer.parseInt(br.readLine());
        for (int i=0, h=hash.get(target); i<N; i++)
        if ((h&1<<i)!=0) { target=i; break;}

        for (int bit: hash.values()) {
            if (Integer.bitCount(bit)==1) continue;
            for (int i=0; i<N; i++) if ((bit&1<<i)!=0)
            for (int j=0; j<N; j++) if (i!=j && (bit&1<<j)!=0)
            line[i] |= 1<<j;
        }
        while (!q.isEmpty())
        bfs(q.poll());

        System.out.println(ans);
    }
}
