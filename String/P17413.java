import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17413 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static StringBuilder parse(char[] raw, int pivot, int length, boolean reverse) {
        StringBuilder sb = new StringBuilder().append(raw,pivot,length);
        return (reverse)? sb.reverse(): sb;
    }

    public static void main(String[] args) throws IOException {

        char[] raw = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean mode=false;
        int pivot=0;

        for (int i = 0; i < raw.length; i++) {
            if (mode) {
                if (raw[i] == '>') {
                    sb.append(parse(raw, pivot, i-pivot+1, !mode));
                    pivot = i+1;
                    mode = false;
                }
            }
            else {
                if (raw[i] == ' ') {
                    sb.append(parse(raw, pivot, i-pivot, !mode)).append(" ");
                    pivot = i+1;
                }
                if (raw[i] == '<') {
                    sb.append(parse(raw, pivot, i-pivot, !mode));
                    pivot = i;
                    mode = true;
                }
            }
        }
        if (!mode)
            sb.append(parse(raw, pivot, raw.length-pivot, !mode));

        System.out.println(sb);
    }
}
