import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean dp[][] = new boolean[n][n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n - 1; i++)
            if(arr[i] == arr[i + 1]) dp[i][i + 1] = true;

        for(int len = 4; len <= n; len += 2){
            for(int start = 0; start <= n - len; start++){
                int end = start + len - 1;
                if(arr[start] == arr[end] && dp[start + 1][end - 1]) dp[start][end] = true;
            }
        }

        int result[] = new int[n];
        Arrays.fill(result, -1);


        for(int end = 1; end < n; end++){
            for(int start = 0; start <= end - 1; start += 2){
                if(dp[start][end]){
                    int prev = (start > 0) ? result[start - 1] : 0;
                    if(prev != -1){
                        result[end] = Math.max(result[end], prev + 1);
                    }
                }
            }
        }

        System.out.println(result[n - 1]);
    }
}

//짝수만 적용 dp
//겹치는 팰린드롬이 있으면 안되며 최대한 나눴을 때 가장 많아야함 그리드
