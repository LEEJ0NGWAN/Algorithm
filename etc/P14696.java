import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14696 {
    
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, C;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int n=0; n<N; n++) {

            int[] a = new int[101];
            int[] b = new int[101];

            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());

            for (int c=0; c<C; c++)
            a[Integer.parseInt(st.nextToken())]++;

            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());

            for (int c=0; c<C; c++)
            b[Integer.parseInt(st.nextToken())]++;

            String s = null;
            for (int c=100; c>=0; c--) {
                if (a[c]==b[c])
                continue;

                s = (a[c]>b[c])? "A":"B";
                break;
            }
            sb.append(s==null? "D": s).append("\n");
        }
        System.out.print(sb);
    }
}
