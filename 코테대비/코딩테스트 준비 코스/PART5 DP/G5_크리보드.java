import java.io.*;

public class G5_11058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(getMaxAs(N));
    }

    public static long getMaxAs(int N) {
        if (N <= 6) return N; // 6번 이하의 입력은 모든 경우에 직접 출력이 최댓값입니다.

        long[] dp = new long[N + 1];

        // 초기값 설정
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
        }


        for (int i = 7; i <= N; i++) {
           dp[i] = Math.max(dp[i], dp[i-3] * 2);
           dp[i] = Math.max(dp[i], dp[i-4] * 3);
           dp[i] = Math.max(dp[i], dp[i-5] * 4);
        }

        return dp[N];
    }
}
