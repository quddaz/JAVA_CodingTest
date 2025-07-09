import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static boolean visited[][];
    static int maxValue = 0;
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    count++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxValue);
    }

    public static void bfs(int x, int y){
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] cnt = q.poll();

            for(int[] move : moves){
                int dx = cnt[0] + move[0];
                int dy = cnt[1] + move[1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy] && map[dx][dy] == 1){
                    visited[dx][dy] = true;
                    q.add(new int[]{dx,dy});
                    count++;
                }
            }
        }


        maxValue = Math.max(maxValue, count);
    }
}