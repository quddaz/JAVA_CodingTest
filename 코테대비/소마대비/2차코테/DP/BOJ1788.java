import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int abs = Math.abs(n);
        int dp[] = new int[abs + 1];

        if(n < 0){
            dp[0] = 0;
            dp[1] = 1;

            for(int i = 2; i <= abs; i++){
                dp[i] = (dp[i - 2] - dp[i - 1]) % MOD;
            }
        }else if(n > 0){
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i <= abs; i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }    
        }

        System.out.println(dp[abs] >= 0 ? dp[abs] == 0 ? 0 : 1 : -1);
        System.out.println(Math.abs(dp[abs]));
    }
}
