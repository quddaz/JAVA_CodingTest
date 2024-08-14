import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j, 0}); // (row, col, day)
                    visited[i][j] = true;
                }
            }
        }

        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int days = current[2];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (isValid(nx, ny) && box[nx][ny] == 0 && !visited[nx][ny]) {
                    box[nx][ny] = 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, days + 1});
                    maxDays = days + 1;
                }
            }
        }

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(maxDays);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
