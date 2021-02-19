import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class J1828 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static PriorityQueue<P> pq = new PriorityQueue<P>((x,y)->(x.l==y.l)? x.r-y.r: x.l-y.l);
    static int N;
    static int[] right;

    static class P {
        int l, r;
        public P (int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        right = new int[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new P(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int size=0;
        while (!pq.isEmpty()) {
            P p = pq.poll();
            boolean flag = true;
            for (int i=0; i<size; i++)
            if (p.l<=right[i]) {
                flag = false;
                right[i] = Math.min(right[i], p.r);
                break;
            }

            if (flag)
            right[size++] = p.r;
        }
        bw.write(size+"\n"); bw.flush();
        bw.close(); br.close();
    }
}
