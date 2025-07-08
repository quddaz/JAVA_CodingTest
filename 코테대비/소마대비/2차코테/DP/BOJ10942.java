import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n + 1];
        int dp[][] = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            dp[i][i] = 1;
        }

        for(int i = 1; i < n; i++){
            if(arr[i] == arr[i + 1])
                dp[i][i + 1] = 1;
        }

        for(int i = 2; i < n; i++){
            for(int x = 1; x <= n - i; x++){
                int y = x + i;
                if(arr[x] == arr[y] && dp[x + 1][y - 1] == 1){
                    dp[x][y] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}
