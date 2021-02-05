import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cal {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();

        for(int t=1; t<=10; t++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "+*", true);

            int sum=0, mul=1, tmp=0;
            boolean op = false;
            while (st.hasMoreTokens()) {
                if (op) {
                    if (st.nextToken().equals("+")) {
                        if (mul!=1) {
                            sum += mul*tmp;
                            mul = 1;
                        }
                        else
                            sum += tmp;
                    }
                    else
                        mul *= tmp;
                }
                else
                tmp = Integer.parseInt(st.nextToken());
                op = !op;
            }
            sum += (mul!=1)? mul*tmp: tmp;
            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb);
    }
    
}
