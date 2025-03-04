import java.io.*;
import java.util.*;

public class Main {
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dp, map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;  
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) return 1;  
        if (dp[x][y] != -1) return dp[x][y];  

        dp[x][y] = 0; 

        for (int[] move : moves) {
            int dx = x + move[0];
            int dy = y + move[1];

            if (dx >= 0 && dx < n && dy >= 0 && dy < m && map[x][y] > map[dx][dy]) {
                dp[x][y] += dfs(dx, dy);
            }
        }
        return dp[x][y];
    }
}
