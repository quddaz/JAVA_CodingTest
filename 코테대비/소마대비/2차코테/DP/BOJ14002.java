import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[a];
        int dp[] = new int[a];
        int prev[] = new int[a];

        for(int i = 0; i < a; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            prev[i] = -1;
        }
        int max = 1;
        int lastIndex = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1){
                    dp[i] =  dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        System.out.println(max);
        StringBuilder sb = new StringBuilder();

        while(lastIndex != -1){
            sb.insert(0, arr[lastIndex] + " ");
            lastIndex = prev[lastIndex];
        }

        System.out.println(sb);
    }
}
