import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int map[] = new int[n];
        int dp[][] = new int[n][n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }

        for(int i = 0; i < n - 1 ; i++){
            if(map[i] == map[i + 1]){
                dp[i][i+1] = 1;
            }
        }

        for(int length = 2; length < n; length++){
            for(int i = 0; i <= n - length - 1 ; i++){
                int j = i + length;
                if(map[i] == map[j] && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

           sb.append(dp[a-1][b-1]).append("\n");
        }
        System.out.print(sb);
    }

}
