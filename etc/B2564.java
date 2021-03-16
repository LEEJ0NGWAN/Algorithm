import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B2564 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int w, h, c;
    static int[] p;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        String[] tokens = br.readLine().split(" ");
        w = Integer.parseInt(tokens[0]);
        h = Integer.parseInt(tokens[1]);
        c = Integer.parseInt(br.readLine());
        arr = new int[c][2];

        for (int i=0; i<c; i++) {
            tokens = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(tokens[0]);
            arr[i][1] = Integer.parseInt(tokens[1]);
        }
        tokens = br.readLine().split(" ");
        p = new int[]{Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])};

        int sum=0;
        for (int i=0; i<c; i++) {
            if (p[0]==arr[i][0]) sum += Math.abs(p[1]-arr[i][1]);
            else if (p[0]+arr[i][0]==3 || p[0]+arr[i][0]==7) {
                int d1 = p[1]+arr[i][1];
                int d2 = (p[0]+arr[i][0]==3)? 2*w-d1: 2*h-d1;
                sum += Math.min(p[0], arr[i][0])==1? h+Math.min(d1, d2): w+Math.min(d1, d2);
            }
            else {
                int[] little, bigger;
                if (p[0]<arr[i][0]) {
                    little = p;
                    bigger = arr[i];
                }
                else {
                    little = arr[i];
                    bigger = p;
                }
                if (little[0]==1)
                sum += (bigger[0]==3)? little[1]+bigger[1]: w-little[1]+bigger[1];
                else
                sum += (bigger[0]==3)? little[1]+h-bigger[1]: w-little[1]+h-bigger[1];
            }
        }
        System.out.println(sum);
    }
}
