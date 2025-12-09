import java.util.*;
class Solution {
    static int map[][] = new int[102][102];
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean visited[][];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for(int[] rect : rectangle){
            int minX = rect[0] * 2;
            int minY = rect[1] * 2;
            int maxX = rect[2] * 2;
            int maxY = rect[3] * 2;
            
            for (int x = minX; x <= maxX; x++) {
                for (int y = minY; y <= maxY; y++)
                    if((x == minX || x == maxX || y == minY || y == maxY) && map[x][y] != 2)
                        map[x][y] = 1;
                    else 
                        map[x][y] = 2;
             }
        }
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    public static int bfs(int characterX, int characterY, int itemX, int itemY){
        visited = new boolean[102][102];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX, characterY, 0});
        visited[characterX][characterY] = true;
        
        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int count = cnt[2];
            if(x == itemX && y == itemY) return count/2;
            for(int[] move : moves){
                int dx = x + move[0];
                int dy = y + move[1];
                if(!visited[dx][dy] && map[dx][dy] == 1){
                    visited[dx][dy] = true;
                    q.add(new int[]{dx,dy, count + 1});
                }
            }
        }
        return -1;
    }
}