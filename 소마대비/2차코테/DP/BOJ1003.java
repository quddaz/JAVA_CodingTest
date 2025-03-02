import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        int max = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i] > max)
                max = arr[i];
        }

        int dp[][] = new int[max + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;
        if(max > 0){
            dp[1][0] = 0;
            dp[1][1] = 1;
    
            for(int i = 2; i <= max; i++){
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            
        }

        for(int i = 0; i < n; i++){
            int cnt = arr[i];
            System.out.println(dp[cnt][0] + " " + dp[cnt][1]);
        }
    }
}

