import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1};

    static int T, N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t  < T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new char[N][N];
            
            for (int i = 0; i < N; i++)
                map[i] = br.readLine().toCharArray();

            int max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (map[i][j] == 'G')
                        continue;
                    
                    int floor = -1;

                    // 공원 검사
                    for (int k = 0; k < 8; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];

                        if (nx<0 || ny<0 || N<=nx || N<=ny)
                            continue;
                        
                        if (map[ny][nx] == 'G') {
                            floor = 2;
                            break;
                        }
                    }

                    if (floor == -1)
                    for (int k = 0; k < N; k++) {
                        if (map[k][j] == 'B')
                            floor++;

                        if (map[i][k] == 'B')
                            floor++;
                    }

                    max = (max < floor)? floor: max;
                }
            }
            sb.append("#"+(t+1)+" "+max);
        }

        System.out.println(sb.toString());
    }
}

