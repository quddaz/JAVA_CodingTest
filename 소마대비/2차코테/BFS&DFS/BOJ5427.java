import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n, m;
    static boolean[][] visited;
    static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<int[]> personQueue = new LinkedList<>();
            visited = new boolean[n][m];
            map = new int[n][m];

            for (int x = 0; x < n; x++) {
                String str = br.readLine();
                for (int y = 0; y < m; y++) {
                    char c = str.charAt(y);
                    if (c == '#') {
                        map[x][y] = -1; // 벽
                        visited[x][y] = true;
                    } else if (c == '*') {
                        map[x][y] = 1;
                        fireQueue.add(new int[]{x, y, 0});
                        visited[x][y] = true;
                    } else if (c == '@') {
                        personQueue.add(new int[]{x, y, 0});
                    }
                }
            }

            while (!fireQueue.isEmpty()) {
                int[] fire = fireQueue.poll();
                for (int[] move : moves) {
                    int dx = fire[0] + move[0];
                    int dy = fire[1] + move[1];

                    if (dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        fireQueue.add(new int[]{dx, dy, fire[2] + 1});
                        map[dx][dy] = fire[2] + 1;
                    }
                }
            }

            visited = new boolean[n][m];
            boolean flag = false;
            while (!personQueue.isEmpty()) {
                int[] person = personQueue.poll();
                visited[person[0]][person[1]] = true;

                for (int[] move : moves) {
                    int dx = person[0] + move[0];
                    int dy = person[1] + move[1];

                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) { 
                        System.out.println(person[2] + 1);
                        personQueue.clear();
                        flag = true;
                        break;
                    }

                    if (!visited[dx][dy] && (map[dx][dy] == 0 || map[dx][dy] > person[2] + 1)) {
                        visited[dx][dy] = true;
                        personQueue.add(new int[]{dx, dy, person[2] + 1});
                    }
                }
            }

            if(!flag)
                System.out.println("IMPOSSIBLE");
        }
    }
}
