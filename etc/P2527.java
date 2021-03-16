import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2527 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] a = new int[4], b = new int[4];

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<4; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<4; i++)
            a[i] = Integer.parseInt(st.nextToken());
            for (int i=0; i<4; i++)
            b[i] = Integer.parseInt(st.nextToken());

            if (a[2]<b[0] || b[2]<a[0] || a[3]<b[1] || b[3]<a[1])
            sb.append('d');

            else if (
                ((a[0]==b[2])&&(a[1]==b[3])) || 
                ((a[2]==b[0])&&(a[1]==b[3])) || 
                ((a[2]==b[0])&&(a[3]==b[1])) || 
                ((a[0]==b[2])&&(a[3]==b[1])))
            sb.append('c');

            else if (
                (a[0]==b[2]) || 
                (a[1]==b[3]) || 
                (a[2]==b[0]) || 
                (a[3]==b[1]))
            sb.append('b');

            else
            sb.append('a');

            sb.append('\n');
        }
        System.out.print(sb);
    }
    
}
