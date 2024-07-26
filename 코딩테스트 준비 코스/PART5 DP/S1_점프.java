import java.io.*;
import java.util.*;

public class S1_1890 {
    static int[][] map;
    static long[][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dp[0][0] = 1;
        
        // DP 실행
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (dp[x][y] != 0 && map[x][y] != 0) {
                    int jump = map[x][y];
                    if (x + jump < N) {
                        dp[x + jump][y] += dp[x][y];
                    }
                    if (y + jump < N) {
                        dp[x][y + jump] += dp[x][y];
                    }
                }
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
