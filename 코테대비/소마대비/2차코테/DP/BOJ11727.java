import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];
        if(n == 1){
            System.out.println(1);
            return;
        }else if(n == 2){
            System.out.println(3);
            return;
        }

        dp[1] = 1;
        dp[2] = 3;
        int MOD = 10007;

        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % MOD;
        }

        System.out.println(dp[n]);
    }
}

