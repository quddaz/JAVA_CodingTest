import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n + 1];
        int road[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        Queue<Integer> q= new LinkedList<>();
        q.add(n);
        while(!q.isEmpty()){
            int cnt = q.poll();

            if(cnt % 3 == 0 && dp[cnt / 3] > dp[cnt] + 1){
                dp[cnt / 3] = dp[cnt] + 1;
                road[cnt / 3] = cnt;
                q.add(cnt / 3);
            }
            if(cnt % 2 == 0 && dp[cnt / 2] > dp[cnt] + 1){
                dp[cnt / 2] = dp[cnt] + 1;
                road[cnt / 2] = cnt;
                q.add(cnt / 2);
            }
            if(cnt - 1 >= 1 && dp[cnt - 1] > dp[cnt] + 1){
                dp[cnt - 1] = dp[cnt] + 1;
                road[cnt - 1] = cnt;
                q.add(cnt - 1);
            }
        }


        System.out.println(dp[1]);

        int temp = 1;
        StringBuilder sb = new StringBuilder();
        while (temp != n) { 
            sb.insert(0, temp + " ");
            temp = road[temp];
        }
        sb.insert(0, n + " "); 

        System.out.println(sb);
    }
        
}

