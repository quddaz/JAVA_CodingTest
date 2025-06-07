import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> waterQueue = new LinkedList<>();
    static Queue<Point> hogQueue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    hogQueue.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                } else if (map[i][j] == '*') {
                    waterQueue.offer(new Point(i, j, 0));
                }
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
        while (!hogQueue.isEmpty()) {
            // 1. 물 먼저 이동
            int wSize = waterQueue.size();
            for (int i = 0; i < wSize; i++) {
                Point p = waterQueue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = p.x + dx[dir];
                    int ny = p.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        waterQueue.offer(new Point(nx, ny, 0));
                    }
                }
            }

            // 2. 고슴도치 이동
            int hSize = hogQueue.size();
            for (int i = 0; i < hSize; i++) {
                Point p = hogQueue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int nx = p.x + dx[dir];
                    int ny = p.y + dy[dir];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (visited[nx][ny]) continue;
                    if (map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        hogQueue.offer(new Point(nx, ny, p.time + 1));
                    } else if (map[nx][ny] == 'D') {
                        return p.time + 1;
                    }
                }
            }
        }
        return -1; // 도달 못한 경우
    }

    static class Point {
        int x, y, time;
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
