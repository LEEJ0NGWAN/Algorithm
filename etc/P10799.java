import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10799 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        char[] raw = br.readLine().toCharArray();

        int stack=0, sum=0;
        boolean flag=false;

        for (int i=0, l=raw.length; i<l; i++) {
            if (raw[i]=='(') {
                flag = true;
                ++stack;
            }
            else {
                --stack;
                sum += (flag)? stack: 1;
                flag = false;
            }
        }
        System.out.println(sum);
    }
}
