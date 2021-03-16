import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P2578 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] map = new boolean[5][5];
    static HashMap<Integer, int[]> hash = new HashMap<>();
    static StringTokenizer st;
    static int[] r=new int[5], c=new int[5];
    static int[] dl=new int[10], dr=new int[10];

    public static void main(String[] args) throws Exception {
        
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++)
            hash.put(Integer.parseInt(st.nextToken()), new int[]{i,j});
        }

        int[] arr = new int[25];
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++)
            arr[i*5+j] = Integer.parseInt(st.nextToken());
        }

        int count = 0, bingo = 0;
        for (int x: arr) {
            if (bingo>=3) break;
            count++;
            int[] p = hash.get(x);
            if (++r[p[0]]==5) bingo++;
            if (++c[p[1]]==5) bingo++;
            if (++dr[p[0]+p[1]]==5) bingo++;
            if (++dl[p[0]+Math.abs(p[1]-4)]==5) bingo++;
        }
        System.out.println(count);
    }
}
