
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        int road[] = new int[n+1];

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + 1;
            road[i] = i-1;

            if(i % 2 == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                road[i] = i/2;
            }
            if(i % 3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                road[i] = i/3;
            }
        }

        System.out.println(dp[n]);

        int cnt = n;
        while(true){
            System.out.print(cnt+" ");
            if(cnt == 1) break;
            cnt = road[cnt];
        }
    }
}
