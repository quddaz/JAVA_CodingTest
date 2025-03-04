import java.io.*;

public class Main {
    static final int MOD = 1_000_000_003;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = 1;  
            dp[i][1] = i;  
        }

        for (int n = 2; n <= N; n++) {
            for (int k = 2; k <= K; k++) {
                if(k > n / 2) break;
                dp[n][k] = (dp[n - 1][k] + dp[n - 2][k - 1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}