import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class P19644 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int L, ML, MK, C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        L = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        ML = Integer.parseInt(tokens[0]);
        MK = Integer.parseInt(tokens[1]);
        C = Integer.parseInt(br.readLine());
        arr = new int[L+1];

        boolean flag = true;
        for (int l=1, mk=MK, zombie; l<=L; l++) {
            zombie = Integer.parseInt(br.readLine());
            mk -= arr[l];

            if (zombie-mk > 0) {
                if (C > 0) C--;
                else {
                    flag = false;
                    break;
                }
            }
            else {
                mk += MK;
                if (l+ML <= L)
                arr[l+ML] = MK;
            }
        }
        bw.write((flag)? "YES\n": "NO\n"); bw.flush();
        bw.close(); br.close();
    }
}
