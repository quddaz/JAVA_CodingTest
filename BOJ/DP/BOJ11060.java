import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[N + 1];
        int arr[] = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                for (int j = 1; j <= arr[i]; j++) {
                    if (i + j <= N) {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}
