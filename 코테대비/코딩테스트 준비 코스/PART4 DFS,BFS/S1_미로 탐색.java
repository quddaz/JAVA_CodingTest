import java.util.*;
import java.io.*;

public class S1_2178 {
    static int[][] map;
    static boolean[][] visited;
    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static boolean isValid(int x, int y) {
        return x >= 1 && x <= N && y >= 1 && y <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j-1) - '0'; // Adjusted index to start from 0 in string
            }
        }

        bfs(1, 1);
        System.out.println(map[N][M]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] data = q.poll();
            for (int i = 0; i < dx.length; i++) {
                int move_x = data[0] + dx[i];
                int move_y = data[1] + dy[i];
                if (isValid(move_x, move_y) && !visited[move_x][move_y] && map[move_x][move_y] != 0) {
                    visited[move_x][move_y] = true;
                    map[move_x][move_y] = map[data[0]][data[1]] + 1;
                    q.add(new int[]{move_x, move_y});
                }
            }
        }
    }
}