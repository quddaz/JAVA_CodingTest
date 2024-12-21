import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int j = coin; j <= m; j++) {
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m]).append("\n");
        }
        System.out.print(sb);
    }
}
