import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1233 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=1; t++) {
            N = Integer.parseInt(br.readLine());

            boolean flag = false;
            for (int i=0; i<N; i++) {
                String raws = br.readLine();
                if (!flag) {
                    String[] tokens = raws.split(" ");
                    String raw = tokens[1];
                    if (tokens.length == 4) {
                        flag = 
                        !raw.equals("+") && 
                        !raw.equals("-") && 
                        !raw.equals("*") && 
                        !raw.equals("/");
                    }
                    else {
                        flag = 
                        raw.equals("+") || 
                        raw.equals("-") || 
                        raw.equals("*") || 
                        raw.equals("/");
                    }
                }
            }
            sb.append("#"+t+" "+((flag)? "0\n":"1\n"));
        }
        System.out.print(sb);
    }
    
}
