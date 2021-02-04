import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S1218 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Character, Integer> parse = new HashMap<>();
    static HashMap<Character, Integer> op = new HashMap<>();

    static void init() {
        parse.put('(',0);
        parse.put(')',0);
        parse.put('{',1);
        parse.put('}',1);
        parse.put('[',2);
        parse.put(']',2);
        parse.put('<',3);
        parse.put('>',3);
        op.put('(',1);
        op.put(')',-1);
        op.put('{',1);
        op.put('}',-1);
        op.put('[',1);
        op.put(']',-1);
        op.put('<',1);
        op.put('>',-1);
    }
    public static void main(String[] args) throws Exception {
        init();
        StringBuilder sb = new StringBuilder();
        
        for (int t=1; t<=10; t++) {
            int length = Integer.parseInt(br.readLine());
            char[] raw = br.readLine().toCharArray();
            int[] count = {0,0,0,0};
            boolean flag = false;

            for (int i=0; i<length; i++) {
                count[parse.get(raw[i])] += op.get(raw[i]);
                flag = (count[parse.get(raw[i])]<0);
                if (flag) break;
            }
            
            for (int i=0; i<4; i++)
            flag = flag||(count[i]!=0);

            sb.append("#"+t+" "+((flag)? 0:1)+"\n");
        }
        System.out.println(sb);
    }
}
