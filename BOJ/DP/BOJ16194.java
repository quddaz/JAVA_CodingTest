import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n + 1];
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 10000 * 1000 + 1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        

        for(int i = 1; i <= n; i++){
            for(int  j = i; j <= n; j++){
                dp[j] = Math.min(dp[j], dp[j - i] + arr[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
