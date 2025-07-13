import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int n, m, result = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> cctv = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};
    static int[][][] directions = {
        {}, // 0번 CCTV는 없음
        {{0}, {1}, {2}, {3}}, // 1번 CCTV: 한 방향
        {{0, 2}, {1, 3}}, // 2번 CCTV: 양방향(반대 방향)
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV: 직각 방향
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV: 세 방향
        {{0, 1, 2, 3}} // 5번 CCTV: 모든 방향
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctv.add(new int[]{i, j, map[i][j]});
                }
            }
        }

        solve(0, map);
        System.out.println(result);
    }

    public static void solve(int depth, int[][] map) {
        if (depth == cctv.size()) {
            result = Math.min(result, countBlindSpots(map));
            return;
        }

        int[] current = cctv.get(depth);
        int x = current[0], y = current[1], type = current[2];

        for (int[] dirs : directions[type]) {
            int[][] tempMap = copyMap(map);
            for (int dir : dirs) {
                updateMap(tempMap, x, y, dir);
            }
            solve(depth + 1, tempMap);
        }
    }

    public static int countBlindSpots(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] copyMap(int[][] original) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }

    public static void updateMap(int[][] map, int x, int y, int dir) {
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 6) break; // 범위를 벗어나거나 벽(6)에서 멈춤
            if (map[x][y] == 0) map[x][y] = -1; // 감시 영역 표시
        }
    }
}
