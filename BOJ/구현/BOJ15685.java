import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0}; // → ↑ ← ↓
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            List<Integer> directions = new ArrayList<>();
            directions.add(d);

            for (int i = 0; i < g; i++) {
                int size = directions.size();
                for (int j = size - 1; j >= 0; j--) {
                    directions.add((directions.get(j) + 1) % 4);
                }
            }

            map[x][y] = true;
            for (int dir : directions) {
                x += dx[dir];
                y += dy[dir];
                if (x >= 0 && y >= 0 && x <= 100 && y <= 100) {
                    map[x][y] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
