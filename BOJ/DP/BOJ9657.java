import java.io.*;

public class Main {
    static int cand[] = {1, 3, 4};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n + 1];
        dp[1] = 1; 
        if (n >= 2) dp[2] = 0; 
        if (n >= 3) dp[3] = 1; 
        if (n >= 4) dp[4] = 1;

        for (int i = 5; i <= n; i++) {
            for (int j : cand) {
                if (dp[i - j] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        System.out.println(dp[n] == 1 ? "SK" : "CY");
    }
}
