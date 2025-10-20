import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[19][19];
    static int[] dx = {0, 1, 1, -1};
    static int[] dy = {1, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    int color = board[i][j];
                    for (int d = 0; d < 4; d++) {
                        if (check(i, j, color, d)) {
                            System.out.println(color);
                            System.out.println((i + 1) + " " + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean check(int x, int y, int color, int dir) {
        int nx = x - dx[dir];
        int ny = y - dy[dir];
        if (inRange(nx, ny) && board[nx][ny] == color) return false;

        int cnt = 1;
        nx = x;
        ny = y;
        for (int i = 0; i < 4; i++) {
            nx += dx[dir];
            ny += dy[dir];
            if (!inRange(nx, ny) || board[nx][ny] != color) break;
            cnt++;
        }

        if (cnt == 5) {
            nx += dx[dir];
            ny += dy[dir];
            if (inRange(nx, ny) && board[nx][ny] == color) return false;
            return true;
        }
        return false;
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && x < 19 && y >= 0 && y < 19;
    }
}
