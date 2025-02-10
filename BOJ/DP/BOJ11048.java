import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        int dp[][] = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[n - 1][m - 1] = arr[n - 1][m - 1];
        for(int i = n -1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(i > 0){
                    dp[i - 1][j] = Math.max(dp[i - 1][j], dp[i][j] + arr[i - 1][j]);
                }
                if(j > 0){
                    dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i][j] + arr[i][j - 1]);
                }

                if(i > 0 && j > 0){
                    dp[i - 1][j - 1] = Math.max(dp[i - 1][j - 1], dp[i][j] + arr[i - 1][j - 1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }

}
