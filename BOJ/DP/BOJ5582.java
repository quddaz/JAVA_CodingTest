import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int dp[][] = new int[A.length() + 1][B.length() + 1];

        int max = 0;

        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i - 1) == B.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        System.out.println(max);
    }
}
