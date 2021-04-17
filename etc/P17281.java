import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P17281 {
    
    static BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans;
    static int[] arr;
    static int[][] point;

    static void dfs(int count, int visit) {

        if (count==9) {

            int round = 0, score = 0, out = 0, curr=0;

            boolean[] pos = {false, false, false};

            while (round!=N) {

                int action = point[round][arr[curr]];

                if (action==0) out++;
                else if (action==1) {
                    if (pos[2]) score++;
                    pos[2] = pos[1];
                    pos[1] = pos[0];
                    pos[0] = true;
                }
                else if (action==2) {
                    if (pos[2]) score++;
                    if (pos[1]) score++;
                    pos[2] = pos[0];
                    pos[1] = true;
                    pos[0] = false;
                }
                else if (action==3) {
                    if (pos[2]) score++;
                    if (pos[1]) score++;
                    if (pos[0]) score++;
                    pos[2] = true;
                    pos[1] = pos[0] = false;
                }
                else {
                    if (pos[2]) score++;
                    if (pos[1]) score++;
                    if (pos[0]) score++;
                    score++;
                    pos[2] = pos[1] = pos[0] = false;
                }

                curr = (curr+1)%9;
                if (out==3) {
                    pos[0] = pos[1] = pos[2] = false;
                    out =0;
                    round++;
                }
            }

            if (ans<score)
                ans=score;

            return;
        }

        if (count==3) count++;
        for (int i=1; i<9; i++) {
            if ((visit&1<<i)!=0) continue;

            arr[count] = i;
            dfs(count+1, visit|1<<i);
        }
    }

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(br.readLine());
        arr = new int[9]; arr[3] = 0;
        point = new int[N][9];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++)
            point[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(ans);
    }
}
