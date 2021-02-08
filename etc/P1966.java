import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class P {
    int i, w;
    public P(int i, int w) {
        this.i = i;
        this.w = w;
    }
}
public class P1966 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, X;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            Queue<P> que = new LinkedList<>();
            int[] arr = new int[N];
            for (int i=0; i<N; i++) {
                int x = Integer.parseInt(st.nextToken());
                que.offer(new P(i,x));
                arr[i] = x;
            }
            Arrays.sort(arr);

            int count = 1, pivot = N-1;
            while (!que.isEmpty()) {
                P p = que.poll();
                if (p.w == arr[pivot]) {
                    if (p.i == X)
                    break;
                    count++;
                    pivot--;
                }
                else
                que.offer(p);
            }
            sb.append(count+"\n");
        }
        System.out.print(sb);
    }
}
