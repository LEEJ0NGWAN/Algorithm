import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9251 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] a, b;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        map = new int[b.length+1][a.length+1];

        for (int i = 0; i < b.length; i++)
        for (int j = 0; j < a.length; j++)
            map[i+1][j+1] = (b[i] == a[j])? map[i][j]+1: Math.max(map[i][j+1], map[i+1][j]);
        
        System.out.println(map[b.length][a.length]);
    }
}