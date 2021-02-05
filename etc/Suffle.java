import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Suffle {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());

            String[] tokens = br.readLine().split(" ");

            sb.append("#"+t);
            for (int i=0, h=N/2, o=N%2; i<h; i++)
            sb.append(" "+tokens[i]+" "+tokens[i+h+o]);
            sb.append((N%2==0)? "\n": " "+tokens[N/2]+"\n");
        }
        System.out.println(sb);
    }
}
