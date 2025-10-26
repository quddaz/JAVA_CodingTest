import java.io.*;
import java.util.*;

public class Main {
    static int N, M, T;
    static int[][] castle;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        castle = new int[N][M];
        int gramX = -1, gramY = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
                if (castle[i][j] == 2) {
                    gramX = i;
                    gramY = j;
                }
            }
        }

        int[][] dist = bfsFromStart();
        int direct = dist[N-1][M-1];
        int toGram = -1;
        if (gramX != -1 && gramY != -1) toGram = dist[gramX][gramY];

        int viaGram = Integer.MAX_VALUE;
        if (toGram != -1) {
            int manhattan = Math.abs(N - 1 - gramX) + Math.abs(M - 1 - gramY);
            viaGram = toGram + manhattan;
        }

        int ans = Integer.MAX_VALUE;
        if (direct != -1) ans = Math.min(ans, direct);
        if (viaGram != Integer.MAX_VALUE) ans = Math.min(ans, viaGram);

        if (ans <= T) {
            System.out.println(ans);
        } else {
            System.out.println("Fail");
        }
    }

    static int[][] bfsFromStart() {
        int[][] dist = new int[N][M];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0] = 0;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (dist[nx][ny] != -1) continue;
                if (castle[nx][ny] == 1) continue;
                dist[nx][ny] = dist[cx][cy] + 1;
                q.add(new int[]{nx, ny});
            }
        }
        return dist;
    }
}
