import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static int map[][];
    static int result = Integer.MIN_VALUE;
    static boolean flag;
    static boolean visited[][];
    static int dp[][];
    static int[][] move = {{1,0},{-1,0},{0, 1},{0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                char temp = str.charAt(j);
                if(temp == 'H')
                    map[i][j] = 0;
                else
                    map[i][j] = temp - '0';
            }
        }
        visited = new boolean[n][m];
        visited[0][0] = true;
        dfs(0, 0, 1);

        System.out.println(flag?-1:result);
    }
    public static void dfs(int x, int y, int count){
        if(result < count)
            result = count;

        dp[x][y] = count;

        for(int i =0; i<4; i++){
            int nx = x + move[i][0] * map[x][y];
            int ny = y + move[i][1] * map[x][y];
            if(0<=nx && nx<n && 0<=ny && ny<m && map[nx][ny] != 0){
                if(visited[nx][ny]){
                    flag = true;
                    return;
                }
                if(dp[nx][ny] > count)
                    continue;
                visited[nx][ny] = true;
                dfs(nx, ny, count+1);
                visited[nx][ny] = false;
            }
        }

    }
}
