import java.io.BufferedReader;
import java.io.InputStreamReader;

public class J2577 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, d, k, c;
    static int[] arr, vis;

    public static void main(String[] args) throws Exception {

        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        d = Integer.parseInt(tokens[1]);
        k = Integer.parseInt(tokens[2]);
        c = Integer.parseInt(tokens[3]);
        arr = new int[N];
        vis = new int[d+1];

        for (int i=0; i<N; i++)
        arr[i] = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=0; i<k; i++) if (++vis[arr[i]]==1) count++;

        int ans = count;
        for (int i=1; i<N; i++) {
            if (--vis[arr[i-1]]==0) count--;
            if (++vis[arr[(i+k-1)%N]]==1) count++;

            if (ans<=count)
                ans = vis[c]==0? count+1: count;
        }
        System.out.println(ans);
    }
}