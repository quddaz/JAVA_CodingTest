import java.io.*;
import java.util.*;

public class Main {
    static int N, Q, size;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = 1 << N;

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            fireStorm(L);
        }

        System.out.println(sumIce());
        System.out.println(largestIce());
    }

    static void fireStorm(int L) {
        rotate(L);
        melt();
    }

    static void rotate(int L) {
        int len = 1 << L;
        if (len == 1) return;

        int[][] temp = new int[size][size];

        for (int r = 0; r < size; r += len) {
            for (int c = 0; c < size; c += len) {
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        temp[r + j][c + len - 1 - i] = map[r + i][c + j];
                    }
                }
            }
        }
        map = temp;
    }

    static void melt() {
        List<int[]> meltList = new ArrayList<>();

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (map[r][c] == 0) continue;

                int cnt = 0;
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
                    if (map[nr][nc] > 0) cnt++;
                }

                if (cnt < 3) meltList.add(new int[]{r, c});
            }
        }

        for (int[] p : meltList) {
            map[p[0]][p[1]]--;
        }
    }

    static int sumIce() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    static int largestIce() {
        boolean[][] visited = new boolean[size][size];
        int max = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    max = Math.max(max, bfs(i, j, visited));
                }
            }
        }
        return max;
    }

    static int bfs(int sr, int sc, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
                if (visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                cnt++;
            }
        }
        return cnt;
    }
}
