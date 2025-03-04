import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n + 1];
        dp[1] = 1;
        if(n >= 2) dp[2] = 0;
        if(n >= 3) dp[3] = 1;
        if(n >= 4) dp[4] = 1;

        for(int i = 5; i <= n; i++){
            if(dp[i - 1] == 0 || dp[i - 3] == 0 || dp[i - 4] == 0)
                dp[i] = 1;
            else
                dp[i] = 0;
        }

        System.out.println(dp[n] == 1 ? "SK" : "CY");

    }

}
