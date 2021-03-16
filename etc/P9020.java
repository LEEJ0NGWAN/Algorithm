import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P9020 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] check = new boolean[10001];

    public static void main(String[] args) throws Exception {

        for (int i=2; i<=10000; i++) {
            if (check[i]) continue;
            for (int j=i*2; j<=10000; j+=i)
            check[j] = true;
        }

        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            int half = n/2, index=0;

            while (check[half-index]||check[half+index])
            index++;

            sb.append(half-index).append(" ").append(half+index).append("\n");
        }
        System.out.print(sb);
    }
}
