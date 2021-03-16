import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P1138 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1, n; i<=N; i++) {
            n = Integer.parseInt(st.nextToken());
            for (int j=0; j<N; j++)
            if (ans[j]==0) {
                ans[j+n] = i;
                break;
            }
        }
        for (int n: ans)
        System.out.print(n);
    }

}