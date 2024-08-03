import java.io.*;
import java.util.*;

public class Main {
    static int A;
    static int num[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[A+1];
        num = new int[A+1];
        for(int i = 1; i <= A; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);

        for(int i = 1; i <=A; i++){
            for(int j = i; j <= A; j++){
                if(num[i] < num[j]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        int result = 0;
        for(int i = 1; i <=A; i++){
            result = Math.max(dp[i], result);
        }
        System.out.println(result);
    }
}
