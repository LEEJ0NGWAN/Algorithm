import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16235 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[][] map, food;
    static PriorityQueue<int[]> tree = new PriorityQueue<>((a,b)->a[2]-b[2]); // 나이순으로 오름차순
    static Queue<int[]> dead = new ArrayDeque<>(); // 죽은 나무들 모아놓은 큐

    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy  ={-1,-1,0,1,1,1,0,-1};

    static void spring() {

        PriorityQueue<int[]> temp = new PriorityQueue<>((a,b)->a[2]-b[2]); // 임시 우선순위 큐

        // 나무들 루프 돌면서 양분 먹이고 양분 못먹으면 죽은 나무로 처리
        while (!tree.isEmpty()) {
            int[] t = tree.poll(); // t[0]: 나무 x t[1]: 나무 y t[2]: 나무 나이

            // 나무가 위치한곳에 나무가 양분 먹을 만큼 양분이 충분히 많다면
            if (map[t[0]][t[1]]>=t[2]) {
                map[t[0]][t[1]]-=t[2]++; // 나무 나이 올리면서 맵 양분 감소
                temp.offer(t);
            }
            else {
                t[2] /= 2; // 죽는 처리할때 나이 나누기 2
                dead.offer(t);
            }
        }
        tree = temp;
    }

    static void summer() {
        while (!dead.isEmpty()) {
            int[] t = dead.poll();
            map[t[0]][t[1]] += t[2]; //나무 죽은위치에 양분 더해주기
        }
    }

    static void autumn() {

        PriorityQueue<int[]> temp = new PriorityQueue<>((a,b)->a[2]-b[2]);

        // 나무 돌면서
        while (!tree.isEmpty()) {
            int[] t = tree.poll();
            if (t[2]%5==0) // 나이가 5의 배수인 애들

            for (int i=0; i<8; i++) {  // 8방향 나무 심기
                int ny = t[0] + dy[i];
                int nx = t[1] + dx[i];

                if (0<=ny && ny<N && 0<=nx && nx<N)
                temp.offer(new int[]{ny,nx,1});
            }
            temp.offer(t);
        }
        tree = temp;
    }

    static void winter() {
        for (int i=0; i<N; i++)
        for (int j=0; j<N; j++)
        map[i][j] += food[i][j];
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // K년
        map = new int[N][N];
        food = new int[N][N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = 5;
                food[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0, x,y,z; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken())-1; // 나무의 좌표값이랑 나무 몇살
            y = Integer.parseInt(st.nextToken())-1;
            z = Integer.parseInt(st.nextToken());
            tree.offer(new int[]{x,y,z}); //우선순위 큐에 저장 -> 나무의 나이순으로 오름차순 정렬
        }

        // K년을 돌면서 봄여름가을겨울 시뮬 시작
        for (int i=0; i<K; i++) {
            spring();
            summer();
            autumn();
            winter();
        }
        System.out.println(tree.size());
    }
}
