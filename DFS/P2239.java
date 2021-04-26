import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2239 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map = new int[9][9];
    static boolean[][] useByRow = new boolean[9][10];
    static boolean[][] useByCol = new boolean[9][10];
    static boolean[][] useBySqr = new boolean[9][10];

    static boolean dfs(int index) {

        int y = index/9;
        int x = index%9;

        boolean flag = false;

        for (int i=y; i<9; i++) {
            for (int j=0; j<9; j++) {

                if (i==y && j<=x) continue;

                if (map[i][j]==0) {
                    for (int n=1; n<=9; n++) {
                        if (useByRow[i][n] ||
                            useByCol[j][n] ||
                            useBySqr[(i/3)*3+j/3][n]) continue;
    
                        useByRow[i][n] = 
                        useByCol[j][n] = 
                        useBySqr[(i/3)*3+j/3][n] = true;
    
                        flag = dfs(i*9+j);

                        if (flag)
                        useByRow[i][n] = 
                        useByCol[j][n] = 
                        useBySqr[(i/3)*3+j/3][n] = false;
    
                        else { map[i][j] = n; break; }
                    }
                    return map[i][j]==0;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) throws Exception {
        
        for (int i=0; i<9; i++) {

            char[] raw = br.readLine().toCharArray();

            for (int j=0; j<9; j++) {
                map[i][j] = raw[j]-48;
                useByRow[i][map[i][j]] = true;
            }
        }

        for (int j=0; j<9; j++) {
            for (int i=0; i<9; i++) {
                useByCol[j][map[i][j]] = true;
                useBySqr[(i/3)*3+j/3][map[i][j]] = true;
            }
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (map[i][j]==0)
                for (int n=1; n<=9; n++) {
                    if (useByRow[i][n] ||
                        useByCol[j][n] ||
                        useBySqr[(i/3)*3+j/3][n]) continue;

                    useByRow[i][n] = 
                    useByCol[j][n] = 
                    useBySqr[(i/3)*3+j/3][n] = true;

                    if (dfs(i*9+j))
                    useByRow[i][n] = 
                    useByCol[j][n] = 
                    useBySqr[(i/3)*3+j/3][n] = false;

                    else { map[i][j] = n; break; }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++)
            sb.append(map[i][j]);
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
