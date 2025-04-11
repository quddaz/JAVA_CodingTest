import java.util.*;
class Solution {
    public static int solution(int[][] matrixSizes) {
        int n = matrixSizes.length;
        int[] p = new int[n + 1];
        p[0] = matrixSizes[0][0];
        for (int i = 0; i < n; i++) {
            p[i + 1] = matrixSizes[i][1];
        }

        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

}
