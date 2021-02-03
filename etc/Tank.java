import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Tank {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, H, W, N;
    static char[][] map;
    static char[] command, parse={'>','v','<','^'};

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static HashMap<Character, Integer> hashMap = new HashMap<>();

    static void init() {
        hashMap.put('U', 3);
        hashMap.put('D', 1);
        hashMap.put('L', 2);
        hashMap.put('R', 0);
        hashMap.put('<', 2);
        hashMap.put('>', 0);
        hashMap.put('^', 3);
        hashMap.put('v', 1);
    }
    public static void main(String[] args) throws Exception {
        init();
        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=T; t++) {
            String[] tokens = br.readLine().split(" ");
            H = Integer.parseInt(tokens[0]);
            W = Integer.parseInt(tokens[1]);
            map = new char[H][];

            int x=-1, y=-1;
            for (int i=0; i<H; i++) {
                map[i] = br.readLine().toCharArray();
                
                for (int j=0; j<W; j++)
                if (x==-1 && y==-1 && map[i][j]=='<' || map[i][j]=='>' || map[i][j]=='^' || map[i][j]=='v') {
                    x = j; y = i;
                }
            }

            N = Integer.parseInt(br.readLine());
            command = br.readLine().toCharArray();
            for (int n=0; n<N; n++) {
                if (command[n]=='S') {
                    int nx=x, ny=y, i=hashMap.get(map[y][x]);
                    while (true) {
                        nx = nx+dx[i];
                        ny = ny+dy[i];
                        if (nx<0 || ny<0 || W<=nx || H<=ny)
                        break;

                        if (map[ny][nx] == '*') {
                            map[ny][nx] = '.';
                            break;
                        }

                        if (map[ny][nx] == '#')
                        break;
                    }
                }
                else {
                    int i=hashMap.get(command[n]);

                    int nx=x+dx[i];
                    int ny=y+dy[i];

                    map[y][x] = parse[i];
                    if (nx<0 || ny<0 || W<=nx || H<=ny)
                    continue;

                    if (map[ny][nx]=='#' || map[ny][nx]=='*' || map[ny][nx]=='-')
                    continue;

                    map[y][x] = '.';
                    map[ny][nx] = parse[i];
                    x=nx; y=ny;
                }
            }

            sb.append("#"+t+" ");
            for (int i=0; i<H; i++)
            sb.append(map[i]).append("\n");
        }
        System.out.println(sb);
    }
}
