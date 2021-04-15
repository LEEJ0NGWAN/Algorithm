import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P19539 {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum=0, binaryCount=0;
        for (int i=0, n; i<N; i++) {
            n = Integer.parseInt(st.nextToken());
            sum += n;
            binaryCount += (n/2);
        }
        System.out.println((sum%3!=0 || binaryCount<sum/3)? "NO": "YES");
    }
}
