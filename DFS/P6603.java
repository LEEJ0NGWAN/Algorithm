import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class P6603 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static int[] arr = new int[50];
    static StringBuilder sb = new StringBuilder();

    static void dfs(int i, int count, String stack) {
        if (count==6) {
            sb.append(stack+"\n");
            return;
        }

        for (int j=i+1; j<k; j++)
        dfs(j,count+1,stack+" "+arr[j]);
    }

    public static void main(String[] args) throws Exception {
        
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k==0) break;

            for (int i=0; i<k; i++)
            arr[i] = Integer.parseInt(st.nextToken());

            for (int i=0; i<k; i++)
            dfs(i,1,Integer.toString(arr[i]));
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
