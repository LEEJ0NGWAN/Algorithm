import java.util.Scanner;

public class P17213 {

    static Scanner s = new Scanner(System.in);
    static long N, M, r;

    public static void main(String[] args) {
        N = s.nextInt();
        M = s.nextInt() - N;

        if (M==0)
        System.out.println(1);
        else {
            N = N + M - 1;
            M = Math.min(N-M, M);

            long a=1, b=1;
            for (long i=N; i>N-M; i--)
            a = a * i;
            for (long i=M; i>0; i--)
            b = b * i;

            System.out.println(a/b);
        }
    }
}