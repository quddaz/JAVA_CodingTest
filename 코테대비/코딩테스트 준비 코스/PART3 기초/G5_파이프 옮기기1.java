import java.io.*;
import java.util.StringTokenizer;

public class G5_17070 {
    static int[][] map;
    static int N;
    static int result = 0;

    // 방향을 나타내는 상수
    static final int HORIZONTAL = 0;
    static final int VERTICAL = 1;
    static final int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 상태: (0, 1)까지 가로로 놓여있는 파이프
        dfs(0, 1, HORIZONTAL);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int direction) {
        // 도착 지점에 도달하면 결과 증가
        if (x == N - 1 && y == N - 1) {
            result++;
            return;
        }

        switch (direction) {
            case HORIZONTAL:
                // 가로 -> 가로
                if (y + 1 < N && map[x][y + 1] == 0) {
                    dfs(x, y + 1, HORIZONTAL);
                }
                // 가로 -> 대각선
                if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                    dfs(x + 1, y + 1, DIAGONAL);
                }
                break;
            case VERTICAL:
                // 세로 -> 세로
                if (x + 1 < N && map[x + 1][y] == 0) {
                    dfs(x + 1, y, VERTICAL);
                }
                // 세로 -> 대각선
                if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                    dfs(x + 1, y + 1, DIAGONAL);
                }
                break;
            case DIAGONAL:
                // 대각선 -> 가로
                if (y + 1 < N && map[x][y + 1] == 0) {
                    dfs(x, y + 1, HORIZONTAL);
                }
                // 대각선 -> 세로
                if (x + 1 < N && map[x + 1][y] == 0) {
                    dfs(x + 1, y, VERTICAL);
                }
                // 대각선 -> 대각선
                if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y] == 0 && map[x + 1][y + 1] == 0) {
                    dfs(x + 1, y + 1, DIAGONAL);
                }
                break;
        }
    }
}