import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];

        if(n == 1 || n == 3){
            System.out.println("SK");
            return;
        }  

        if(n == 2){
            System.out.println("CY");
            return;
        }
        
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        for(int i = 4; i <= n; i++){
            dp[i] = 1 - dp[i-3];
        }
        

        if(dp[n] == 1)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
