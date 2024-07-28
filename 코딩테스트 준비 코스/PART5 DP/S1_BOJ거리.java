import java.io.*;
import java.util.*;

public class S1_12026 {
    static int dp[];
    static char c[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        dp = new int[N+1];
        c = new char[N+1];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0; 
        
        //배열 전처리 
        for(int i = 1; i <= N; i++){
            c[i] = str.charAt(i-1);
        }
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0; 


        //메인로직
        for(int i = 1; i <= N; i++){
            if (dp[i] == Integer.MAX_VALUE) {
                continue; 
            }
            char point = c[i];
            for(int j = i + 1; j <= N; j++){
                if((point == 'B' && c[j] == 'O') || (point == 'O' && c[j] == 'J') || (point == 'J' && c[j] == 'B')){
                    dp[j] = Math.min(dp[j], dp[i] + (j-i) * (j-i));
                }
            }
        }
        
        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
    }
}
