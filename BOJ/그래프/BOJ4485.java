import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static int dp[][];
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            map = new int[n][n];
            dp = new int[n][n];
            for(int i = 0; i < dp.length; i++){
                Arrays.fill(dp[i],Integer.MAX_VALUE);
            }
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();

            sb.append("Problem ").append(count++).append(": ");
            sb.append(dp[n - 1][n - 1]).append("\n");
        }

        System.out.println(sb);
    }
    
    public static void bfs(){
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[] {0, 0, map[0][0]});
        dp[0][0] = map[0][0];
        
        while(!q.isEmpty()){
            int[] cnt = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int cost = cnt[2];
    
            for(int[] move : moves){
                int dx = x + move[0];
                int dy = y + move[1];
    
                if(dx >= 0 && dx < n && dy >= 0 && dy < n){
                    if(cost + map[dx][dy] < dp[dx][dy]){
                        dp[dx][dy] = cost + map[dx][dy];
                        q.add(new int[]{dx, dy, dp[dx][dy]});
                    }
                }
            }
        }
    }
    
}
