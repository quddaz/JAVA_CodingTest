import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int map[] = new int[t];

        int max = 0;
        for(int i = 0; i < t; i++){
            map[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, map[i]);
        }

        if(max == 0){
            System.out.println(1 + " " + 0);
            return;
        }
        int dp[][] = new int[max + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for(int i = 2; i <= max; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++){
            sb.append(dp[map[i]][0]).append(" ").append(dp[map[i]][1]).append("\n");
        }

        System.out.println(sb);

    }
}