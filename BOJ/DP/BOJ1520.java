import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[][];
    static int map[][];
    static int move[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dp = new int[n][m];
        map = new int[n][m];
        for(int[] nu : dp){
            Arrays.fill(nu, -1);
        }

        dp[n-1][m-1] = 1;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dfs(0, 0));

    }

    public static int dfs(int x, int y){
        if(x == n-1 && y == m-1)
            return 1;
        
        if(dp[x][y] != -1)
            return dp[x][y];

        dp[x][y] = 0;
        for(int i = 0; i < move.length; i++){
            int dx = x + move[i][0];
            int dy = y + move[i][1];

            if(dx < 0 || dx >= n || dy < 0 || dy >= m || map[dx][dy] >= map[x][y])
                continue;
            
            dp[x][y] += dfs(dx,dy);
        }

        return dp[x][y];
    }
}