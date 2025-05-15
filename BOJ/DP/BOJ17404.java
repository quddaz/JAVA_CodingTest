import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n + 1][3]; // 1-based
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n + 1][3][3]; 
        int result = INF;

        for (int start = 0; start < 3; start++) {
            for (int c = 0; c < 3; c++) {
                if (c == start) dp[1][c][start] = cost[1][c];
                else dp[1][c][start] = INF;
            }

            for (int i = 2; i <= n; i++) {
                dp[i][0][start] = Math.min(dp[i - 1][1][start], dp[i - 1][2][start]) + cost[i][0];
                dp[i][1][start] = Math.min(dp[i - 1][0][start], dp[i - 1][2][start]) + cost[i][1];
                dp[i][2][start] = Math.min(dp[i - 1][0][start], dp[i - 1][1][start]) + cost[i][2];
            }

            for (int end = 0; end < 3; end++) {
                if (end == start) continue;
                result = Math.min(result, dp[n][end][start]);
            }
        }

        System.out.println(result);
    }
}

