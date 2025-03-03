import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 0;
        while(true){
            count++;
            int test = Integer.parseInt(br.readLine());
            if(test == 0) break;

            int arr[][] = new int[test + 1][3];
            int dp[][] = new int[test + 1][3];

            for(int i = 1; i <= test; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                arr[i][2] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0; i <= test; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            dp[1][1] = arr[1][1];

            for(int i = 1; i < test; i++){
                for(int j = 0; j < 3; j++){
                    if(dp[i][j] != Integer.MAX_VALUE){
                        switch (j) {
                            case 0:
                                dp[i + 1][j] = Math.min(dp[i + 1][j],dp[i][j] + arr[i + 1][j]);
                                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + arr[i][j + 1]);
                                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1]);
                                break;
                            case 1:
                                dp[i + 1][j] = Math.min(dp[i + 1][j],dp[i][j] + arr[i + 1][j]);
                                dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + arr[i + 1][j + 1]);
                                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + arr[i + 1][j - 1]);
                                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + arr[i][j + 1]);
                                break;
                            case 2:
                                dp[i + 1][j] = Math.min(dp[i + 1][j],dp[i][j] + arr[i + 1][j]);
                                dp[i + 1][j - 1] = Math.min(dp[i + 1][j - 1], dp[i][j] + arr[i + 1][j - 1]);
                                break;
                        }
                    }
                }
            }

            dp[test][1] = Math.min(dp[test][0] + arr[test][1], dp[test][1]);
            System.out.println(count + ". " + dp[test][1]);
        }

    }
}
