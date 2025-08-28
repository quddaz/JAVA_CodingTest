import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long MOD = 1_000_000_007;

        long[][][] dp = new long[N + 1][10][4];

        if (N == 1) {
            System.out.println(9);
            return;
        }

        for (int j = 0; j < 10; j++) {
            if (j > 0) {
                dp[2][j][0] = 1;
            }
            if (j < 9) {
                dp[2][j][2] = 1;
            }
        }
        
        for (int i = 3; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > 0) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j - 1][2] + dp[i - 1][j - 1][3]) % MOD;
                    dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j - 1][0]) % MOD;
                }

                if (j < 9) {
                    dp[i][j][2] = (dp[i][j][2] + dp[i - 1][j + 1][0] + dp[i - 1][j + 1][1]) % MOD;
                    dp[i][j][3] = (dp[i][j][3] + dp[i - 1][j + 1][2])  % MOD;
                }
            }
        }

        long totalSum = 0;
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 4; k++) {
                totalSum = (totalSum + dp[N][j][k]) % MOD;
            }
        }

        System.out.println(totalSum);
    }
}