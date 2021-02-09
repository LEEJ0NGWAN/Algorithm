import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1158 {

    static BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    static int N, K;

    public static void main(String[] args) throws Exception {
        
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        K = Integer.parseInt(tokens[1]);

        Queue<Integer> que = new LinkedList<>();
        for (int i=1; i<=N; i++)
        que.offer(i);

        int count = 0;
        StringBuilder sb = new StringBuilder().append("<");
        while (!que.isEmpty()) {
            int x = que.poll();
            if (++count == K) {
                count=0;
                sb.append(x+(que.isEmpty()? ">": ", "));
            }
            
            else
            que.offer(x);
        }
        System.out.println(sb);
    }
}
