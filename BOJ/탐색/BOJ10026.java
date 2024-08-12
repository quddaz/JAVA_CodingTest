import java.io.*;

public class Main {
    static int N;
    static char greed[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean visited[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        greed = new char[N][N];
        visited = new boolean[N][N];
        
        for(int i = 0; i < N; i++) {
            greed[i] = br.readLine().toCharArray();
        }
        
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j, greed[i][j]);
                    result++;
                }
            }
        }
        
        visited = new boolean[N][N];
        
        int result2 = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs2(i, j, greed[i][j]);
                    result2++;
                }
            }
        }
        
        System.out.println(result + " " + result2);
    }
    
    public static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        
        for(int i = 0; i < dx.length; i++) {
            int move_x = x + dx[i];
            int move_y = y + dy[i];
            
            if(move_x >= 0 && move_x < N && move_y >= 0 && move_y < N && 
               !visited[move_x][move_y] && greed[move_x][move_y] == color) {
                dfs(move_x, move_y, color);
            }
        }
    }
    
    public static void dfs2(int x, int y, char color) {
        visited[x][y] = true;
        
        for(int i = 0; i < dx.length; i++) {
            int move_x = x + dx[i];
            int move_y = y + dy[i];
            
            if(move_x >= 0 && move_x < N && move_y >= 0 && move_y < N && 
               !visited[move_x][move_y] && 
               ((color == 'B' && greed[move_x][move_y] == 'B') ||
                (color != 'B' && (greed[move_x][move_y] == 'R' || greed[move_x][move_y] == 'G')))) {
                dfs2(move_x, move_y, color);
            }
        }
    }
}