import java.io.*;
import java.util.*;

public class Main {
    static int[][] forest;
    static int[][] dp;
    static int n;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxSteps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSteps = Math.max(maxSteps, dfs(i, j));
            }
        }
        
        System.out.println(maxSteps);
    }
    
    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];
        
        dp[x][y] = 1; // 현재 위치 포함
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && forest[nx][ny] > forest[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }
        
        return dp[x][y];
    }
}
