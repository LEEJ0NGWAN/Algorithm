import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2564 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, x, y;
    static boolean[][] map = new boolean[100][100];

    public static void main(String[] args) throws Exception {

        N = Integer.parseInt(br.readLine());

        for (int n=0; n<N; n++) {
            String[] tokens = br.readLine().split(" ");
            x = Integer.parseInt(tokens[0]);
            y = Integer.parseInt(tokens[1]);

            for (int i=y; i<y+10; i++)
            for (int j=x; j<x+10; j++)
            map[i][j] = true;
        }
        int count = 0;
        for (int i=0; i<100; i++)
        for (int j=0; j<100; j++)
        if (map[i][j]) count++;

        System.out.println(count);
    }
    
}
