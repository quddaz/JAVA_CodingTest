import java.io.*;
import java.util.*;

public class S1_2293{
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
        
        dp = new int[K+1];
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if (coin[i] <= j) {
					dp[j] += dp[j-coin[i]];
				}
			}
		}
		System.out.println(dp[K]);
    }
}