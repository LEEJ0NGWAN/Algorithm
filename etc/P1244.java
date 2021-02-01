import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1244 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, s;
    static int[] switches;

    public static void main(String[] args) throws Exception {
        // 스위치 개수
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 스위치 초기화
        switches = new int[n+1];
        for (int i=1; i<=n; i++)
        switches[i] = Integer.parseInt(st.nextToken());

        // 학생 개수
        s = Integer.parseInt(br.readLine());
        // 학생 하나씩 시작
        for (int i=0; i<s; i++) {
            String[] tokens = br.readLine().split(" ");
            int gender = Integer.parseInt(tokens[0]);
            int index = Integer.parseInt(tokens[1]);

            // 남자애
            if (gender == 1) {
                int tmp = index;
                while (tmp <= n) {
                    switches[tmp] = 1 - switches[tmp];
                    tmp += index;
                }
            }
            // 여자애
            else {
                int left, right;
                left = right = index;
                while (switches[left] == switches[right]) {
                    if ((left-1) == 0 || (right+1) > n) break;
                    if (switches[left-1] != switches[right+1])
                        break;

                    left -= 1;
                    right += 1;
                }
                for (int j = left; j <= right; j++)
                switches[j] = 1 - switches[j];
            }
        }

        // 스위치 20개씩 끊어서 찍기
        StringBuilder sb = new StringBuilder();
        for (int i=1, cnt=0; i<=n; i++) {
            sb.append(switches[i] + ((++cnt == 20)? "\n": " "));
            if (cnt==20) cnt=0;
        }
        
        System.out.println(sb);
    }
}
