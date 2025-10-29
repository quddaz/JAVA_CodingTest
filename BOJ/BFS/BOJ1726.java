import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};
    
    static class State {
        int x, y, dir, cnt;
        State(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
    
    static int turnLeft(int d) {
        if (d == 1) return 4;
        if (d == 2) return 3;
        if (d == 3) return 1;
        return 2;
    }

    static int turnRight(int d) {
        if (d == 1) return 3;
        if (d == 2) return 4;
        if (d == 3) return 2;
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1][5];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());
        int sd = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sx, sy, sd, ex, ey, ed));
    }

    static int bfs(int sx, int sy, int sd, int ex, int ey, int ed) {
        Queue<State> q = new LinkedList<>();
        q.offer(new State(sx, sy, sd, 0));
        visited[sx][sy][sd] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.x == ex && cur.y == ey && cur.dir == ed) {
                return cur.cnt;
            }

            int left = turnLeft(cur.dir);
            int right = turnRight(cur.dir);
            if (!visited[cur.x][cur.y][left]) {
                visited[cur.x][cur.y][left] = true;
                q.offer(new State(cur.x, cur.y, left, cur.cnt + 1));
            }
            if (!visited[cur.x][cur.y][right]) {
                visited[cur.x][cur.y][right] = true;
                q.offer(new State(cur.x, cur.y, right, cur.cnt + 1));
            }

            for (int k = 1; k <= 3; k++) {
                int nx = cur.x + dx[cur.dir] * k;
                int ny = cur.y + dy[cur.dir] * k;

                if (nx < 1 || ny < 1 || nx > M || ny > N || map[nx][ny] == 1)
                    break;

                if (!visited[nx][ny][cur.dir]) {
                    visited[nx][ny][cur.dir] = true;
                    q.offer(new State(nx, ny, cur.dir, cur.cnt + 1));
                }
            }
        }
        return -1;
    }
}
