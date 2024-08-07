import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] dp;
    static int[][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][N+1];
        num = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = num[1][1];

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + num[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + num[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + num[i][j];
                }
            }
        }

        int result = 0;
        for (int j = 1; j <= N; j++) {
            result = Math.max(result, dp[N][j]);
        }

        System.out.println(result);
    }
}
