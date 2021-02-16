import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P3040 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[9];

    public static void main(String[] args) throws Exception {
        
        int sum = 0;
        for (int i=0; i<9; sum+=arr[i++])
        arr[i] = Integer.parseInt(br.readLine());

        loop:
        for (int l=7; l>=0; l--)
        for (int r=8; r>l; r--)
        if (sum-arr[l]-arr[r]==100) {
            arr[l]=arr[r]=0;
            break loop;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<9; i++)
        if (arr[i]!=0)
        sb.append(arr[i]).append('\n');
        bw.write(sb.toString()); bw.flush();
        bw.close(); br.close();
    }
}
