import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int moves[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];

        int count = 0;
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                int tmp = Integer.parseInt(st.nextToken());
                map[i][j] = tmp;

                if(tmp == 1) count++;
            }
        }

        int result = 0;
        while(count > 0){
            result++;
            bfs(); 
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    if(map[i][j] == 1){
                        int tmp = 0;
                        for(int[] move: moves){
                            int dx = i + move[0];
                            int dy = j + move[1];
                
                            if(dx >= 1 && dx <= n && dy >= 1 && dy <= m){
                                if(map[dx][dy] == -1) tmp++;
                            }
                        }
                        if(tmp >= 2){
                            count--;
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n + 1][m + 1]; 
        queue.add(new int[]{0, 0}); 
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int[] move : moves) {
                int dx = x + move[0];
                int dy = y + move[1];

                if (dx >= 0 && dx <= n && dy >= 0 && dy <= m && !visited[dx][dy] && map[dx][dy] != 1) {
                    visited[dx][dy] = true;
                    queue.add(new int[]{dx, dy});
                    if (map[dx][dy] == 0) {
                        map[dx][dy] = -1;
                    }
                }
            }
        }
    }
}
