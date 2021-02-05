import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2493 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] stack;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        stack = new int[N+1][2];

        int index = 0;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            int x = Integer.parseInt(st.nextToken());

            while (index>0 && stack[index][1]<x)
            stack[index--][0] = 0;

            stack[++index][0] = i;
            stack[index][1] = x;
            sb.append(stack[index-1][0]+" ");
        }
        System.out.println(sb);
    }
}
