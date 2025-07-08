import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int w = Integer.parseInt(br.readLine());

        int vip[] = new int[w];
        for(int i = 0; i < w; i++){
            vip[i] = Integer.parseInt(br.readLine());
        }

        int result = 1;
        int start = 1;

        for(int i = 0; i < w; i++){
            result *= dp[vip[i] - start];
            start = vip[i] + 1;
        }

        result *= dp[n - start + 1];

        System.out.println(result);
    }
}