import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16935 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, R;
    static int[][] map;

    static void menu1() {
        N = map.length;
        M = map[0].length;
        for (int i=0, h=N/2; i<h; i++) {
            int[] tmp = map[i];
            map[i] = map[N-i-1];
            map[N-i-1] = tmp;
        }
    }

    static void menu2() {
        N = map.length;
        M = map[0].length;
        for (int i=0; i<N; i++)
        for (int j=0, h=M/2; j<h; j++) {
            int tmp = map[i][j];
            map[i][j] = map[i][M-j-1];
            map[i][M-j-1] = tmp;
        }
    }

    static void menu3() {
        N = map.length;
        M = map[0].length;
        int[][] tmp = new int[M][N];

        for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
        tmp[j][N-i-1] = map[i][j];

        map = tmp;
    }

    static void menu4() {
        N = map.length;
        M = map[0].length;
        int[][] tmp = new int[M][N];

        for (int i=0; i<N; i++)
        for (int j=0; j<M; j++)
        tmp[M-j-1][i] = map[i][j];

        map = tmp;
    }

    static void menu5(int count) {
        N = map.length;
        M = map[0].length;
        for (int i=0, h=N/2; i<h; i++)
        for (int j=0, l=M/2; j<l; j++)
        for (int c=0; c<count; c++) {
            int tmp = map[i][j];
            map[i][j] = map[i+h][j];
            map[i+h][j] = map[i+h][j+l];
            map[i+h][j+l] = map[i][j+l];
            map[i][j+l] = tmp;
        }
    }

    static void menu6(int count) {
        N = map.length;
        M = map[0].length;
        for (int i=0, h=N/2; i<h; i++)
        for (int j=0, l=M/2; j<l; j++)
        for (int c=0; c<count; c++) {
            int tmp = map[i][j];
            map[i][j] = map[i][j+l];
            map[i][j+l] = map[i+h][j+l];
            map[i+h][j+l] = map[i+h][j];
            map[i+h][j] = tmp;
        }
    }

    // 180도 뒤집기
    static void turn() {
        N = map.length;
        M = map[0].length;
        for (int i=0, h=N/2; i<h; i++) {
            for (int j=0; j<M; j++) {
                int tmp = map[i][j];
                map[i][j] = map[N-i-1][M-j-1];
                map[N-i-1][M-j-1] = tmp;
            }
        }
    }

    static void menu(int option, int count) {
        count %=4;
        switch (option) {
            case 1: if (count%2!=0) menu1(); break;
            case 2: if (count%2!=0) menu2(); break;
            case 3:
                if (count>=2) turn();
                if (count%2==1) menu3();
                break;
            case 4:
                if (count>=2) turn();
                if (count%2==1) menu4();
                break;
            case 5: menu5(count); break;
            case 6: menu6(count); break;
        }
    }

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++)
            map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int preOption = Integer.parseInt(st.nextToken());
        int count = 1;
        for (int r=1; r<R; r++) {
            int option = Integer.parseInt(st.nextToken());
            if (preOption == option) count++;
            else {
                menu(preOption, count);
                preOption = option;
                count = 1;
            }
        }
        menu(preOption, count);

        StringBuilder sb = new StringBuilder();
        N = map.length; M = map[0].length;
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++)
            sb.append(map[i][j]+" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
