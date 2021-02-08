import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();

        Queue<Integer> que = new LinkedList<>();
        for (int i=1; i<=N; i++)
        que.offer(i);

        Integer p=0;
        boolean flag = false;
        while (!que.isEmpty()) {
            p = que.poll();
            if (flag)
            que.offer(p);
            flag = !flag;
        }
        System.out.println(p);
    }
}
