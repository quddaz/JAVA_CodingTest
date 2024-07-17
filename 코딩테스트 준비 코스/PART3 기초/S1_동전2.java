import java.io.*;
import java.util.*;

public class S1_2294{
    static int coin[];
    static int N, K;
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin); 
        
        dp = new int[K + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int j = 0; j < N; j++) {
            for (int i = coin[j]; i <= K; i++) {
                if (dp[i - coin[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        System.out.println(dp[K] != Integer.MAX_VALUE ? dp[K] : -1);

    }
}
