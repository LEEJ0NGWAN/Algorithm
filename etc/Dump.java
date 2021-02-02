import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] map = new int[100];
    
    public static void swap(int pivot, int dx) {
        if (dx==1 && map[pivot] <= map[pivot+1]) return;
        if (dx==-1&& map[pivot-1] <= map[pivot]) return;
        int x, y;
        x = y = pivot;
        if (dx==1) y++; else x--;
        while (map[x] > map[y]) {
            map[pivot] = map[pivot]+map[pivot+dx];
            map[pivot+dx] = map[pivot]-map[pivot+dx];
            map[pivot] = map[pivot]-map[pivot+dx];
        }
        swap(pivot+dx, dx);
    }

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        for (int t=1; t<=10; t++) {
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<100; i++)
            map[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(map);

            for (int d=0; d<dump; d++) {
                --map[99]; ++map[0];

                swap(0, 1);
                swap(99, -1);
            }

            sb.append("#"+t+" "+(map[99]-map[0])+"\n");
        }

        System.out.println(sb);
    }
}
