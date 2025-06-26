import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] A;
    static boolean[][] visited;
    static List<int[]> clouds;

    static int[] dr = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] diagR = {-1, -1, 1, 1};
    static int[] diagC = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds = new ArrayList<>();
        clouds.add(new int[]{N - 1, 0});
        clouds.add(new int[]{N - 1, 1});
        clouds.add(new int[]{N - 2, 0});
        clouds.add(new int[]{N - 2, 1});

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            move(d, s);
            waterCopy();
            makeNewClouds();
        }

        int result = 0;
        for (int[] row : A) {
            for (int val : row) {
                result += val;
            }
        }
        System.out.println(result);
    }

    static void move(int d, int s) {
        List<int[]> newClouds = new ArrayList<>();
        visited = new boolean[N][N];

        for (int[] cloud : clouds) {
            int r = (cloud[0] + dr[d] * s) % N;
            int c = (cloud[1] + dc[d] * s) % N;
            if (r < 0) r += N;
            if (c < 0) c += N;
            A[r][c]++;
            visited[r][c] = true;
            newClouds.add(new int[]{r, c});
        }

        clouds = newClouds;
    }

    static void waterCopy() {
        for (int[] cloud : clouds) {
            int r = cloud[0];
            int c = cloud[1];
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nr = r + diagR[i];
                int nc = c + diagC[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && A[nr][nc] > 0) {
                    cnt++;
                }
            }
            A[r][c] += cnt;
        }
    }

    static void makeNewClouds() {
        List<int[]> newClouds = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && A[i][j] >= 2) {
                    A[i][j] -= 2;
                    newClouds.add(new int[]{i, j});
                }
            }
        }
        clouds = newClouds;
    }
}
