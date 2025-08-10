import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> virusList = new ArrayList<>();
    static int emptyCount = 0;
    static int minTime = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) virusList.add(new int[]{i, j});
                else if (lab[i][j] == 0) emptyCount++;
            }
        }

        if (emptyCount == 0) { // 빈 칸이 없는 경우
            System.out.println(0);
            return;
        }

        combination(0, 0, new int[M]); // M개 바이러스 선택
        System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
    }

    static void combination(int start, int depth, int[] selected) {
        if (depth == M) {
            bfs(selected);
            return;
        }
        for (int i = start; i < virusList.size(); i++) {
            selected[depth] = i;
            combination(i + 1, depth + 1, selected);
        }
    }

    static void bfs(int[] selected) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        int remain = emptyCount;
        int time = 0;

        for (int idx : selected) {
            int[] v = virusList.get(idx);
            q.offer(new int[]{v[0], v[1], 0});
            visited[v[0]][v[1]] = true;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], t = cur[2];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny] || lab[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                if (lab[nx][ny] == 0) { // 빈 칸 감염
                    remain--;
                    time = t + 1;
                    if (remain == 0) {
                        minTime = Math.min(minTime, time);
                        return;
                    }
                }
                q.offer(new int[]{nx, ny, t + 1});
            }
        }
    }
}
