import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000000;
    static long[] f = new long[MAX + 1];
    static long[] g = new long[MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= MAX; i++) {
            for (int j = i; j <= MAX; j += i) {
                f[j] += i;
            }
        }

        for (int i = 1; i <= MAX; i++) {
            g[i] = g[i - 1] + f[i];
        }

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(g[n]).append('\n');
        }

        System.out.print(sb);
    }
}
