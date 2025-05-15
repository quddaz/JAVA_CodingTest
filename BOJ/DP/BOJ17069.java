import java.io.*;
import java.util.*;

public class Main {
    static final int HORIZONTAL = 0;
    static final int VERTICAL = 1;
    static final int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[n][n][3];
        dp[0][1][HORIZONTAL] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == 1) continue;

                if (j - 1 >= 0) {
                    dp[i][j][HORIZONTAL] += dp[i][j - 1][HORIZONTAL] + dp[i][j - 1][DIAGONAL];
                }
                if (i - 1 >= 0) {
                    dp[i][j][VERTICAL] += dp[i - 1][j][VERTICAL] + dp[i - 1][j][DIAGONAL];
                }

                if (i - 1 >= 0 && j - 1 >= 0) {
                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                        dp[i][j][DIAGONAL] += dp[i - 1][j - 1][HORIZONTAL] +
                                              dp[i - 1][j - 1][VERTICAL] +
                                              dp[i - 1][j - 1][DIAGONAL];
                    }
                }
            }
        }

        long result = dp[n - 1][n - 1][HORIZONTAL] +
                      dp[n - 1][n - 1][VERTICAL] +
                      dp[n - 1][n - 1][DIAGONAL];

        System.out.println(result);
    }
}
