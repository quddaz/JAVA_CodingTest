import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static char map[][];
    static int result = 0;
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 'L'){
                    result = Math.max(bfs(i,j), result);
                }
            }
        }
        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.offer(new int[]{x, y, 0});
        visited[x][y] = true;
    
        int max = 0;
    
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            max = Math.max(max, dist);
    
            for (int[] move : moves) {
                int dx = cx + move[0];
                int dy = cy + move[1];
    
                if (dx >= 0 && dx < N && dy >= 0 && dy < M && map[dx][dy] == 'L' && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    queue.offer(new int[]{dx, dy, dist + 1});
                }
            }
        }
        return max;
    }
}
