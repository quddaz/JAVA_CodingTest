import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            int dp[] = new int[m + 1];
            dp[0] = 1;
            for(int x = 0; x <= m; x++){
                if(x + 1 <= m){
                    dp[x + 1] += dp[x];
                }
                if(x + 2 <= m){
                    dp[x + 2] += dp[x];
                }
                if(x + 3 <= m){
                    dp[x + 3] += dp[x];
                }
            }

            System.out.println(dp[m]);
        }

    }
}
