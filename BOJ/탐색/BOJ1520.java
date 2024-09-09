import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int move_x = x + dx[i];
            int move_y = y + dy[i];

            if (move_x >= 0 && move_x < M && move_y >= 0 && move_y < N) {
                if (map[move_x][move_y] < map[x][y]) {
                    dp[x][y] += dfs(move_x, move_y);
                }
            }
        }

        return dp[x][y];
    }
}