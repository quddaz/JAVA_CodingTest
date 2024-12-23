import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int dp[][] = new int[n+1][m+1];

        for(int i = 1; i <= n ; i++) dp[i][1] = i;

        for(int i = 4; i <= n; i++){
            for(int j = 2; j <= m; j++){
                if (j > i / 2) break;
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % 1000000003;
            }
        }
        
        System.out.println(dp[n][m]);
    }
}
