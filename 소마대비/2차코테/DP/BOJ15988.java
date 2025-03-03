import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(arr[i], max);
        }

        int dp[] = new int[max + 1];
        dp[0] = 1;
        for(int x = 0; x <= max; x++){
            if(x + 1 <= max)
                dp[x + 1] = (dp[x + 1] + dp[x]) % MOD;
            if(x + 2 <= max)
                dp[x + 2] = (dp[x + 2] + dp[x]) % MOD;
            if(x + 3 <= max)
                dp[x + 3] = (dp[x + 3] + dp[x]) % MOD;
        }
        for(int i = 0; i < n; i++){
            System.out.println(dp[arr[i]]);
        }
    }
}
