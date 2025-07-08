import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            int dp[][] = new int[m + 1][2];

            int arr[][] = new int[m + 1][2];
            for(int x = 0; x < 2; x++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int y = 1; y <= m; y++){
                    arr[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];

            for(int z = 2; z <= m; z++){
                dp[z][0] = Math.max(dp[z - 1][1], dp[z - 2][1]) + arr[z][0];
                dp[z][1] = Math.max(dp[z - 1][0], dp[z - 2][0]) + arr[z][1];
            }

            System.out.println(Math.max(dp[m][0], dp[m][1]));
        }
    }
}
