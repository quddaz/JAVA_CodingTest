import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int length = str.length();
        int dp[] = new int[length + 1];

        dp[0] = 1;
        dp[1] = (str.charAt(0) != '0' ? 1 : 0);

        for(int i = 2; i <= length; i++){
            if(str.charAt(i - 1) != '0'){
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }

            int num = Integer.parseInt(str.substring(i - 2, i));
            if(num >= 10 && num <= 26){
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }

        System.out.println(dp[length]);

    }
}
