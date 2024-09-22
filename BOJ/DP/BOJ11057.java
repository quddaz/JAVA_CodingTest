import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;
        
        int[][] dp = new int[N + 1][10];
        
        // 길이가 1인 경우, 각 숫자로 끝나는 오르막 수는 1개씩.
        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }
        
        // DP 테이블 채우기
        for (int n = 2; n <= N; n++) {
            for (int d = 0; d <= 9; d++) {
                for (int k = 0; k <= d; k++) {
                    dp[n][d] += dp[n - 1][k];
                    dp[n][d] %= MOD;
                }
            }
        }
        
        // 결과 계산
        int result = 0;
        for (int d = 0; d <= 9; d++) {
            result += dp[N][d];
            result %= MOD;
        }
        
        System.out.println(result);
    }
}
