import java.util.*;
import java.io.*;

class Main {
    static int R, C, K;
    static char map[][]; 
    static boolean visited[][]; 
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    static int result = 0; 
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        R = Integer.parseInt(st.nextToken()); 
        C = Integer.parseInt(st.nextToken()); 
        K = Integer.parseInt(st.nextToken()); 
        
        map = new char[R][C]; 
        visited = new boolean[R][C]; 
        
        for(int i = 0; i < R; i++){ 
            String str = br.readLine(); 
            for(int j = 0; j < C; j++){ 
                map[i][j] = str.charAt(j); 
            } 
        } 
        
        visited[R-1][0] = true; 
        dfs(R-1, 0, 1); 
        
        System.out.println(result); 
    } 

    public static void dfs(int x, int y, int count){ 
        if(x == 0 && y == C-1 && count == K){ 
            result++; 
            return; 
        }
        if(count >= K) 
            return; 
        
        for(int i = 0; i < 4; i++){ 
            int nx = x + move[i][0]; 
            int ny = y + move[i][1]; 
            if(0 <= nx && nx < R && 0 <= ny && ny < C && map[nx][ny] != 'T' && !visited[nx][ny]){
                visited[nx][ny] = true; 
                dfs(nx, ny, count + 1); 
                visited[nx][ny] = false; 
            }
        }
    }
}
