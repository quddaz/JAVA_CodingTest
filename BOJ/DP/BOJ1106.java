import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int dp[] = new int[c + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int arr[][] = new int[n][2];
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
        }
        for(int i = 0; i < c; i++){
            for(int[] num : arr){
                if(dp[i] != Integer.MAX_VALUE){
                    if(i + num[1] < c){
                         dp[i + num[1]] = Math.min(dp[i] + num[0], dp[i + num[1]]);
                    }else
                        dp[c] =  Math.min(dp[i] + num[0], dp[c]);
                }
            }
        }
        System.out.println(dp[c]);

    }
}
