import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P2839 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, maxCount=0;
    static int[] three, five;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        maxCount = N/3+((N%3!=0)? 1:0);
        three = new int[maxCount+1];
        five = new int[maxCount+1];
        for (int i=1; i<=maxCount; i++) {
            three[i] = i*3;
            five[i] = i*5;
        }

        int minCount = -1;
        loop:
        for (int count=1; count<=maxCount; count++)
        for (int pivot=0; pivot<=count; pivot++)
        if (N==five[pivot]+three[count-pivot]) {
            minCount = count;
            break loop;
        }

        bw.write(minCount+"\n"); bw.flush();
        bw.close(); br.close();
    }
}
