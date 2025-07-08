import java.io.*;
import java.util.*;

public class G3_2616 {
    static int[][] dp;
    static int N;
    static int[] num;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        dp = new int[N + 1][4];  

        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + num[i];
        }

        for (int j = 1; j <= 3; j++) {
            for (int i = j * M; i <= N; i++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - M][j - 1] + (sum[i] - sum[i - M]));
            }
        }

        System.out.println(dp[N][3]);
    }
}
