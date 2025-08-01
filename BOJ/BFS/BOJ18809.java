import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] colorMap;
    static int[][] timeMap;
    static int n, m, g, r;
    static List<int[]> ground = new ArrayList<>();
    static int result = 0;
    static List<int[]> greenList = new ArrayList<>();
    static List<int[]> redList = new ArrayList<>();
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static class Cell {
        int x, y, time, color; 
        Cell(int x, int y, int time, int color) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        g = Integer.parseInt(st.nextToken()); 
        r = Integer.parseInt(st.nextToken()); 

        map = new int[n][m];
        colorMap = new int[n][m];
        timeMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    ground.add(new int[]{i, j}); 
                }
            }
        }

        dfs(0, 0, 0, new boolean[ground.size()]);
        System.out.println(result);
    }

    public static void dfs(int start, int greenCount, int redCount, boolean[] visited) {
        if (greenCount == g && redCount == r) {
            bfs();
            return;
        }

        for (int i = start; i < ground.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;

            int[] pos = ground.get(i);
            int y = pos[0];
            int x = pos[1];

            if (greenCount < g) {
                greenList.add(new int[]{y, x});
                dfs(i + 1, greenCount + 1, redCount, visited);
                greenList.remove(greenList.size() - 1);
            }

            if (redCount < r) {
                redList.add(new int[]{y, x});
                dfs(i + 1, greenCount, redCount + 1, visited);
                redList.remove(redList.size() - 1);
            }

            visited[i] = false;
        }
    }

    public static void bfs() {
        int count = 0;
        Queue<Cell> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(colorMap[i], 0);
            Arrays.fill(timeMap[i], -1);
        }

        for (int[] pos : greenList) {
            int y = pos[0], x = pos[1];
            q.offer(new Cell(x, y, 0, 1));
            colorMap[y][x] = 1;
            timeMap[y][x] = 0;
        }

        for (int[] pos : redList) {
            int y = pos[0], x = pos[1];
            q.offer(new Cell(x, y, 0, 2));
            colorMap[y][x] = 2;
            timeMap[y][x] = 0;
        }

        while (!q.isEmpty()) {
            Cell cur = q.poll();

            if (colorMap[cur.y][cur.x] == 3) continue;

            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (map[ny][nx] == 0) continue;
                if (colorMap[ny][nx] == 3) continue;

                if (colorMap[ny][nx] == 0) {
                    colorMap[ny][nx] = cur.color;
                    timeMap[ny][nx] = cur.time + 1;
                    q.offer(new Cell(nx, ny, cur.time + 1, cur.color));
                } else if (colorMap[ny][nx] != cur.color && timeMap[ny][nx] == cur.time + 1) {
                    colorMap[ny][nx] = 3; // 꽃
                    count++;
                }
            }
        }

        result = Math.max(result, count);
    }
}
