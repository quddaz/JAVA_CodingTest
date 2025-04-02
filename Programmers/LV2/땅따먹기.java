class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];

        for (int j = 0; j < 4; j++) {
            dp[0][j] = land[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j != k) { 
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + land[i][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, dp[n - 1][j]);
        }

        return answer;
    }
}