import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int result = 1;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static HashSet<Character> hs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        hs = new HashSet<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        hs.add(map[x][y]);

        for (int i = 0; i < dx.length; i++) {
            int move_x = x + dx[i];
            int move_y = y + dy[i];

            if (move_x >= 0 && move_x < R && move_y >= 0 && move_y < C) {
                if (!visited[move_x][move_y] && !hs.contains(map[move_x][move_y])) {
                    dfs(move_x, move_y, count + 1);
                }
            }
        }

        result = Math.max(result, count);

        visited[x][y] = false;
        hs.remove(map[x][y]);
    }
}