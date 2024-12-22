import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        if(N % 2 == 1){
            System.out.println(0);
            return;
        }
        if(N == 0){
            System.out.println(1);
            return;
        }
        dp[0] = 1; 
        dp[1] = 0; 
        dp[2] = 3;  
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 2] * dp[2];
            for(int x = 4;  x <= i; x+=2){
                dp[i] += dp[i-x] * 2;
            }
        }

        System.out.println(dp[N]);
    }
}
