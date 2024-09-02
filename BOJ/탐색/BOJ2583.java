import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] grid;
    static boolean[][] visited;
    static int[] directions = {0, 1, 0, -1, 0}; // 오른쪽, 위쪽, 왼쪽, 아래쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    grid[y][x] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    areas.add(bfs(i, j));
                }
            }
        }

        Collections.sort(areas);
        bw.write(areas.size() + "\n");
        for (int area : areas) {
            bw.write(area + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        int area = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];
            area++;

            for (int d = 0; d < 4; d++) {
                int ny = y + directions[d];
                int nx = x + directions[d + 1];
                if (ny >= 0 && ny < M && nx >= 0 && nx < N && !visited[ny][nx] && grid[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    queue.add(new int[]{ny, nx});
                }
            }
        }

        return area;
    }
}
