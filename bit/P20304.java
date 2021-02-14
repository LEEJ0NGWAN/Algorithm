import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class P20304 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[1000001];
        Arrays.fill(arr, -1);

        Queue<Integer> que = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0, x; i<M; i++) {
            x = Integer.parseInt(st.nextToken());
            arr[x] = 0;
            que.offer(x);
        }

        int max = 0;
        while (!que.isEmpty()) {
            int x = que.poll();

            for (int i=0, y; i<20; i++) {
                y = x ^ (1<<i);
                if (y<=N && arr[y]==-1) {
                    arr[y] = arr[x]+1;
                    que.offer(y);
                    if (max < arr[y]) max = arr[y];
                }
            }
        }
        bw.write(max+"\n"); bw.flush();
        bw.close(); br.close();
    }
}
