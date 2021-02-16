import java.io.BufferedReader;
import java.io.InputStreamReader;


public class P10937 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;
    static char[] grade = {'A','B','C','F'};
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    static int[][] capacity, flow, cost;

    public static void mcmf() {
        
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

    }
}
