import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            dp[i + 1] = (dp[i + 1] + dp[i]) % 15746;
            if(i + 2 <= n)
                dp[i + 2] = (dp[i + 2] + dp[i]) % 15746;
        }

        System.out.println(dp[n]);

    }
}