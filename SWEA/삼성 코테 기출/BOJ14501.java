import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 2];
        Arrays.fill(dp, -1);
        dp[1] = 0;
        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (i + day <= n + 1) {
                dp[i + day] = Math.max(dp[i + day], dp[i] + count);
            }
        }
        System.out.println(Math.max(dp[n], dp[n + 1]));

    }
}
