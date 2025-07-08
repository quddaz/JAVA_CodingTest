import java.io.*;
import java.util.*;

public class S1_1743 {
    static int N, M, K;
    static boolean[][] visited;
    static int[][] map;
    static int result = Integer.MIN_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1)
                    result = Math.max(result, dfs(i, j));
            }
        }
        System.out.println(result);
    }

    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;

        for(int i = 0; i < dx.length; i++){
            int move_x = x + dx[i];
            int move_y = y + dy[i];
            if(isValid(move_x, move_y) && !visited[move_x][move_y] && map[move_x][move_y] == 1){
                count += dfs(move_x, move_y);
            }
        }
        return count;
    }

    public static boolean isValid(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < M; 
    }
}