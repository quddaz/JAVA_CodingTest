import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[] = new int[n + 1];

        for(int i = 1; i <= n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        int dp[][] = new int[n + 1][3];

        dp[1][1] = map[1];
        dp[1][2] = 0;


        for(int i = 2; i <= n; i++){
            dp[i][1] = Math.max(dp[i][1], Math.max(dp[i - 2][2], dp[i - 2][1]) + map[i]);
            dp[i][2] = Math.max(dp[i][2], dp[i-1][1] + map[i]);
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));

    }
}
