import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j <= w; j++) {
                int pos = (j % 2 == 0) ? 1 : 2;

                dp[i][j] = dp[i - 1][j] + (cnt == pos ? 1 : 0);

                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + (cnt == pos ? 1 : 0));
                }
            }
        }

        int max = 0;
        for (int j = 0; j <= w; j++) {
            max = Math.max(max, dp[n][j]);
        }

        System.out.println(max);
    }
}