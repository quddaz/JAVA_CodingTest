import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == 1 || K == 0){
            System.out.println(1);
            return;
        }
        
        int dp[][] = new int[N+1][K+1];
        dp[1][1] = 1;
        dp[1][0] = 1;
        for(int i = 2; i <= N; i++){
            dp[i][0] = 1;
            for(int j = 1; j <= K; j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1]) % 10007;
            }
        }

        System.out.println(dp[N][K]);

    }
}
