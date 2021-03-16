import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1991 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] adj;
    static int N;

    static void mlr(int p) {
        sb.append((char)(p+'A'-1));
        if (adj[p][0]!=0)
        mlr(adj[p][0]);
        if (adj[p][1]!=0)
        mlr(adj[p][1]);
    }

    static void lmr(int p) {
        if (adj[p][0]!=0)
        lmr(adj[p][0]);
        sb.append((char)(p+'A'-1));
        if (adj[p][1]!=0)
        lmr(adj[p][1]);
    }

    static void lrm(int p) {
        if (adj[p][0]!=0)
        lrm(adj[p][0]);
        if (adj[p][1]!=0)
        lrm(adj[p][1]);
        sb.append((char)(p+'A'-1));
    }

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        adj = new int[N+1][2];

        for (int i=1; i<=N; i++) {
            String[] tokens = br.readLine().split(" ");
            int p = tokens[0].charAt(0)-'A'+1;
            if (tokens[1].charAt(0)!='.')
            adj[p][0] = tokens[1].charAt(0)-'A'+1;
            if (tokens[2].charAt(0)!='.')
            adj[p][1] = tokens[2].charAt(0)-'A'+1;
        }
        mlr(1); sb.append('\n');
        lmr(1); sb.append('\n');
        lrm(1); sb.append('\n');
        System.out.print(sb);
    }
}
