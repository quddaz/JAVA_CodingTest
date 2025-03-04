import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i * i <= n; i++){
            int temp = i * i;
            for(int j = 0; j <= n - temp; j++){
                if(dp[j] != Integer.MAX_VALUE)
                    dp[j + i * i] = Math.min(dp[j] + 1, dp[j + i * i]);
            }
        }

        System.out.println(dp[n]);
    }
}
