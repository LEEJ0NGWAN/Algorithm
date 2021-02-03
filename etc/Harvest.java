import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Harvest {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][];

            for (int i=0; i<N; i++)
            map[i] = br.readLine().toCharArray();

            int sum=0;
            for (int i=0, half=N/2; i<=half; i++)
            for (int j=half-i; j<=half+i; j++)
            sum += map[i][j]-48;
            
            for (int half=N/2, i=half+1; i<N; i++)
            for (int j=i-half; j<N-(i-half); j++)
            sum += map[i][j]-48;

            sb.append("#"+t+" "+sum+"\n");
        }

        System.out.println(sb);
    }
}
