import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int dp[] = new int[11];
        dp[0] = 1;

        for(int i = 0; i < 11; i++){
            for(int j = 1; j <= 3; j++){
                if(i + j < 11)
                    dp[i + j] += dp[i];
            }
        }

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}