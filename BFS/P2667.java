import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class D {
    static int[] i = { 0, 1, 0, -1};
    static int[] j = { 1, 0, -1, 0};
}

class Pos {
    int i, j;
    public Pos(int i, int j) {
        this.i = i; this.j = j;
    }
}

public class P2667 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static char[][] map;

    static int bfs(int i, int j) {

        Queue<Pos> que = new LinkedList<>();
        que.offer(new Pos(i, j));

        map[i][j] = '0';
        int count = 1;

        while (!que.isEmpty()) {
            Pos pos = que.poll();

            for (int k = 0; k < 4; k++) {
                int i_ = pos.i + D.i[k];
                int j_ = pos.j + D.j[k];

                if (i_ < 0 || N <= i_)
                    continue;
                if (j_ < 0 || N <= j_)
                    continue;
                if (map[i_][j_] == '1') {
                    que.offer(new Pos(i_, j_));
                    map[i_][j_] = '0';
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++)
            map[i] = br.readLine().toCharArray();

        ArrayList<Integer> labelCountInfo = new ArrayList<>();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (map[i][j] == '1')
                    labelCountInfo.add(bfs(i, j));
        
        Collections.sort(labelCountInfo);

        System.out.println(labelCountInfo.size());
        for (int count : labelCountInfo)
            System.out.println(count);
    }
}
