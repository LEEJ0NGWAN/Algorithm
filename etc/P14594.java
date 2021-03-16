import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P14594 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]==b[0]? a[1]-b[1]: a[0]-b[0]);
        for (int i=0; i<M; i++) {
            String[] t = br.readLine().split(" ");
            pq.offer(new int[]{Integer.parseInt(t[0]),Integer.parseInt(t[1])});
        }

        int count=0, r=0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (r<p[0]) {
                count += p[0]-r;
                r = p[1];
            }
            else
            r = Math.max(r, p[1]);
        }
        count += N-r;
        System.out.println(count);
    }
}
