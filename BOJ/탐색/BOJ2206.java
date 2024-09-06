import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][2]; // 벽을 부수지 않았을 때와 부수었을 때

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 1}); // {x, y, broken, distance}
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int broken = curr[2];
            int dist = curr[3];

            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 배열 범위 체크
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (map[nx][ny] == '1' && broken == 0 && !visited[nx][ny][1]) {
                        // 벽을 부수고 이동
                        visited[nx][ny][1] = true;
                        q.add(new int[]{nx, ny, 1, dist + 1});
                    } else if (map[nx][ny] == '0' && !visited[nx][ny][broken]) {
                        // 벽이 아니고 이동 가능
                        visited[nx][ny][broken] = true;
                        q.add(new int[]{nx, ny, broken, dist + 1});
                    }
                }
            }
        }

        // 목표 지점에 도달할 수 없을 때
        return -1;
    }
}