import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P3109 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int R, C, count=0;
    static char[][] map;

    static boolean dfs(int i, int j) {

        if (j==C-1) {
            count++;
            return true;
        }
        if (0<=i-1 && j+1<C && map[i-1][j+1]=='.') {
            map[i-1][j+1]='x';
            if (dfs(i-1,j+1))
            return true;
        }
        if (j+1<C && map[i][j+1]=='.') {
            map[i][j+1]='x';
            if (dfs(i,j+1))
            return true;
        }
        if (i+1<R && j+1<C && map[i+1][j+1]=='.') {
            map[i+1][j+1]='x';
            if (dfs(i+1,j+1))
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i=0; i<R; i++)
        map[i] = br.readLine().toCharArray();
        
        for (int i=0; i<R; i++) dfs(i, 0);

        bw.write(count+"\n"); bw.flush();
        bw.close(); br.close();
    }
    
}
