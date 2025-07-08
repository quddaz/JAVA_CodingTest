import java.util.Scanner;

public class S1_1303 {
    static char[][] map;
    static boolean[][] visited;
    static int M, N;

    // 배열 범위 체크
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int WPower = 0;
        int BPower = 0;

        map = new char[N][M];
        visited = new boolean[N][M];
        sc.nextLine(); // 개행 문자 소비

        for (int i = 0; i < M; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++) {
                map[j][i] = row.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'W' && !visited[i][j]) {
                    WPower += (int) Math.pow(dfs(i, j, "W"), 2);
                } else if (map[i][j] == 'B' && !visited[i][j]) {
                    BPower += (int) Math.pow(dfs(i, j, "B"), 2);
                }
            }
        }
        System.out.println(WPower + " " + BPower);
    }

    public static int dfs(int x, int y, String word) {
        visited[x][y] = true;
        int power = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (isValid(nx, ny) && map[nx][ny] == map[x][y] && !visited[nx][ny]) {
                power += dfs(nx, ny, word);
            }
        }
        return power;
    }
}