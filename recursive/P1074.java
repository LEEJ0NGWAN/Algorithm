import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P1074 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, r, c, ans;
    static int[] pow = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,16384,32768};

    static void foo(int n, int base, int i, int j) {
        if (n==1) {
            ans = base;
            return;
        }
        n/=2;

        if (r<i && c<j)
        foo(n,base,i-n/2,j-n/2);
        else if (r<i && j<=c)
        foo(n,base+(n*n),i-n/2,j+n/2);
        else if (i<=r && c<j)
        foo(n,base+(n*n*2),i+n/2,j-n/2);
        else
        foo(n,base+(n*n*3),i+n/2,j+n/2);
    }

    public static void main(String[] args) throws Exception {
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        r = Integer.parseInt(tokens[1]);
        c = Integer.parseInt(tokens[2]);
        foo(pow[N],0,pow[N]/2,pow[N]/2);
        bw.write(ans+"\n"); bw.flush();
        bw.close(); br.close();
    }
}
