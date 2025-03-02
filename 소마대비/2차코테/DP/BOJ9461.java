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
            if(max < arr[i])
                max = arr[i];
        }

        long dp[] = new long[max + 1];

        if(max >= 4){
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            for(int i = 4; i <= max; i++){
                dp[i] = dp[i - 2] + dp[i - 3];
            }
        }else{
            for(int i = 1; i <= max; i++){
                dp[i] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            System.out.println(dp[arr[i]]);
        }
    }
}

