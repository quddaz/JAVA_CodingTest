import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int[] tree = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[T + 1][W + 1];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                if (w == 0) {
                    dp[t][w] = dp[t - 1][w] + (tree[t] == 1 ? 1 : 0);
                } else {
                    dp[t][w] = Math.max(
                        dp[t - 1][w] + (tree[t] == (w % 2 == 0 ? 1 : 2) ? 1 : 0),
                        dp[t - 1][w - 1] + (tree[t] == (w % 2 == 0 ? 2 : 1) ? 1 : 0)
                    );
                }
            }
        }

        int maxPlums = 0;
        for (int w = 0; w <= W; w++) {
            maxPlums = Math.max(maxPlums, dp[T][w]);
        }

        System.out.println(maxPlums);
    }
}
