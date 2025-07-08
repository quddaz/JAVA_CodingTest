import java.io.*;

public class G4_10422 {
    static final int MOD = 1_000_000_007;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] queries = new int[T];
        int maxL = 0;
        for (int i = 0; i < T; i++) {
            queries[i] = Integer.parseInt(br.readLine());
            if (queries[i] > maxL) maxL = queries[i];
        }

        dp = new long[maxL + 1][maxL + 1];

        dp[0][0] = 1;

        for (int i = 0; i < maxL; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 0) {
                    if (j + 1 <= maxL) {
                        dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                    }
                    if (j > 0) {
                        dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                    }
                }
            }
        }

 
        for (int query : queries) {
            if (query % 2 != 0) {
                System.out.println(0);
            } else {
                System.out.println(dp[query][0]);
            }
        }
    }
}