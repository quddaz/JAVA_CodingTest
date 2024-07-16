import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static boolean visited[][];
    static int N;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int maxResult = Integer.MIN_VALUE;
        for(int i = 0; i <= 100; i++){
            visited = new boolean[N][N];
            int count  = 0;
            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    if(!visited[x][y] && map[x][y] > i){
                        bfs(x,y,i);
                        count++;
                    }
                }
            }
            maxResult = Math.max(count, maxResult);
        }
        System.out.println(maxResult);
    }
    public static void dfs(int x, int y, int height){
        visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int move_x = x + dx[i];
            int move_y = y + dy[i];

            if(move_x >= 0 &&  move_y >= 0 && move_x < N && move_y < N){
                if(!visited[move_x][move_y] && map[move_x][move_y] > height){
                    dfs(move_x,move_y, height);
                }
            }
        }
    }
    public static void bfs(int x, int y, int height){
        visited[x][y] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] current = q.poll();
            int curX = current[0];
            int curY = current[1];

            for(int i = 0; i < 4; i++){
                int move_x = curX + dx[i];
                int move_y = curY + dy[i];
    
                if(move_x >= 0 &&  move_y >= 0 && move_x < N && move_y < N){
                    if(!visited[move_x][move_y] && map[move_x][move_y] > height){
                        q.add(new int[]{move_x,move_y});
                        visited[move_x][move_y] = true;
                    }
                }
            }
        }
    }
}
