import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2167 {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, length;
    static int[] arr;

    static interface ld {public int parse();}
    static ld l = ()->Integer.parseInt(st.nextToken());
    
    public static void main(String[] args) throws Exception {
    
        st = new StringTokenizer(br.readLine());
        N = l.parse();
        M = l.parse();

        length = N*M;
        arr = new int[length];
        
        for (int i=0, pre=0; i<length; i++) {
            if (i%M==0)
            st = new StringTokenizer(br.readLine());
            arr[i] = pre + l.parse();
            pre = arr[i];
        }
        K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0, sum=0; i<K; i++,sum=0) {
            st = new StringTokenizer(br.readLine());
            int y1 = l.parse()-1;
            int x1 = l.parse()-1;
            int y2 = l.parse()-1;
            int x2 = l.parse()-1;

            for (int j=y1*M, k=y2*M; j<=k; j+=M)
            sum += arr[j+x2] - (j+x1==0? 0: arr[j+x1-1]);
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
