import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 40000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        
        boolean[][] dp = new boolean[N+1][MAX+1];
        dp[0][0] = true; 
        
        for (int i=1; i<=N; i++) {
            int w = weights[i];
            for (int j=0; j<=MAX; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                    
                    if (j + w <= MAX)
                        dp[i][j + w] = true;
                    
                    int diff = Math.abs(j - w);
                    dp[i][diff] = true;
                }
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        while (T-- > 0) {
            int bead = Integer.parseInt(st.nextToken());
            if (bead > MAX) {
                sb.append("N ");
            } else {
                sb.append(dp[N][bead] ? "Y " : "N ");
            }
        }
        
        System.out.println(sb.toString().trim());
    }
}
