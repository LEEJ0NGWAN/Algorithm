import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13300 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, K, sum;
    static int[][] arr = new int[2][7];

    static interface l {public int parse();}
    static l l = ()->Integer.parseInt(st.nextToken());

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = l.parse();
        K = l.parse();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[l.parse()][l.parse()]++;
        }
        for (int i=1; i<7; i++)
        sum += arr[0][i]/K+(arr[0][i]%K==0? 0:1)
            +  arr[1][i]/K+(arr[1][i]%K==0? 0:1);
        System.out.println(sum);
    }
}
