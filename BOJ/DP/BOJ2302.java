import java.io.*;

public class Main {
    static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        
        int vip = Integer.parseInt(br.readLine());
        int l = 0;
        int r = 0;
        for(int i = 0; i < vip; i++){
            r = Integer.parseInt(br.readLine());
            ans *= dp[r - l - 1];
            l = r;
        }

        
        ans *= dp[n - r];

        System.out.println(ans);
    }
}
