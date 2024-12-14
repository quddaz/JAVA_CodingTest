import java.io.*;
import java.util.*;

public class Main {
    static int move[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    static int N;
    static int map[][];  
    static int cnt[][];  
    static boolean visited[][];  
    static int count = 1; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        cnt = new int[N][N];
        visited = new boolean[N][N];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    bfsLabelIslands(i, j);
                }
            }
        }

        int minBridgeLength = Integer.MAX_VALUE;
        for (int i = 1; i < count; i++) {
            minBridgeLength = Math.min(minBridgeLength, bfsFindBridge(i));
        }

        System.out.println(minBridgeLength);
    }

    public static void bfsLabelIslands(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        cnt[x][y] = count;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0];
            int cy = point[1];

            for (int i = 0; i < move.length; i++) {
                int dx = cx + move[i][0];
                int dy = cy + move[i][1];

                if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited[dx][dy]) {
                    if (map[dx][dy] == 1) {
                        q.add(new int[]{dx, dy});
                        cnt[dx][dy] = count;
                        visited[dx][dy] = true;
                    }
                }
            }
        }
        count++; 
    }

    public static int bfsFindBridge(int islandNum) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited2 = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cnt[i][j] == islandNum) {
                    for (int k = 0; k < move.length; k++) {
                        int dx = i + move[k][0];
                        int dy = j + move[k][1];
                        if (dx >= 0 && dx < N && dy >= 0 && dy < N && cnt[dx][dy] == 0) {
                            q.add(new int[]{dx, dy, 0}); 
                            visited2[dx][dy] = true;
                        }
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int x = arr[0];
            int y = arr[1];
            int dist = arr[2];

            for (int i = 0; i < move.length; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (dx >= 0 && dx < N && dy >= 0 && dy < N && !visited2[dx][dy]) {
                    if (cnt[dx][dy] == 0) {
                        q.add(new int[]{dx, dy, dist + 1});
                        visited2[dx][dy] = true;
                    } else if (cnt[dx][dy] != islandNum) {
                        return dist + 1; 
                    }
                }
            }
        }

        return Integer.MAX_VALUE; 
    }
}
