import java.io.*;
import java.util.*;

public class G5_5557 {
    static long dp[][];
    static int N;
    static int num[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        dp = new long[N + 1][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dp[1][num[1]] = 1;

        for(int i = 1; i < N; i++){
            for(int j = 0; j <= 20; j++){
                if(dp[i][j] != 0){
                    if(j + num[i + 1] <= 20){
                        dp[i + 1][j + num[i + 1]] += dp[i][j];
                    }
                    if (j - num[i + 1] >= 0) {
                        dp[i + 1][j - num[i + 1]] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[N-1][num[N]]);
    }
}