import java.io.*;
import java.util.*;

public class Main {
    static int N, M, H;
    static boolean[][] ladder;
    static int answer = 4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        for (int cnt = 0; cnt <= 3; cnt++) {
            dfs(0, 1, 1, cnt);
            if (answer != 4) break;
        }

        System.out.println(answer == 4 ? -1 : answer);
    }

    static void dfs(int count, int x, int y, int goal) {
        if (count == goal) {
            if (check()) {
                answer = Math.min(answer, count);
            }
            return;
        }

        for (int i = x; i <= H; i++, y = 1) {
            for (int j = y; j < N; j++) {
                if (canPlace(i, j)) {
                    ladder[i][j] = true;
                    dfs(count + 1, i, j + 2, goal);
                    ladder[i][j] = false;
                }
            }
        }
    }

    static boolean canPlace(int a, int b) {
        if (ladder[a][b]) return false;
        if (b > 1 && ladder[a][b - 1]) return false;
        if (b < N - 1 && ladder[a][b + 1]) return false;
        return true;
    }

    static boolean check() {
        for (int i = 1; i <= N; i++) {
            int pos = i;
            for (int h = 1; h <= H; h++) {
                if (ladder[h][pos]) pos++;
                else if (pos > 1 && ladder[h][pos - 1]) pos--;
            }
            if (pos != i) return false;
        }
        return true;
    }
}
