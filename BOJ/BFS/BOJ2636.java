import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int time = 0;
    static int lastCheese = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            int cheese = countCheese();
            if (cheese == 0) break;

            lastCheese = cheese;
            meltCheese();
            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }

    static int countCheese() {
        int count = 0;
        for (int[] row : map) {
            for (int cell : row) {
                if (cell == 1) count++;
            }
        }
        return count;
    }

    static void meltCheese() {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;

                if (map[nx][ny] == 1) {
                    // 치즈면 녹여버림
                    map[nx][ny] = 0;
                } else {
                    // 공기면 계속 확장
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
