import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int n = board.length;
        int dp[][][] = new int[board.length][board.length][4];
        
        for(int[][] map : dp){
            for(int[] m : map)
                Arrays.fill(m, Integer.MAX_VALUE);
        }
        Arrays.fill(dp[0][0], 0);
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < 4; i++){
            q.add(new int[]{0,0,i,0});
        }
        
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int x = arr[0];
            int y = arr[1];
            int flag = arr[2];
            int count = arr[3];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int cost = count;
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                
                if(flag == i)
                    cost += 100;
                else
                    cost += 600;
                
                if(dp[nx][ny][i] > cost){
                    dp[nx][ny][i] = cost;
                    q.add(new int[]{nx,ny,i,cost});
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++){
            min = Math.min(min, dp[n-1][n-1][i]);
        }
        
        return min;
    }
}