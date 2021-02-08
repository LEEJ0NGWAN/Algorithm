import java.util.Scanner;

public class P11729 {
    
    static int N, count;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int n, int from, int to, int tmp) {
        if (n==1) {
            sb.append(from+" "+to+"\n");
            count++;
            return;
        }
        dfs(n-1, from, tmp, to);
        sb.append(from+" "+to+"\n");
        count++;
        dfs(n-1, tmp, to, from);
    }

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        dfs(N, 1, 3, 2);
        System.out.println(count);
        System.out.print(sb);
    }
}
