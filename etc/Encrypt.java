import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Encrypt {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;

    static class Node {
        int x;
        Node link;
        public Node(int x, Node node) {
            this.x = x;
            this.link = node;
        }
    }

    public static void main(String[] args) throws Exception {
        
        StringBuilder sb = new StringBuilder();
        for (int t=1; t<=10; t++) {
            N = Integer.parseInt(br.readLine());

            Node head, p;
            st = new StringTokenizer(br.readLine());
            head = p = new Node(Integer.parseInt(st.nextToken()), null);
            for (int i=1; i<N; i++) {
                p.link = new Node(Integer.parseInt(st.nextToken()), null);
                p = p.link;
            }

            br.readLine();

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("I")) {
                    int pos = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());

                    Node tmpHead, tmpP;
                    tmpHead = tmpP = new Node(Integer.parseInt(st.nextToken()), null);
                    for (int i=1; i<cnt; i++) {
                        tmpP.link = new Node(Integer.parseInt(st.nextToken()), null);
                        tmpP = tmpP.link;
                    }

                    Node pre = p = head;
                    for (int i=0; i<pos; i++) {
                        pre = p;
                        p = p.link;
                    }
                    if (pre == p) {
                        tmpP.link = head;
                        head = tmpHead;
                    }
                    else {
                        pre.link = tmpHead;
                        tmpP.link = p;
                    }
                }
            }

            p = head;
            sb.append("#"+t);
            for (int i=0; i<10; i++) {
                sb.append(" "+p.x);
                p = p.link;
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
