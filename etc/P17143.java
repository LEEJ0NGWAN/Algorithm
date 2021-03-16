import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 메인 때려박기 고치자s 메소드 나누기는 진짜 필요하지
public class P17143 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int R, C, M;
    static int[][] map;
    static int[][] sharkPos; // [M][2] -> M개의 1차원 x 2차원(x와 y 값) ex [3][1]: 3번째 상어의 y값
    static int[] sharkDir, sharkSpd; // M개 상어의 방향 값이랑 속도 값

    static int[] dx = {0,-1,0,1};
    static int[] dy = {-1,0,1,0};

    static interface l {public int parse();}
    static l l = ()->Integer.parseInt(st.nextToken());

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = l.parse();
        C = l.parse();
        M = l.parse();
        map = new int[R][C];
        sharkPos = new int[10001][]; // 상어 좌표 ex 상어 무게가 1인애는 인덱스를 1로 쓸 수 있다
        sharkDir = new int[10001];   // 상어 방향
        sharkSpd = new int[10001];   // 상어 속도
        Arrays.fill(sharkSpd, -1);   // 상어 속도는 -1로 초기화 -> -1은 죽은 상어를 나타내겠당
        int minSize=10001, maxSize=0; // 등장하게 될 상어들의 무게 범위 (minSize ~ maxSize)까지 상어무게가 등장한다

        // 상어 정보 입력 받는 포문
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());

            int r = l.parse()-1; // 행
            int c = l.parse()-1; // 열
            int s = l.parse(); // 속도
            int d = l.parse(); // 방향
            int z = l.parse(); // 크기

            minSize = Math.min(z, minSize);
            maxSize = Math.max(z, maxSize);

            map[r][c] = z;
            sharkSpd[z] = s;
            sharkSpd[z] %=
            (d==1 || d==2)? (2*(R-1)): (2*(C-1)); // 이거 없으면 시간초과 남

            // 멀쩡하던 d(방향)을 바꿨네?? -> 벽에 부딪혀서 상어가 방향 꺾을때 쓸때 없는 if문 안써줄라고
            // 제가 사용할 방향은 0:상 1:좌 2:하 3:우    [12시부터 반시계 방향]
            // d = (d+2)%4;   <- 현재 방향 값에서 2씩 더해주면 상하, 좌우 반전됨
            if (d==1) d = 0;
            else if (d==4) d = 1;
            sharkDir[z] = d;
            sharkPos[z] = new int[]{r, c};
        }

        int sum = 0; // 상어 무게합
        for (int j=0; j<C; j++) {

            // 상어 킬 따기
            for (int i=0; i<R; i++)
            if (map[i][j]!=0 && sharkSpd[map[i][j]]!=-1) {
                sharkSpd[map[i][j]] = -1; // 상어 죽은거 표시 및 상어 잡기
                sum += map[i][j];
                map[i][j] = 0;
                break;
            }

            // 상어 무빙
            // 상어 무게 작은애부터 움직이기 -> 최악은 만마리 다 돕니다
            for (int size=minSize; size<=maxSize; size++) {

                if (sharkSpd[size]==-1)
                continue;

                int[] p = sharkPos[size];
                int s = sharkSpd[size];
                int d = sharkDir[size];

                if (map[p[0]][p[1]]==size)
                map[p[0]][p[1]] = 0;

                int ny = p[0], nx = p[1];
                while (s-->0) {
                    if (ny+dy[d]<0 || R<=ny+dy[d] || nx+dx[d]<0 || C<=nx+dx[d])
                    sharkDir[size] = d = (d+2)%4;

                    ny += dy[d]; nx += dx[d];
                }

                if (map[ny][nx] < size)
                sharkSpd[map[ny][nx]] = -1;
                map[ny][nx] = size;
                sharkPos[size][0] = ny;
                sharkPos[size][1] = nx;
            }
        }
        System.out.println(sum);
    }
}
