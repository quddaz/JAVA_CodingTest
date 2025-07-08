import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n + 1][10];

        for(int i = 0; i <= 9; i++){
            dp[1][i] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 9; j++){
                for(int k = j; k <= 9; k++){
                    dp[i + 1][k] = (dp[i + 1][k] + dp[i][j]) % MOD;
                }
            }
        }

        int result = 0;
        for(int i = 0; i <= 9; i++){
            result = (result + dp[n][i]) % MOD;
        }
        System.out.println(result);
    }
}
