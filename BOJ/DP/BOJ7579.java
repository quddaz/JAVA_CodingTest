import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] app = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            app[i] = Integer.parseInt(st.nextToken());
        }

        int[] overhead = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            overhead[i] = Integer.parseInt(st.nextToken());
        }

        int limit_cost = 100 * n;
        int[] dp = new int[limit_cost + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = limit_cost; j >= overhead[i]; j--) {
                if (dp[j - overhead[i]] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - overhead[i]] + app[i]);
                }
            }
        }

        for (int j = 0; j <= limit_cost; j++) {
            if (dp[j] >= m) {
                System.out.println(j);
                return;
            }
        }
    }
}
