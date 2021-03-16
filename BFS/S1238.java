import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1238 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visit;
    static int length, start, ans;
    static HashMap<Integer, LinkedHashSet<Integer>> adj;

    static interface l {public int p();}
    static l l = ()->Integer.parseInt(st.nextToken());

    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=10; t++) {
            st = new StringTokenizer(br.readLine());
            length = l.p()/2; start = l.p();
            visit = new boolean[101];
            adj = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<length; i++) {
                int from = l.p(), to = l.p();
                if (!adj.containsKey(from))
                adj.put(from, new LinkedHashSet<>());
                adj.get(from).add(to);
            }

            Queue<Integer> que = new ArrayDeque<>();
            que.offer(start);
            visit[start] = true;
            ans = start;
            while (!que.isEmpty()) {
                int tmpAns=0;
                for (int i=0, l=que.size(), v; i<l; i++) {
                    v = que.poll();
                    tmpAns = Math.max(tmpAns, v);
                    if (adj.containsKey(v))
                    for (int next: adj.get(v))
                    if (!visit[next]) {
                        visit[next] = true;
                        que.offer(next);
                    }
                }
                ans = tmpAns;
            }
            sb.append('#').append(t).append(' ').append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
