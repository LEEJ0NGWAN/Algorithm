import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3234 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T, N, left, right, count;
    static int[] arr;

    static void dfs(int n, int lsum, int rsum, int rest) {
		if(lsum >= rsum+rest) {
			int cnt=1;
			for(int i=0;i<N-n;i++) cnt*=2;
			for(int i=1;i<=N-n;i++) cnt*=i;
			count+=cnt;
			return;
		}
        if (n==N) {
            count++;
            return;
        }
        for (int j=0; j<N; j++) {
            if ((left&1<<j)!=0 || (right&1<<j)!=0) continue;
            left |= 1<<j;
            dfs(n+1,lsum+arr[j],rsum,rest-arr[j]);
            left ^= 1<<j;

            if (lsum < rsum+arr[j]) continue;
            right |= 1<<j;
            dfs(n+1,lsum,rsum+arr[j],rest-arr[j]);
            right ^= 1<<j;
        }
    }

    public static void main(String[] args) throws Exception {

        T = Integer.parseInt(br.readLine());
        for (int t=1; t<=T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            left = right = count = 0;
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; sum += arr[i++])
            arr[i] = Integer.parseInt(st.nextToken());

            for (int i=0; i<N; i++) {
                left |= 1<<i;
                dfs(1,arr[i],0,sum-arr[i]);
                left ^= 1<<i;
            }
            System.out.println("#"+t+" "+count);
        }
    }
}
