import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int V, E, K;

    static HashMap<Integer,Integer>[] adj;

    static interface l {int p();}
    static interface b {void r() throws Exception;}
    static l l = ()->Integer.parseInt(st.nextToken());
    static b b = ()->st=new StringTokenizer(br.readLine());

    static void dijkstra(int v) {

        int[] dist = new int[V+1];
        Arrays.fill(dist, 999999);
        dist[v] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{v,0});

        while (!pq.isEmpty()) {
            int[] p = pq.poll();

            if (p[1]>dist[p[0]]) continue;

            if (adj[p[0]]!=null)
            for (int next: adj[p[0]].keySet())
            if (dist[next] > p[1]+adj[p[0]].get(next)) {
                dist[next] = p[1]+adj[p[0]].get(next);
                pq.offer(new int[]{next,dist[next]});
            }
        }

        for (int i=1; i<=V; i++)
        sb.append(dist[i]==999999?"INF":dist[i]).append('\n');
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {

        b.r(); V = l.p(); E = l.p();
        K = Integer.parseInt(br.readLine());

        adj = new HashMap[V+1];

        for (int i=0, u, v, w; i<E; i++) {
            b.r();
            u = l.p(); v = l.p(); w = l.p();

            if (adj[u]==null)
            adj[u] = new HashMap<>();

            adj[u].put(v, (adj[u].containsKey(v))? Math.min(adj[u].get(v), w): w);
        }
        dijkstra(K);
    }
}
