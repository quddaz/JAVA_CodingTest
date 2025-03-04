import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++){
            int cnt = Integer.parseInt(br.readLine());
            int arr[] =  new int[cnt];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x = 0; x < cnt; x++){
                arr[x] = Integer.parseInt(st.nextToken());
            }

            int target = Integer.parseInt(br.readLine());
            int dp[] = new int[target + 1];
            dp[0] = 1;

            for(int x = 0; x < cnt; x++){
                for(int y = arr[x]; y <= target; y++){
                    dp[y] += dp[y - arr[x]];
                }
            }

            System.out.println(dp[target]);
        }
    }
}
