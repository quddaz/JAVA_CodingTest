import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[] dims;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        dims = new int[N + 1]; 
        dp = new int[N][N]; 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        dims[0] = Integer.parseInt(st.nextToken());
        dims[1] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dims[i + 1] = c;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + dims[i] * dims[k+1] * dims[j+1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N-1]);
    }
}
