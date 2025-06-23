import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(br.readLine());
        }

        int[] C = new int[M];
        for (int i = 0; i < M; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], INF);
        }

        dp[0][0] = 0;

        for (int day = 1; day <= M; day++) {
            for (int city = 0; city <= N; city++) {
                dp[city][day] = Math.min(dp[city][day], dp[city][day - 1]);
                if (city > 0) {
                    dp[city][day] = Math.min(dp[city][day],
                            dp[city - 1][day - 1] + D[city - 1] * C[day - 1]);
                }
            }
        }

        int answer = INF;
        for (int day = 0; day <= M; day++) {
            answer = Math.min(answer, dp[N][day]);
        }

        System.out.println(answer);
    }
}
