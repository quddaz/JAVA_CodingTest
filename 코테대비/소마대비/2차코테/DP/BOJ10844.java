import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int dp[][] = new int[n + 1][10];


        for(int i = 1; i <= 9; i++){
            dp[1][i] = 1;
        }


        for(int i = 1; i < n; i++){
            for(int j = 0; j <= 9; j++){
                if (j - 1 >= 0) {
                    dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                }
                if(j + 1 < 10)
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD; 
            }
        }
        int result = 0;
        for (int j = 0; j < 10; j++) {
            result = (result + dp[n][j]) % MOD;
        }

        System.out.println(result);
    }
}

