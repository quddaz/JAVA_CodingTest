import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[][] dp = new int[max + 1][4]; 

        if (max >= 1) dp[1][1] = 1; // 1
        if (max >= 2) dp[2][2] = 1; // 2
        if (max >= 3) {
            dp[3][1] = 1; // 2+1
            dp[3][2] = 1; // 1+2
            dp[3][3] = 1; // 3
        }

        for (int i = 4; i <= max; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = arr[i];
            long result = ((long)dp[n][1] + dp[n][2] + dp[n][3]) % MOD;
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}
