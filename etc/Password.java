import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Password {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] parse = {1,2,3,4,5};

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=10; t++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> que = new LinkedList<>();

            for (int i=0; i<8; i++)
            que.offer(Integer.parseInt(st.nextToken()));

            int index=0, x=-1;
            while (x!=0) {
                x = que.poll()-parse[index++];
                x = (x>=0)? x: 0;
                que.offer(x);
                index %= 5;
            }

            sb.append("#"+t);
            for (int i=0; i<8; i++)
            sb.append(" "+que.poll());
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
