import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mart {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int l=0, r=N-1;
            int max = -1;
            while (l!=r) {
                int sum = arr[l]+arr[r];
                if (sum<=M && sum > max)
                max = sum;
                if (sum<=M) l++;
                else r--;
            }
            sb.append("#"+t+" "+max+"\n");
        }
        System.out.print(sb);
    }

}
