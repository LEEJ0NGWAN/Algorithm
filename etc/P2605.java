import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P2605 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n=1; n<=N; n++)
        list.add(Integer.parseInt(st.nextToken()), n);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for (int x: list)
        sb.append(x).append(" ");
        System.out.println(sb);
    }
}
