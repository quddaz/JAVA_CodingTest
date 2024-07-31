import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N == 1) {
            int score = Integer.parseInt(br.readLine());
            System.out.println(score);
            return;
        }
        
        int[] num = new int[N + 1];
        int[] dp = new int[N + 1];
        
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = num[1];
        if (N >= 2) {
            dp[2] = num[1] + num[2];
        }
        if (N >= 3) {
            dp[3] = Math.max(num[1] + num[3], num[2] + num[3]);
        }
        
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + num[i], dp[i - 3] + num[i - 1] + num[i]);
        }
        
        System.out.println(dp[N]);
    }
}
