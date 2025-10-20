import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static double[] p = {0.05, 0.1, 0.1, 0.02, 0.02, 0.07, 0.07, 0.01, 0.01};
    static int[][] m_dy = {
        {0, -1, 1, -2, 2, -1, 1, -1, 1, 0},
        {2, 1, 1, 0, 0, 0, 0, -1, -1, 1},
        {0, -1, 1, -2, 2, -1, 1, -1, 1, 0},
        {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1}
    };
    static int[][] m_dx = {
        {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1},
        {0, -1, 1, -2, 2, -1, 1, -1, 1, 0},
        {2, 1, 1, 0, 0, 0, 0, -1, -1, 1},
        {0, -1, 1, -2, 2, -1, 1, -1, 1, 0}
    };
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long result = simulate();
        System.out.println(result);
    }

    static long simulate() {
        long out = 0L;
        int y = N / 2;
        int x = N / 2;
        int dir = 0;
        int dist = 1;
        int cnt = 0;
        while (true) {
            cnt++;
            for (int i = 0; i < dist; i++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                int aTotal = map[ny][nx];
                if (aTotal != 0) {
                    int moved = 0;
                    for (int j = 0; j < 9; j++) {
                        int mny = ny + m_dy[dir][j];
                        int mnx = nx + m_dx[dir][j];
                        int sand = (int)(aTotal * p[j]);
                        moved += sand;
                        if (mny < 0 || mnx < 0 || mny >= N || mnx >= N) {
                            out += sand;
                        } else {
                            map[mny][mnx] += sand;
                        }
                    }
                    int ay = ny + m_dy[dir][9];
                    int ax = nx + m_dx[dir][9];
                    int alpha = aTotal - moved;
                    if (ay < 0 || ax < 0 || ay >= N || ax >= N) {
                        out += alpha;
                    } else {
                        map[ay][ax] += alpha;
                    }
                }
                map[ny][nx] = 0;
                y = ny;
                x = nx;
                if (y == 0 && x == 0) return out;
            }
            if (cnt == 2) {
                dist++;
                cnt = 0;
            }
            dir = (dir + 1) % 4;
        }
    }
}
