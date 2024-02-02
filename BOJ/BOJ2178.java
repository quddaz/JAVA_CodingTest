import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 미로 탐색
public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static boolean[][] visit;

    public static void bfs(int[][] graph, int n, int m, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            for (int i = 0; i < 4; i++) {
                int move_x = data[0] + dx[i];
                int move_y = data[1] + dy[i];
                if (move_x >= 0 && move_y >= 0 && move_x < n && move_y < m) {
                    if (!visit[move_x][move_y] && graph[move_x][move_y] != 0) {
                        visit[move_x][move_y] = true;
                        graph[move_x][move_y] = graph[data[0]][data[1]] + 1;
                        queue.add(new int[]{move_x, move_y});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        visit = new boolean[n][m];
        bfs(graph, n, m, 0, 0);
        System.out.println(graph[n - 1][m - 1]);
    }
}