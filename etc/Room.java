import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Room {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;

    static class P {
        int i, j, v;
        public P (int i, int j, int v) {
            this.i = i;
            this.j = j;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());

            PriorityQueue<P> que = new PriorityQueue<>((a,b)-> b.v-a.v);

            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++)
                que.offer(new P(i, j, Integer.parseInt(st.nextToken())));
            }

            P pre = que.poll();
            int count = 1;
            int maxCount=1, maxPivot=1;
            while (!que.isEmpty()) {
                P p = que.poll();

                int dx = Math.abs(p.j-pre.j);
                int dy = Math.abs(p.i-pre.i);

                count = (dx+dy<=1)? count+1: 1;
                if (maxCount <= count) {
                    maxCount = count;
                    maxPivot = p.v;
                }
                pre = p;
            }

            sb.append("#"+t+" "+maxPivot+" "+maxCount+"\n");
        }

        System.out.println(sb);
    }
}
