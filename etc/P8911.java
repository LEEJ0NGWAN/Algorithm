import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P8911 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int dir;
    static int[] size = {0,0,0,0};
    static int[] pos = {0,0};
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};

    public static void main(String[] args) throws Exception {
        
        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {

            char[] raw = br.readLine().toCharArray();
            dir = 0;
            size = new int[]{0,0,0,0};
            pos = new int[]{0,0};

            for (char c: raw)
            switch (c) {
                case 'F':
                case 'B':
                    int i = (dir+(c=='F'?0:2))%4;
                    pos[0] += dy[i];
                    pos[1] += dx[i];
                    size[i] = (i%3==0)? Math.min(size[i], pos[i/3]): Math.max(size[i], pos[i%2]);
                    break;
                case 'L':
                case 'R':
                    dir = (4+dir+(c=='L'?-1:1))%4;
            }
            sb.append(Math.abs(size[0]-size[2])*Math.abs(size[1]-size[3])).append('\n');
        }
        System.out.print(sb);
    }
}
