import java.util.Arrays;

public class MinAbsSum {

    public int solution(int[] A) {

        Arrays.sort(A);
        int l=0, r=A.length-1;
        int lsum=0, rsum=0;
        while (l<=r) {
            if (lsum<rsum) {
                lsum += Math.abs(A[l++]);
            }
            else {
                rsum += Math.abs(A[r--]);
            }
        }
        return Math.abs(rsum-lsum);
    }
    
}
