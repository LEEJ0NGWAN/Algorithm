import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class P15657 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] arr;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    static void dfs(int i, int m, String stack) {
        if (m==M) {
            set.add(stack+"\n");
            return;
        }

        for (int j=i; j<N; j++)
        dfs(j,m+1,stack+" "+arr[j]);
    }

    public static void main(String[] args) throws Exception {
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);

        arr = new int[N];

        tokens = br.readLine().split(" ");
        for (int i=0; i<N; i++)
        arr[i] = Integer.parseInt(tokens[i]);
        Arrays.sort(arr);

        for (int i=0; i<N; i++)
        dfs(i,1,Integer.toString(arr[i]));

        StringBuilder sb = new StringBuilder();
        for (String s: set)
        sb.append(s);
        System.out.print(sb);
    }
}
