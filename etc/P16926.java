import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16926 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, R; // R 돌리기 횟수
    static int[][] map;
    static int[] rotateCount; // 원소 등급에 따라서 회전 횟수가 달라졍

    /**
     *  N:4, M:5 R:20
     *  0 0 0 0 0
     *  0 1 1 1 0
     *  0 1 1 1 0
     *  0 0 0 0 0
     * 
     *  N:3, M:4 
     *  0 0 0 0
     *  0 0 0 0
     *  0 0 0 0
     * 
     * 
     *  N:8, M:9, R:1000
     * 
     *  0 0 0 0 0 0 0 0 0
     *  0 1 1 1 1 1 1 1 0
     *  0 1 2 2 2 2 2 1 0
     *  0 1 2 3 3 3 2 1 0
     *  0 1 2 3 3 3 2 1 0
     *  3 1 2 2 2 2 2 1 0
     *  0 1 1 1 1 1 1 1 0
     *  0 0 0 0 0 0 0 0 0
     * 
     */

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //행 개수 받고
        M = Integer.parseInt(st.nextToken()); //열 개수 받고
        R = Integer.parseInt(st.nextToken()); //공식적인 회전 횟수 받고
        map = new int[N][M];
        rotateCount = new int[Math.min(N, M)/2];

        for (int i=0, l=Math.min(N, M)/2; i<l; i++)
        rotateCount[i] = R%((N-(2*i))*2+(M-(2*i))*2-4); //둘레 등급마다 실제로 최소 돌아야되는 횟수 저장

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) { // i: 2, j: 3, N:8, M:9
                int a = Math.min(i, Math.abs(N-i-1)); // 행 관련해서 계산 1 min(2,5) = 2
                int b = Math.min(j, Math.abs(M-j-1)); // 열 관련해서 계산 2 min(3,5) = 3
                int s = Math.min(a, b); // s는 해당 원소의 등급 값 min(2,3) = 2 <- (2,3)의 등급값
                int r = rotateCount[s]; // r은 해당 원소가 실제 돌아야 되는 횟수를 rotateCount에서 가져와

                // i: 2, j: 3, N: 8, M: 9
                int y=i, x=j; // 맨처음에 y=2, x=3
                // 현재 원소가 돌아야되는 횟수만큼 다 돌때까지
                while (r>0) {
                    // 아래방향으로 
                    if (x==s && y<(N-s-1)) {
                        int rest = N-s-1-y; // rest = 나머지 -> 꼭지점까지 갈려면 r을 5만큼써야해
                        // 현재 원소가 회전해야 하는 횟수가 rest보다 작으면
                        if (r <= rest) {
                            y += r;
                            r = 0;
                        }
                        // 현재 원소가 회전해야 하는 횟수가 rest보다 커
                        else {
                            y = N-s-1;
                            r -= rest;
                        }
                    }
                    // 오른쪽 방향
                    else if (y==(N-s-1) && x<(M-s-1)) {
                        int rest = M-s-1-x;
                        if (r <= rest) {
                            x += r;
                            r = 0;
                        }
                        else {
                            x = M-s-1;
                            r -= rest;
                        }
                    }
                    // 윗방향
                    else if (x==(M-s-1) && y>s) {
                        int rest = y-s;
                        if (r <= rest) {
                            y -= r;
                            r = 0;
                        }
                        else {
                            y = s;
                            r -= rest;
                        }
                    }
                    // 왼쪽방향
                    else if (y==s && x>s) {
                        int rest = x-s;
                        if (r <= rest) {
                            x -= r;
                            r = 0;
                        }
                        else {
                            x = s;
                            r -= rest;
                        }
                    }
                }
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++)
            sb.append(map[i][j]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
}
